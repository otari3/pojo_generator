package ge.pojo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ge.Util.Tuple;





public class Pojo {
  private String classDeclaration = "public class %s { \n%s\n }";

  public void deserialize(String json,String name,String packageStr,String path){
    deserializeHelper(json,name,packageStr,path,1);
  }

  private Tuple deserializeHelper(String json,String name,String packageStr,String path,int startIndex){ 
    char[] parsedJson = json.replaceAll("[\n|\\s|\"]", "").toCharArray();
    List<String> fields = new ArrayList<>();
    List<String> classInformation = new ArrayList<>(List.of("package %s;\n".formatted(packageStr)));
    String curr = "";
    int index = startIndex;
    for(int i = index;i<parsedJson.length;i++){ 
      char currVal = parsedJson[i];
      if (currVal==',') {
        String[] nameANDtype = curr.split(":");
        fields.add("  "+formatField(nameANDtype[0], getTypeWithString(nameANDtype[1])));
        curr = "";
      }else if (currVal==':') {
        Tuple tuple = null;
        if (parsedJson[i+1]=='{') {
          tuple = deserializeHelper(json, changeFirstLetterToUpperCase(curr), packageStr, path, i+2);
            i = tuple.index;
            curr+=currVal;
            curr+=tuple.value;
        }else{  
          curr+=currVal;
        }
      } 
      else if (currVal=='}') {
        index = i;
        break;
      }else{  
        curr+=currVal;
      }
    }
    String[] nameANDtype = curr.split(":");
    fields.add("  "+formatField(nameANDtype[0], getTypeWithString(nameANDtype[1])));
    String classBlock = String.join("", classInformation)+classDeclaration.formatted(name,String.join("\n", fields));
    Path fullPath = Path.of(path+"/%s.java".formatted(name));
    createFile(fullPath, classBlock);
    return new Tuple(index, name);
  }

  private String getTypeWithString(String jsonType){  
    if (jsonType.equals("integer")) {
      return "Integer";
    }else if (jsonType.equals("string")) {
      return "String";
    }else if (jsonType.equals("boolean")) {
      return "Boolean";
    }
    return jsonType;
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
