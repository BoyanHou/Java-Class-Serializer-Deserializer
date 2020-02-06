package edu.duke.ece651.classbuilder;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;


public class Class3 {
  private Class4 c4;
  private int i1;
  private ArrayList<Integer> list;
  private ArrayList<Class4> c4s;
  
  public Class3() {
    list = new ArrayList<>();
    c4s = new ArrayList<>();
  }
  
  public JSONObject toJSON() {
    HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
    return toJSON(map);
  }
  
  public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
    String className = "Class3";
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
    json_object.put("type", "Class3");

    JSONArray values = new JSONArray();

    // for object type
    values.put(new JSONObject().put("c4", c4 == null ? JSONObject.NULL : c4.toJSON(map)));

    // for primitive list
    JSONArray list_JSONArray = new JSONArray();
    for (int element : list) {
      list_JSONArray.put(element);
    }
    values.put(new JSONObject().put("list", list_JSONArray));

    // for object list
    JSONArray c4s_JSONArray = new JSONArray();
    for (Class4 element : c4s) {
      c4s_JSONArray.put(element == null ? JSONObject.NULL : element.toJSON(map));
    }
    values.put(new JSONObject().put("c4s", c4s_JSONArray));

    //commont
    json_object.put("values",values);
    
    return json_object;
  }

  Class4 getC4() {
    return c4;
  }

  void setC4(Class4 x) {
    c4 = x;
  }

  int getI1() {
    return i1;
  }

  void setI1(int x) {
    i1 = x;
  }

  int numList() {
    return list.size();
  }
  
  void addList(int x) {
    list.add(x);
  }

  int getList(int index) {
    return list.get(index);
  }

  void setList(int index, int x) {
    list.set(index, x);
  }

  int numC4s() {
    return c4s.size();
  }
  
  void addC4s(Class4 x) {
    c4s.add(x);
  }

  Class4 getC4s(int index) {
    return c4s.get(index);
  }

  void setC4s(int index, Class4 x) {
    c4s.set(index, x);
  }
}
