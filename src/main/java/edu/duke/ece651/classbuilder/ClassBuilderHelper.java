package edu.duke.ece651.classbuilder;

import java.io.File;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.io.BufferedReader;
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
    class_map = new HashMap<>();
    setPackageName(JSONObj);
    setClassMap(JSONObj);
    this.language_suffix = language_suffix;
    this.coding_engine = coding_engine;
  }
  
  public ClassBuilderHelper(InputStream input_stream,
                            String language_suffix,
                            CodingEngine coding_engine) throws IOException {
    InputStreamReader stream_reader = new InputStreamReader(input_stream);
    BufferedReader buffer_reader = new BufferedReader(stream_reader);
    StringBuffer string_buffer = new StringBuffer();
    String str = "";

    while((str = buffer_reader.readLine())!= null){
         string_buffer.append(str);
    }
    String input = string_buffer.toString();
    
    JSONObject JSONObj = new JSONObject(input);
    class_map = new HashMap<>();
    setPackageName(JSONObj);
    setClassMap(JSONObj);
    this.language_suffix = language_suffix;
    this.coding_engine = coding_engine;
  }
                            
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
    return "package " + package_name + ";\n" + coding_engine.getOrdinaryClassCode(class_map.get(class_name));
  }
  
  public void createAllClasses(String basePath) throws IOException {
    // create the Deserializer class
    String deserializer_code = "package " + package_name + ";\n" + coding_engine.getDeserializerCode(class_map);
    writeStringToFile(deserializer_code,
                      basePath + "/" + package_name.replace('.', '/') + "/",
                      "Deserializer" + language_suffix
                      );
    
    // create all other classes
    for (String class_name : class_map.keySet()) {
      String ordinary_class_code = getSourceCode(class_name);
      writeStringToFile(ordinary_class_code,
                        basePath + "/" + package_name.replace('.', '/') + "/",
                        class_name + language_suffix
                        );
    }
  }

  private void writeStringToFile(String content,
                                 String path,
                                 String filename) throws IOException {    
    
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
}
