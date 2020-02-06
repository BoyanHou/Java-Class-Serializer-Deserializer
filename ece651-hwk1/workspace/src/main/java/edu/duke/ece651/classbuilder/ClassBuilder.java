package edu.duke.ece651.classbuilder;

import java.util.Collection;

public class ClassBuilder {

  ClassBuilderHelper helper;

  public ClassBuilder(String input) {
    helper = new ClassBuilderHelper(input, ".java", new JavaCodingEngine());
  }

  public Collection<String> getClassNames() {
    return helper.getClassNames();
  }

  public String getSourceCode(String class_name) {
    return helper.getSourceCode(class_name);
  }

  public void createAllClasses(String basePath) {
    helper.createAllClasses(basePath);
  }
  
  
}
