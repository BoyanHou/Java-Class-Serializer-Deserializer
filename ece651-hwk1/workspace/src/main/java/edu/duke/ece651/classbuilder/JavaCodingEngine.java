package edu.duke.ece651.classbuilder;

import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;

public class JavaCodingEngine implements CodingEngine{
  private HashSet<String> primitives = new HashSet<>();
  private String common_headers;
  private String deserializer_specific_headers;
  private String ordinary_class_specific_headers;
  
  public JavaCodingEngine() {
    primitives.add("String");
    primitives.add("short");
    primitives.add("Short");
    primitives.add("int");
    primitives.add("Integer");
    primitives.add("long");
    primitives.add("Long");
    primitives.add("byte");
    primitives.add("Byte");
    primitives.add("char");
    primitives.add("Character");
    primitives.add("float");
    primitives.add("Float");
    primitives.add("double");
    primitives.add("Double");
    primitives.add("boolean");
    primitives.add("Boolean");

    common_headers = "";
    common_headers += "import java.util.HashMap;\n";
    common_headers += "import org.json.JSONArray;\n";
    common_headers += "import org.json.JSONObject;\n";
    deserializer_specific_headers = "";
    deserializer_specific_headers += "import org.json.JSONException;\n";
    ordinary_class_specific_headers = "";
    ordinary_class_specific_headers += "import java.util.ArrayList;\n";;
  }

  @Override
  public String getDeserializerCode(HashMap<String, JSONObject> class_map) {
    String code = "";
    return common_headers + "\n" + deserializer_specific_headers + "\n" + code;
  }
  
  @Override
  public String getOrdinaryClassCode(JSONObject cl) {
    String class_name = cl.getString("name");
    String code = "public class " + class_name + " {";

    String field_declaration_code = "";
    String constructor_code = "\t" + "public " + class_name + "() {\n";
    String toJSON_code = "\t" + "public JSONObject toJSON() {\n";
    toJSON_code += "\t\t" + "HashMap<Integer, ArrayList<Object>> map = new HashMap<>();\n";
    toJSON_code += "\t\t" + "return toJSON(map);\n\t}\n";
    toJSON_code += "\t" + "public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {\n";
    toJSON_code += "\t\t" + "String className = \"" + class_name + "\";\n";
    toJSON_code += "\t\t" + "int classID = className.hashCode();\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "JSONObject json_object = new JSONObject();\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "int counter = 0;\n";
    toJSON_code += "\t\t" + "if (map.containsKey(classID)) {\n";
    toJSON_code += "\t\t\t" + "ArrayList<Object> objectList = map.get(classID);\n";
    toJSON_code += "\t\t\t" + "for (counter = 0; counter < objectList.size(); counter++) {\n";
    toJSON_code += "\t\t\t\t" + "if (objectList.get(counter) == this) {\n";
    toJSON_code += "\t\t\t\t\t" + "String id = String.valueOf(classID) + \"_\" + String.valueOf(counter);\n";
    toJSON_code += "\t\t\t\t\t" + "json_object.put(\"ref\", id);\n";
    toJSON_code += "\t\t\t\t\t" + "return json_object;\n";
    toJSON_code += "\t\t\t\t" + "}\n";
    toJSON_code += "\t\t\t" + "}\n";
    toJSON_code += "\t\t" + "} else {\n";
    toJSON_code += "\t\t\t" + "ArrayList<Object> list = new ArrayList<>();\n";
    toJSON_code += "\t\t\t" + "map.put(classID, list);\n";
    toJSON_code += "\t\t" + "}\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "map.get(classID).add(this);\n";
    toJSON_code += "\t\t" + "String id = String.valueOf(classID) + \"_\" + String.valueOf(counter);\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "json_object.put(\"id\", String.valueOf(id));\n";
    toJSON_code += "\t\t" + "json_object.put(\"type\", \"" + class_name + "\");\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "JSONArray values = new JSONArray();\n";
    toJSON_code += "\n";
    toJSON_code += "\t\t" + "// start to put into values\n";

    String getter_setter_code = "";
    JSONArray fields = cl.getJSONArray("fields");
    for (int i = 0; i < fields.length(); i++) {
      JSONObject field = fields.getJSONObject(i);
      String field_name = field.getString("name");
      Object field_type = field.get("type");
      if (field_type instanceof JSONObject) { // this filed is an array
        String element_type = ((JSONObject)field_type).getString("e");
        // declaration part
        field_declaration_code += "\t" + "private ArrayList<" + toWrapper(element_type) + "> " + field_name + ";\n";
        
        // constructor part
        constructor_code += "\t\t" + field_name + " = new ArrayList<>();\n";

        // toJSON part
        toJSON_code += "\t\t" + "JSONArray " + field_name + "_JSONArray = new JSONArray();\n";
        toJSON_code += "\t\t" + "for (" + element_type + " element : " + field_name + ") {\n";
        if (primitives.contains(element_type)) { // primitive & String list
          toJSON_code += "\t\t\t" + field_name + "_JSONArray.put(element);\n";
        } else { // object classes list
          toJSON_code += "\t\t\t" + field_name + "_JSONArray.put(element == null ? null : element.toJSON(map));\n";
        }
        toJSON_code += "\t\t" + "}\n";
        toJSON_code += "\t\t" + "values.put(new JSONObject().put(\"" + field_name + "\", " + field_name +"_JSONArray));\n";
        
        
        // getter & setter part
      } else { // this field is a single variable
        // declaraction part
        field_declaration_code += "\t" + "private" + (String)field_type + field_name + ";\n";

        // toJSON part
        if (primitives.contains((String) field_type)) { // primitive or String type
          toJSON_code += "\t\t" + "values.put(new JSONObject().put(\"" + field_name + "\", String.valueOf(" + field_name + ")));\n";
        } else { // object type
          toJSON_code += "\t\t" + "values.put(new JSONObject().put(\"" + field_name + "\", " + field_name + ".toJSON(map)));\n";
        }
        
        // getter & setter part
        getter_setter_code += "\n";
        getter_setter_code += "\t" + (String)field_type + " get" + upperFirstChar(field_name) + "() {\n";
        getter_setter_code += "\t\t" + "return " + field_name + ";\n";
        getter_setter_code += "\t" + "}\n";
        getter_setter_code += "\n";
        getter_setter_code += "\t" + "void set" + upperFirstChar(field_name) + "(" + (String)field_type + "x) {\n";
        getter_setter_code += "\t\t" + field_name + " = x;\n";
        getter_setter_code += "\t" + "}\n";
      }

    }
    return common_headers + "\n" + ordinary_class_specific_headers + "\n" + code;
  }

  private String upperFirstChar(String input) {
    char first_char = input.charAt(0);
    String rest = input.substring(1);
    if (Character.isLetter(first_char)) {
      return String.valueOf(first_char).toUpperCase() + rest;
    } else {
      return input;
    }
  }

  private String toWrapper(String type) {
    if (type.equals("short")) {
      return "Short";
    } else if (type.equals("int")) {
      return "Integer";
    } else if (type.equals("long")) {
      return "Long";
    } else if (type.equals("byte")) {
      return "Byte";
    } else if (type.equals("char")) {
      return "Character";
    } else if (type.equals("float")) {
      return "Float";
    } else if (type.equals("double")) {
      return "Double";
    } else if (type.equals("boolean")) {
      return "Boolean";
    } else {
      return type;
    }
  }
}
