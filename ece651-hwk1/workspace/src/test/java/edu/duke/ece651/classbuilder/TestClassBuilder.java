package edu.duke.ece651.classbuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class TestClassBuilder {
  @Test
  public void test_ClassBuilder() {
    String JSON_str = "{'classes' :[{'name' : 'Ylass1', 'fields' : [ {'name' : 'i1', 'type' : 'int'},{'name' : 'i2', 'type' : 'int' },{'name' : 'b1', 'type' : 'boolean'},{'name' : 'b2', 'type' : 'boolean'},{'name' : 's1', 'type' : 'String'},{'name' : 's2', 'type' : 'String'},]}, {'name' : 'Ylass2', 'fields' : [ {'name' : 'b1', 'type' : 'byte'},{'name' : 'c1', 'type' : 'char' },{'name' : 's1', 'type' : 'short'},{'name' : 'l1', 'type' : 'long'},{'name' : 'f1', 'type' : 'float'},{'name' : 'd1', 'type' : 'double'}]}]}";
    ClassBuilder cb = new ClassBuilder(JSON_str);
    cb.createAllClasses("/home/bh214/ece651/bh214-json-651_/ece651-hwk1/workspace/codeGenTest1/");
  }
 

}
