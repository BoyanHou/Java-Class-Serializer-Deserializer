package edu.duke.ece651.classbuilder;

import java.util.HashMap;

import org.json.JSONObject;

public interface CodingEngine {
  public String getOrdinaryClassCode(JSONObject cl);

  public String getDeserializerCode(HashMap<String, JSONObject> class_map);
}
