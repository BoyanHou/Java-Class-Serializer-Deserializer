package edu.duke.ece651.classbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class ClassBuilder {

  ClassBuilderHelper helper;

  public ClassBuilder(String input) {
    helper = new ClassBuilderHelper(input, ".java", new JavaCodingEngine());
  }

  public ClassBuilder(InputStream input) throws IOException {
    helper = new ClassBuilderHelper(input, ".java", new JavaCodingEngine());
  }

  public Collection<String> getClassNames() {
    return helper.getClassNames();
  }

  public String getSourceCode(String class_name) {
    return helper.getSourceCode(class_name);
  }

  public void createAllClasses(String basePath) throws IOException {
    helper.createAllClasses(basePath);
  }
}
