package ge.runner;

import ge.data.Constants;
import ge.pojo.Pojo;

public class Main {
  public static void main(String[] args) {
  String testPath = "src/test/java/ge/testClasses";
  String testPackage = "ge.testClasses";
  new Pojo().deserialize(Constants.multipleNestedJsonObjects, Constants.MULTIPLE_NESTED_JSON_FILE_NAME, testPackage, testPath);
  }
}
