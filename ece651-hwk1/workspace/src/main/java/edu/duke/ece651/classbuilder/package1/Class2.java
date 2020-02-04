package edu.duke.ece651.classbuilder.package1;

import org.json.JSONObject;

public class Class2 {
  private byte b1;

  public byte getB1() {
    return b1;
  }

  public void setB1(byte x) {
    b1 = x;
  }
  
  private char c1;

  public char getC1() {
    return c1;
  }

  public void setC1(char x) {
    c1 = x;
  }
  
  private short s1;

  public short getS1() {
    return s1;
  }

  public void setS1(short x) {
    s1 = x;
  }

  private long l1;

  public long getL1() {
    return l1;
  }
  
  public void setL1(long x) {
    l1 = x;
  }

  private float f1;

  public float getF1() {
    return f1;
  }

  public void setF1(float x) {
    f1 = x;
  }
  
  private double d1;

  public double getD1() {
    return d1;
  }

  public void setD1(double x) {
    d1 = x;
  }
  //bcslfd
  public JSONObject toJSON(int id) {
    JSONObject json_object = new JSONObject();
    json_object.put("id", String.valueOf(id));
    json_object.put("type", "Class2");
    JSONObject values = new JSONObject();
    values.put("b1", String.valueOf(b1));
    values.put("c1", String.valueOf(c1));
    values.put("s1", String.valueOf(s1));
    values.put("l1", String.valueOf(l1));
    values.put("f1", String.valueOf(f1));
    values.put("d1", String.valueOf(d1));
    json_object.put("values", values);

    return json_object;
  }                     
}
