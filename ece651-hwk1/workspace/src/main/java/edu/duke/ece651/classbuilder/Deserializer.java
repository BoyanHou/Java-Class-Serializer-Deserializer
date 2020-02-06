package edu.duke.ece651.classbuilder;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.duke.ece651.classbuilder.package1.Class2;


public class Deserializer { 

  public static Class1 readClass1(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass1(js, map);
  }

  public static Class1 readClass1(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class1)(map.get(key));
    } 
    
    Class1 obj = new Class1();
    int id = js.getString("id").hashCode();
    map.put(id, obj);
    
    JSONArray values = js.getJSONArray("values");

    // setting variable values
    obj.setI1(Integer.valueOf(values.getJSONObject(0).getString("i1")));
    obj.setI2(Integer.valueOf(values.getJSONObject(1).getString("i2")));
    obj.setB1(Boolean.valueOf(values.getJSONObject(2).getString("b1")));
    obj.setB2(Boolean.valueOf(values.getJSONObject(3).getString("b2")));
    obj.setS1(String.valueOf(values.getJSONObject(4).getString("s1")));
    obj.setS2(String.valueOf(values.getJSONObject(5).getString("s2")));

    return obj;
  }

  public static Class2 readClass2(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass2(js, map);
  }

  public static Class2 readClass2(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class2)(map.get(key));
    } 
    
    Class2 class2 = new Class2();
    int id = js.getString("id").hashCode();
    map.put(id, class2);
    
    JSONArray values = js.getJSONArray("values");
  
    class2.setB1(Byte.valueOf(values.getJSONObject(0).getString("b1")));
    class2.setC1(values.getJSONObject(1).getString("c1").charAt(0));
    class2.setS1(Short.valueOf(values.getJSONObject(2).getString("s1")));
    class2.setL1(Long.valueOf(values.getJSONObject(3).getString("l1")));
    class2.setF1(Float.valueOf(values.getJSONObject(4).getString("f1")));
    class2.setD1(Double.valueOf(values.getJSONObject(5).getString("d1")));
    return class2;
  }

  public static Class3 readClass3(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass3(js, map);
  }
  public static Class3 readClass3(JSONObject js, HashMap<Integer, Object>map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class3)(map.get(key));
    } 
    
    Class3 obj = new Class3();
    int id = js.getString("id").hashCode();
    map.put(id, obj);
    
    JSONArray values = js.getJSONArray("values");
    // for non-primitive&String
    obj.setC4(readClass4(values.getJSONObject(0).getJSONObject("c4"), map));
    // for list: int
    for (int i = 0; i < values.getJSONObject(1).getJSONArray("list").length(); i++) {
      int element = values.getJSONObject(1).getJSONArray("list").getInt(i);
      obj.addList(element);
    }
    // for object list--c4s: Class4
    for (int i = 0; i < values.getJSONObject(2).getJSONArray("c4s").length(); i++) {
      JSONObject element = values.getJSONObject(2).getJSONArray("c4s").getJSONObject(i);
      obj.addC4s(readClass4(element, map));
    }    
    
    return obj;
  }

  public static Class4 readClass4(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass4(js, map);
  }
  public static Class4 readClass4(JSONObject js, HashMap<Integer, Object>map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class4)(map.get(key));
    } 
    
    Class4 obj = new Class4();
    int id = js.getString("id").hashCode();
    map.put(id, obj);
    
    JSONArray values = js.getJSONArray("values");
    // for non-primitive&String
    obj.setC3(readClass3(values.getJSONObject(0).getJSONObject("c3"), map));
    // for list: char
    for (int i = 0; i < values.getJSONObject(1).getJSONArray("chars").length(); i++) {
      char element = values.getJSONObject(1).getJSONArray("chars").getString(i).charAt(0);
      obj.addChars(element);
    }
    
    return obj;
  }
}
