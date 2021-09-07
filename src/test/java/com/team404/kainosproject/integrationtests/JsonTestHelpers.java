package com.team404.kainosproject.integrationtests;


import org.json.JSONException;
import org.json.JSONObject;

public class JsonTestHelpers {

  public static boolean jsonArrayIsNotEmpty(JSONObject json, String arrayName) {

    try{

      if(json.getJSONArray(arrayName).length() <= 0)
        return false;
    }
    catch (JSONException e){
      return false;
    }

    return true;
  }

  public static boolean jsonHasAttribute(JSONObject json, String attributeName){

    try{
      json.get(attributeName);
    }
    catch (JSONException e){
      return false;
    }

    return true;
  }
}
