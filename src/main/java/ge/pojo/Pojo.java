package ge.pojo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Pojo {
  private String classDeclaration = "public class %s { \n%s\n }";

  public void deserialize(String json,String name,String packageStr,String path){
    deserializeHelper(json,name,packageStr,path);
  }

  private String deserializeHelper(String json,String name,String packageStr,String path){ 
    String[] parsedJson = json.replaceAll("[\n|\\s|\"]", "").split(",");
    List<String> fields = new ArrayList<>();
    List<String> classInformation = new ArrayList<>(List.of("package %s;\n".formatted(packageStr)));
    System.out.println(Arrays.toString(parsedJson));
    System.out.println(parsedJson[2]);
    for(int i = 0;i<parsedJson.length;i++){ 
      String curr =parsedJson[i];
      if (isJsonObject(json)) {
        if (i==0) {
          curr = curr.substring(1, curr.length());
        }
        if (i==parsedJson.length-1) {
          curr = curr.substring(1, curr.length()-1);
        }
      }
      String[] fieldNamesAndTypes = curr.split(":");
      if (isJsonObject(fieldNamesAndTypes[1])) {
        String field = "  "+formatField(fieldNamesAndTypes[0],  
                            deserializeHelper(fieldNamesAndTypes[1], changeFirstLetterToUpperCase(fieldNamesAndTypes[0]), packageStr, path));
         fields.add(field);
      }
      String field = "  "+formatField(fieldNamesAndTypes[0], getTypeWithString(fieldNamesAndTypes[1]));
      fields.add(field);
    }
    String classBlock = String.join("", classInformation)+classDeclaration.formatted(name,String.join("\n", fields));
    Path fullPath = Path.of(path+"/%s.java".formatted(name));
    createFile(fullPath, classBlock);
    return name;
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
  private void createFile(Path path,String code){  
    try(FileWriter fileWriter = new FileWriter(path.toFile())){ 
        fileWriter.write(code);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private String formatField(String fieldName,String fieldType){
    String fieldDeclartionString = "public %s %s;";
    return fieldDeclartionString.formatted(fieldType,fieldName);
  }
  private boolean isJsonObject(String json){ 
    String start = json.substring(0, 1);
    String end = json.substring(json.length()-1, json.length());
    if (end.equals(",")) {
      end = json.substring(json.length()-2, json.length()-1);
    }
    return start.equals("{") && end.equals("}");
  }
  private String changeFirstLetterToUpperCase(String txt){  
    char[] currtxt = txt.toCharArray();
    currtxt[0] = Character.toUpperCase(currtxt[0]);
    String formatedString = "";
    for(char chr:currtxt){  
      formatedString+=chr;
    }
    return formatedString;
  }
}
