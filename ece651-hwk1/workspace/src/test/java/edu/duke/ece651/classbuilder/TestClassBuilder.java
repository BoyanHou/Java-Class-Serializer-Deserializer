package edu.duke.ece651.classbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestClassBuilder {
  @Test
  public void test_ClassBuilder() {
    ClassBuilder cb = new ClassBuilder("{\"class\":\"ECE651\"}");
    cb.writeStringToFile("heygg! java",
                         "/home/bh214/ece651/bh214-json-651_/ece651-hwk1/workspace/codeGenFolder/");
  }
 

}
