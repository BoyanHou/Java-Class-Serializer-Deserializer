package edu.duke.ece651.classbuilder;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;


public class Class4 {
  private Class3 c3;

  public JSONObject toJSON() {
    HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
    return toJSON(map);
  }
  
  public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
    String className = "Class4";
    int classID = className.hashCode();
    
    JSONObject json_object = new JSONObject();

    int counter = 0;
    
    if (map.containsKey(classID)) {
      ArrayList<Object> objectList = map.get(classID);
      for (counter = 0; counter < objectList.size(); counter++) {
        if (objectList.get(counter) == this) {
          String id = String.valueOf(classID) + "_" + String.valueOf(counter);
          json_object.put("ref", id);
          return json_object;
        }
      }
    } else {
      ArrayList<Object> list = new ArrayList<>();
      map.put(classID, list);
    }

    map.get(classID).add(this);
    String id = String.valueOf(classID) + "_" + String.valueOf(counter);
    
    json_object.put("id", String.valueOf(id));  
    json_object.put("type", "Class4");
    JSONArray values = new JSONArray();
    
    values.put(new JSONObject().put("c3",c3.toJSON(map)));
    json_object.put("values", values);
    return json_object;
  }

  Class3 getC3() {
    return c3;
  }

  void setC3(Class3 x) {
    c3 = x;
  }
}
