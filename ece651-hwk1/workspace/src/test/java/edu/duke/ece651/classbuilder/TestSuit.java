package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class TestSuit {
  @Test
  public void test_class1() {
    Class1 c1 = new Class1();
    c1.setI1(1);
    assertEquals(1, c1.getI1());
    c1.setI2(2);
    assertEquals(2, c1.getI2());
    c1.setB1(true);
    assertEquals(true, c1.getB1());
    c1.setB2(false);
    assertEquals(false, c1.getB2());
    c1.setS1("this is s1");
    assertEquals("this is s1", c1.getS1());
    c1.setS2("this is s2");
    assertEquals("this is s2", c1.getS2());
    JSONObject jo = c1.toJSON(1);

    Class1 c1_ds = Deserializer.readClass1(jo);
    assertEquals(c1.getI1(), c1_ds.getI1());
    assertEquals(c1.getI2(), c1_ds.getI2());
    assertEquals(c1.getB1(), c1_ds.getB1());
    assertEquals(c1.getB2(), c1_ds.getB2());
    assertEquals(c1.getS1(), c1_ds.getS1());
    assertEquals(c1.getS2(), c1_ds.getS2());
  }

}
