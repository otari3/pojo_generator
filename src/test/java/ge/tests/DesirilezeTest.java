package ge.tests;

import java.nio.file.Path;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import ge.Util.Util;
import ge.data.Constants;
import ge.data.DataSuplier;
import ge.pojo.Pojo;

public class DesirilezeTest {
  String testPath = "src/test/java/ge/testClasses";
  String testPackage = "ge.testClasses";
  @Test(dataProviderClass = DataSuplier.class,dataProvider = "simpleJsonData")
  public void simpleJsonTest(String json,Map<String,String> expectedResults){ 
    Pojo pojo = new Pojo();
     pojo.deserialize(json, Constants.SIMPLE_JSON_FILE_NAME,testPackage,testPath);
     String expctedResults = Util.formatString(expectedResults.get(Constants.SIMPLE_JSON_FILE_NAME));
     String actualResults = Util.formatString(Util.getFileContent(Path.of(testPath+"/%s.java".formatted(Constants.SIMPLE_JSON_FILE_NAME))));
     Assert.assertEquals(actualResults, expctedResults);
  }
  @Test(dataProviderClass = DataSuplier.class,dataProvider = "oneNestedJson")
  public void oneNestedJsonTest(String json,Map<String,String> expectedResults){
     Pojo pojo = new Pojo();
     pojo.deserialize(json, Constants.ONE_NESTED_JSON_FILE_NAME, testPackage, testPath);
    for(String name:Constants.ONE_NESETED_JSON_FILES_NAME){
      String expctedResult = Util.formatString(expectedResults.get(name));
      String actualResults = Util.formatString(Util.getFileContent(Path.of(testPath+"/%s.java".formatted(name))));
      Assert.assertEquals(actualResults, expctedResult);
    }
  }
  @Test(dataProviderClass = DataSuplier.class,dataProvider = "multipleNestedJson")
  public void multipleNestedJson(String json,Map<String,String> expectedResults){
     Pojo pojo = new Pojo();
     pojo.deserialize(json, Constants.MULTIPLE_NESTED_JSON_FILE_NAME, testPackage, testPath);
    for(String name:Constants.MULTIPLE_NESTED_JSON_FILES_NAMES){
      String expctedResult = Util.formatString(expectedResults.get(name));
      String actualResults = Util.formatString(Util.getFileContent(Path.of(testPath+"/%s.java".formatted(name))));
      Assert.assertEquals(actualResults, expctedResult);
    }
  }
}
