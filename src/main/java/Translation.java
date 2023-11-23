import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Objects;

public class Translation {

    public static void getTranslation(String country) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] certs = trustAllCerts();
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(SSLSocket(certs), (X509TrustManager) certs[0])
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "api_token=b6fab07bb4b65cb7c1c6a97a7cb0d4e1&id=663235&language="+country);
        Request request = new Request.Builder()
                .url("https://api.poeditor.com/v2/terms/list")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        String out = response.body().string();
        Creator.createFile(out,country);
    }



    public static JSONArray getTerms(String country) {
        JSONObject entry = new JSONObject(Creator.getFile(country));
        return new JSONArray(entry.getJSONObject("result").getJSONArray("terms"));
    }

    public static JSONObject exportTermAndContent(String country, JSONArray terms) {
        JSONObject out = new JSONObject();
        JSONArray entry = getTerms(country);
        String term = null;
        String definition = null;
        for(Object o : entry){
            JSONObject oTerm = (JSONObject) o;
            out = new JSONObject();
            out.put("term",oTerm.getString("term"));
            out.put("definition",oTerm.getJSONObject("translation").getString("content"));
            terms.put(out);
        }
        return out;
    }




    public static TrustManager[] trustAllCerts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                    public void checkClientTrusted(
                            X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException ignored) {
        }
        return trustAllCerts;
    }

    public static SSLSocketFactory SSLSocket(TrustManager[] certs) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, certs, new SecureRandom());
        return sslContext.getSocketFactory();
    }
}
