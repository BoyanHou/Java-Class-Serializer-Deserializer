package edu.duke.ece651.classbuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class GenerateIntoTester {
  @Test                                                                                  
  public void Generate_Using_StreamInput() {                                                        
    String json_path = "/home/bh214/ece651/prj1_tester/ece651-hwk1-tester/inputs/arr.json";
    String result_path = "/home/bh214/ece651/prj1_tester/ece651-hwk1-tester/src/main/java";
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
