package edu.duke.ece651.classbuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class TestClassBuilder {
  @Test
  public void test_ClassBuilder() {
    String JSON_str = "{ 'classes' :[{'name' : 'Ylass3', 'fields' : [ {'name':'c4','type':'Ylass4'},{'name' : 'i1', 'type' : 'int' },{'name' : 'list', 'type' : {'e':'int'}},{'name' : 'c4s', 'type' : {'e':'Ylass4'}}]}, {'name' : 'Ylass4', 'fields' : [ {'name':'c3','type':'Ylass3'},{'name' : 'ch1', 'type' : 'char' },{'name' : 'chars', 'type' : {'e':'char'}}]} ]}";
    ClassBuilder cb = new ClassBuilder(JSON_str);
    cb.createAllClasses("/home/bh214/ece651/bh214-json-651_/ece651-hwk1/workspace/codeGenTest1/");
  }
 

}
