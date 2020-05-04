package edu.duke.ece651.classbuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class TestClassBuilder {
  @Test
  public void testJSONInput() {
    String JSON_str = "{ 'classes' :[{'name' : 'Ylass1', 'fields' : [ {'name' : 'i1', 'type' : 'int'},{'name' : 'i2', 'type' : 'int' },{'name' : 'b1', 'type' : 'boolean'},{'name' : 'b2', 'type' : 'boolean'},{'name' : 's1', 'type' : 'String'},{'name' : 's2', 'type' : 'String'}]}, {'name' : 'Ylass2', 'fields' : [ {'name' : 'b1', 'type' : 'byte'},{'name' : 'c1', 'type' : 'char' },{'name' : 's1', 'type' : 'short'},{'name' : 'l1', 'type' : 'long'},{'name' : 'f1', 'type' : 'float'},{'name' : 'd1', 'type' : 'double'}]},{'name' : 'Ylass3', 'fields' : [ {'name':'c4','type':'Ylass4'},{'name' : 'i1', 'type' : 'int' },{'name' : 'list', 'type' : {'e':'int'}},{'name' : 'c4s', 'type' : {'e':'Ylass4'}}]},{'name' : 'Ylass4', 'fields' : [ {'name':'c3','type':'Ylass3'},{'name' : 'ch1', 'type' : 'char' },{'name' : 'chars', 'type' : {'e':'char'}}]}], 'package':'edu.duke.ece651.classbuilder.package_test_json'}";
    String result_path = "./src/main/java";
    ClassBuilder cb = new ClassBuilder(JSON_str);
    try {
      cb.createAllClasses(result_path);
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }
  
  @Test                                                                                  
  public void testStreamInput() {                                                        
    String json_path = "./src/test/resources/input1.json";
    String result_path = "./src/main/java";
    try{                                                                               
      InputStream inputStream = new FileInputStream(new File(json_path));                 
      ClassBuilder cb = new ClassBuilder(inputStream);
      cb.createAllClasses(result_path);
    }                                                                                  
    catch(IOException e){                                                   
      e.printStackTrace();                                                               
    }                                                                                  
  }                 
}
