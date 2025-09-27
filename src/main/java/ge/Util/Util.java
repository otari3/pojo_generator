package ge.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Util {
  public static String formatString(String val){ 
    return val.replaceAll("[\n|\\s]", "");
  }
  
  public static String getFileContent(Path path){  
    try {
      return new String(Files.readAllBytes(path));
    } catch (IOException e) {
      throw new RuntimeException("file could not be open");
    }
  }
}
