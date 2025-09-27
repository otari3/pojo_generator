package ge.pojo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Pojo {
  private String fieldDeclartionString = "public %s %s;";
  private String classDeclaration = "package ge.testClasses;\npublic class %s { \n%s\n }";
  public   HashMap<String,String> results = new HashMap<>();

  public void deserialize(String json,String name){
    results = new HashMap<>();
    deserializeHelper(json,results,name);
   for(String key:results.keySet()){  
    Path path = Path.of("src/test/java/ge/testClasses/%s.java".formatted(key));
    String pojoCode = results.get(key);
    try(FileWriter fileWriter = new FileWriter(path.toFile())){ 
        fileWriter.write(pojoCode);
    } catch (IOException e) {
      e.printStackTrace();
    }
   }
  }

  private String deserializeHelper(String json,HashMap<String,String> result,String name){ 
    String[] parsedJson = json.replaceAll("[\n|\\s|\"]", "").split(",");
    List<String> fields = new ArrayList<>();
    for(int i = 0;i<parsedJson.length;i++){ 
      String curr =parsedJson[i];
      if (i==0) {
        curr = curr.substring(1, curr.length());
      }
      if (i==parsedJson.length-1) {
        curr = curr.substring(1, curr.length()-1);
      }
      String[] fieldNamesAndTypes = curr.split(":");
      String field = "  "+fieldDeclartionString.formatted(getTypeWithString(fieldNamesAndTypes[1]),fieldNamesAndTypes[0]);
      fields.add(field);
    }
    result.put(name,classDeclaration.formatted(name,String.join("\n", fields)));
    return "";
  }

  private String getTypeWithString(String jsonType){  
    if (jsonType.equals("integer")) {
      return "Integer";
    }else if (jsonType.equals("string")) {
      return "String";
    }else if (jsonType.equals("boolean")) {
      return "Boolean";
    }else{  
      throw new RuntimeException("Type: "+jsonType+" Does not exists In java");
    }

  }
}
