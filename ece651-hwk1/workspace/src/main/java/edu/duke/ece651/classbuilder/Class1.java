package edu.duke.ece651.classbuilder;

import java.util.ArrayList;

import org.json.JSONObject;

public class Class1 {
  private int i1;
  private int i2;
  private boolean b1;
  private boolean b2;
  private String s1;
  private String s2;

  public JSONObject toJSON(int id) {
    JSONObject json_object = new JSONObject();
    json_object.put("id", String.valueOf(id));  
    json_object.put("type", "Class1");
    JSONObject values = new JSONObject();
    values.put("i1", String.valueOf(i1));
    values.put("i2", String.valueOf(i2));
    values.put("b1", String.valueOf(b1));
    values.put("b2", String.valueOf(b2));
    values.put("s1", String.valueOf(s1));
    values.put("s2", String.valueOf(s2));
    json_object.put("values", values);
    
    return json_object;
  }

  public int getI1() {
    return i1;
  }

  public void setI1(int x) {
    i1 = x;
  }

  public int getI2() {
    return i2;
  }

  public void setI2(int x) {
    i2 = x;
  }

  public boolean getB1() {
    return b1;
  }

  public void setB1(boolean x) {
    b1 = x;
  }

  public boolean getB2() {
    return b2;
  }

  public void setB2(boolean x) {
    b2 = x;
  }

  public String getS1() {
    return s1;
  }

  public void setS1(String x) {
    s1 = x;
  }

  public String getS2() {
    return s2;
  }

  public void setS2(String x) {
    s2 = x;
  }  
}
