import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Languages {

    private static JSONObject getLanguages() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] certs = Translation.trustAllCerts();
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(Translation.SSLSocket(certs), (X509TrustManager) certs[0])
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "api_token=b6fab07bb4b65cb7c1c6a97a7cb0d4e1&id=663235");
        Request request = new Request.Builder()
                .url("https://api.poeditor.com/v2/languages/list")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject result = new JSONObject(response.body().string());
        result = result.getJSONObject("result");
        return result;
    }

    public static JSONArray getLanguage() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        JSONObject entry = getLanguages();
        return new JSONArray(entry.getJSONArray("languages"));
    }

    public static ArrayList<String> getLanguagesCode() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        ArrayList<String> out = new ArrayList<>();
        JSONArray entry = getLanguage();
        for(Object o : entry){
            JSONObject oTerm = (JSONObject) o;
            out.add(oTerm.getString("code").toUpperCase());
        }
        return out;
    }



}
