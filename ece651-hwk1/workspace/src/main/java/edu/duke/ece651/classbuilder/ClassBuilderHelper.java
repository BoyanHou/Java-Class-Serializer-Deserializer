package edu.duke.ece651.classbuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassBuilderHelper {

  private HashMap<String, JSONObject> class_map;
  private String package_name;
  private String language_suffix;
  private CodingEngine coding_engine;
  
  public ClassBuilderHelper(String input,
                            String language_suffix,
                            CodingEngine coding_engine) {
    JSONObject JSONObj = new JSONObject(input);
    setPackageName(JSONObj);
    setClassMap(JSONObj);
    this.language_suffix = language_suffix;
    this.coding_engine = coding_engine;
  }

  //public ClassBuilder (InputStream input);

  // set package name
  private void setPackageName(JSONObject JSONObj) {
    if (JSONObj.has("package")) {
      package_name = JSONObj.getString("package");
    } else {
      package_name = "";
    }
  }

  // get classes into the class_map
  private void setClassMap(JSONObject JSONObj) {
    for (int i = 0; i < JSONObj.getJSONArray("classes").length(); i++) {
      JSONObject cl = JSONObj.getJSONArray("classes").getJSONObject(i);
      String cn = cl.getString("name");
      class_map.put(cn, cl) ;
    }
  }
    
  public Collection<String> getClassNames() {
    Collection<String> nameList = new ArrayList<>();
    for (String className: class_map.keySet() ) {
      nameList.add(className);
    }
    return nameList;
  }
    
  public String getSourceCode(String class_name) {
    return package_name + "\n" + coding_engine.getOrdinaryClassCode(class_map.get(class_name));
  }
  
  public void createAllClasses(String basePath) {
    // create the Deserializer class
    String deserializer_code = package_name + "\n" + coding_engine.getDeserializerCode(class_map);
    writeStringToFile(deserializer_code,
                      basePath + "/" + package_name + "/",
                      "Deserializer" + language_suffix
                      );
    
    // create all other classes
    for (String class_name : class_map.keySet()) {
      String ordinary_class_code = getSourceCode(class_name);
      writeStringToFile(ordinary_class_code,
                        basePath + "/" + package_name + "/",
                        class_name + language_suffix
                        );
    }
  }

  private void writeStringToFile(String content,
                                 String path,
                                 String filename) {    
    try {
      // if the path does not exist: create that path
      File dirs = new File(path);
      if (!dirs.exists()) {
        dirs.mkdirs();
      }
      // create output stream and overwrite to a designated filename
      FileOutputStream out = new FileOutputStream(path+filename, false);
      out.write(content.getBytes());
      out.close();
    }
    catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
