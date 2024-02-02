import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class App {
    public static void main( String[] args ) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        ArrayList<String> allLanguages = Languages.getLanguagesCode();
        for (int i=0; i < allLanguages.size();i++){
            Translation.getTranslation(allLanguages.get(i));
        }

        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        JSONArray languages = new JSONArray();
        JSONArray categories = new JSONArray();

        for (int i=0; i < allLanguages.size();i++) {
            JSONObject employeeObject = new JSONObject();
            JSONArray terms = new JSONArray();
            employeeObject.put("language", allLanguages.get(i));
            Translation.exportTermAndContent(allLanguages.get(i),terms);
            employeeObject.put("terms", terms);
            languages.put(employeeObject);
        }

        categories.put(Categories.getHeatingCategories());
        categories.put(Categories.getApplianceCategories());
        categories.put(Categories.getLightsCategories());
        categories.put(Categories.getOutletsCategories());
        categories.put(Categories.getAirConditioningCategories());

        jsonObject.put("categories",categories);
        jsonObject.put("languages",languages);
        try {
            FileWriter file = new FileWriter("/Users/nicola/Documents/GitHub/TipsEnergyManagement/export/output.json");
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);


    }
}
