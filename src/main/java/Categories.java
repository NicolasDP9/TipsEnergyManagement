import org.json.JSONArray;
import org.json.JSONObject;

public class Categories {

    public static JSONObject getHeatingCategories(){
        JSONObject HeatingCategory = new JSONObject();
        JSONArray HeatingTerms = new JSONArray();
        HeatingTerms.put("energy_advice_2");
        HeatingTerms.put("energy_advice_7");
        HeatingTerms.put("energy_advice_17");
        HeatingTerms.put("energy_advice_19");
        HeatingTerms.put("energy_advice_20");
        HeatingTerms.put("energy_advice_21");
        HeatingTerms.put("energy_advice_24");
        HeatingTerms.put("energy_advice_26");
        HeatingTerms.put("energy_advice_30");
        HeatingTerms.put("energy_advice_31");
        HeatingTerms.put("energy_advice_33");
        HeatingTerms.put("energy_advice_34");
        HeatingTerms.put("energy_advice_37");
        HeatingTerms.put("energy_advice_38");
        HeatingTerms.put("energy_advice_41");
        HeatingTerms.put("energy_advice_43");
        HeatingTerms.put("energy_advice_48");
        HeatingTerms.put("energy_advice_51");
        HeatingTerms.put("energy_advice_53");
        HeatingCategory.put("terms",HeatingTerms);
        HeatingCategory.put("category","HEATING");
        return HeatingCategory;
    }

    public static JSONObject getApplianceCategories(){
        JSONObject ApplianceCategory = new JSONObject();
        JSONArray ApplianceTerms = new JSONArray();
        ApplianceTerms.put("energy_advice_4");
        ApplianceTerms.put("energy_advice_11");
        ApplianceTerms.put("energy_advice_12");
        ApplianceTerms.put("energy_advice_15");
        ApplianceTerms.put("energy_advice_16");
        ApplianceTerms.put("energy_advice_28");
        ApplianceTerms.put("energy_advice_35");
        ApplianceTerms.put("energy_advice_36");
        ApplianceTerms.put("energy_advice_39");
        ApplianceTerms.put("energy_advice_40");
        ApplianceTerms.put("energy_advice_42");
        ApplianceTerms.put("energy_advice_45");
        ApplianceTerms.put("energy_advice_49");
        ApplianceTerms.put("energy_advice_52");
        ApplianceCategory.put("terms",ApplianceTerms);
        ApplianceCategory.put("category","APPLIANCE");
        return ApplianceCategory;
    }

    public static JSONObject getLightsCategories(){
        JSONObject LightsCategory = new JSONObject();
        JSONArray LightsTerms = new JSONArray();
        LightsTerms.put("energy_advice_1");
        LightsTerms.put("energy_advice_6");
        LightsTerms.put("energy_advice_10");
        LightsTerms.put("energy_advice_13");
        LightsTerms.put("energy_advice_14");
        LightsTerms.put("energy_advice_25");
        LightsTerms.put("energy_advice_32");
        LightsCategory.put("terms",LightsTerms);
        LightsCategory.put("category","LIGHTS");
        return LightsCategory;
    }

    public static JSONObject getOutletsCategories(){
        JSONObject Category = new JSONObject();
        JSONArray Terms = new JSONArray();
        Terms.put("energy_advice_3");
        Terms.put("energy_advice_5");
        Terms.put("energy_advice_8");
        Terms.put("energy_advice_9");
        Terms.put("energy_advice_29");
        Terms.put("energy_advice_46");
        Terms.put("energy_advice_47");
        Category.put("terms",Terms);
        Category.put("category","OUTLETS");
        return Category;
    }

    public static JSONObject getAirConditioningCategories(){
        JSONObject Category = new JSONObject();
        JSONArray Terms = new JSONArray();
        Terms.put("energy_advice_18");
        Terms.put("energy_advice_22");
        Terms.put("energy_advice_23");
        Terms.put("energy_advice_27");
        Terms.put("energy_advice_50");
        Category.put("terms",Terms);
        Category.put("category","AIRCONDITIONING");
        return Category;
    }
}
