package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import edu.duke.ece651.classbuilder.package_test.Ylass1;
import edu.duke.ece651.classbuilder.package_test.Ylass2;
import edu.duke.ece651.classbuilder.package_test.Ylass3;
import edu.duke.ece651.classbuilder.package_test.Ylass4;
import edu.duke.ece651.classbuilder.package_test.Deserializer;

public class TestGeneratedCode {
  @Test
  public void test_Classes() {
    Ylass1 c1 = new Ylass1();
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
    Ylass2 c2 = new Ylass2();
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
            
    Ylass1 c1_ds = Deserializer.readYlass1(jo);
    assertEquals(c1.getI1(), c1_ds.getI1());
    assertEquals(c1.getI2(), c1_ds.getI2());
    assertEquals(c1.getB1(), c1_ds.getB1());
    assertEquals(c1.getB2(), c1_ds.getB2());
    assertEquals(c1.getS1(), c1_ds.getS1());
    assertEquals(c1.getS2(), c1_ds.getS2());
    
    //bcslfd
    Ylass2 c2_ds = Deserializer.readYlass2(jo2);
    assertEquals(c2.getB1(), c2_ds.getB1());
    assertEquals(c2.getC1(), c2_ds.getC1());
    assertEquals(c2.getS1(), c2_ds.getS1());
    assertEquals(c2.getL1(), c2_ds.getL1());
    assertEquals(c2.getF1(), c2_ds.getF1());
    assertEquals(c2.getD1(), c2_ds.getD1());

    Ylass3 c3 = new Ylass3();
    Ylass4 c4 = new Ylass4();
    

    c3.setC4(c4);
    c4.setC3(c3);
    c3.addList(1);
    c3.addList(55);
    c3.addList(100);
    c4.addChars('z');
    c4.addChars('x');
    c4.addChars('o');

    // c3 list test: c4s Class4 list
    c3.addC4s(c4);
    c3.addC4s(new Ylass4());
    c3.setC4s(1, c4);
    assertEquals(c3.getC4s(0), c3.getC4s(1));
    assertEquals(c3.numC4s(), 2);
    
    assertEquals(c3, c3.getC4().getC3());
    assertEquals(c4, c4.getC3().getC4());

    JSONObject c3JSON = c3.toJSON();
    JSONObject c4JSON = c4.toJSON();

    
    Ylass3 c3_ds = Deserializer.readYlass3(c3JSON);
    assertEquals(c3_ds, c3_ds.getC4().getC3());
    assertEquals(c3_ds.getList(0), 1);
    assertEquals(c3_ds.getList(1), 55);
    assertEquals(c3_ds.getList(2), 100);

    //c3 list test: c4s Class4
    assertEquals(c3_ds.getC4s(0), c3_ds.getC4s(1));
    assertEquals(c3_ds.numC4s(), 2);
    assertEquals(c3_ds.getC4s(0).getC3(), c3_ds);
    
    Ylass4 c4_ds = Deserializer.readYlass4(c4JSON);
    // class inter-dependency: c3 <->c4 tests
    assertEquals(c4_ds, c4_ds.getC3().getC4());
    // char list "chars" in c4 test
    assertEquals(c4_ds.getChars(0), 'z');
    assertEquals(c4_ds.getChars(1), 'x');
    assertEquals(c4_ds.getChars(2), 'o');

    // ser-deser imdeponent test
    Deserializer.readYlass3(c3.toJSON()).toJSON().equals(c3.toJSON());
    
    Ylass3 c3_a = new Ylass3();
    Ylass4 c4_a = new Ylass4();
    Ylass3 c3_b = new Ylass3();
    Ylass4 c4_b = new Ylass4();
    Ylass3 c3_c = new Ylass3();
    Ylass4 c4_c = new Ylass4();
    
    c3_a.setC4(c4_a);
    c4_a.setC3(c3_b);
    c3_b.setC4(c4_b);
    c4_b.setC3(c3_c);
    c3_c.setC4(c4_c);
    c4_c.setC3(c3_a);
    
    JSONObject c3_a_JSON = c3_a.toJSON();

    Ylass3 c3_a_ds = Deserializer.readYlass3(c3_a_JSON);
    assertEquals(c3_a_ds,c3_a_ds.getC4().getC3().getC4().getC3().getC4().getC3());
    
  }
}
