package edu.duke.ece651.classbuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class TestClassBuilder {
  @Test
  public void test_ClassBuilder() {
    String JSON_str = "{'classes' :[{'name' : 'Ylass3', 'fields' : [ {'name' : 'i1', 'type' : 'int' },{'name' : 'list', 'type' : {'e':'int'}}]}]}";
    ClassBuilder cb = new ClassBuilder(JSON_str);
    cb.createAllClasses("/home/bh214/ece651/bh214-json-651_/ece651-hwk1/workspace/codeGenTest1/");
  }
 

}
