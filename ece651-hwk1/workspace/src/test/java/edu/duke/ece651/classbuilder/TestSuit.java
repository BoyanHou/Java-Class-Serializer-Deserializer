package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import edu.duke.ece651.classbuilder.package1.Class2;

public class TestSuit {
  @Test
  public void test_Classes() {
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

    //bcslfd
    Class2 c2 = new Class2();
    byte bv = 10;
    c2.setB1(bv);
    assertEquals(bv, c2.getB1());
    char cv = 'z';
    c2.setC1(cv);
    assertEquals(cv, c2.getC1());
    short sv = 3;
    c2.setS1(sv);
    assertEquals(sv, c2.getS1());
    long lv = 100;
    c2.setL1(lv);
    assertEquals(lv, c2.getL1());
    float fv = (float)50.1;
    c2.setF1(fv);
    assertEquals(fv, c2.getF1());
    double dv = 22.33;
    c2.setD1(dv);
    assertEquals(dv, c2.getD1());

    JSONObject jo = c1.toJSON();
    JSONObject jo2 = c2.toJSON();
            
    Class1 c1_ds = Deserializer.readClass1(jo);
    assertEquals(c1.getI1(), c1_ds.getI1());
    assertEquals(c1.getI2(), c1_ds.getI2());
    assertEquals(c1.getB1(), c1_ds.getB1());
    assertEquals(c1.getB2(), c1_ds.getB2());
    assertEquals(c1.getS1(), c1_ds.getS1());
    assertEquals(c1.getS2(), c1_ds.getS2());
    
    //bcslfd
    Class2 c2_ds = Deserializer.readClass2(jo2);
    assertEquals(c2.getB1(), c2_ds.getB1());
    assertEquals(c2.getC1(), c2_ds.getC1());
    assertEquals(c2.getS1(), c2_ds.getS1());
    assertEquals(c2.getL1(), c2_ds.getL1());
    assertEquals(c2.getF1(), c2_ds.getF1());
    assertEquals(c2.getD1(), c2_ds.getD1());

    Class3 c3 = new Class3();
    Class4 c4 = new Class4();
    c3.setC4(c4);
    c4.setC3(c3);

    assertEquals(c3, c3.getC4().getC3());
    assertEquals(c4, c4.getC3().getC4());

    JSONObject c3JSON = c3.toJSON();
    JSONObject c4JSON = c4.toJSON();

    
    Class3 c3_ds = Deserializer.readClass3(c3JSON);
    assertEquals(c3_ds, c3_ds.getC4().getC3());

    Class4 c4_ds = Deserializer.readClass4(c4JSON);
    assertEquals(c4_ds, c4_ds.getC3().getC4());
  }
}
