package ge.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import ge.Util.Util;
import ge.data.DataSuplier;
import ge.pojo.Pojo;

public class DesirilezeTest {
  
  @Test(dataProviderClass = DataSuplier.class,dataProvider = "simpleJsonData")
  public void simpleJsonTest(String json,Map<String,String> expectedResults,String name){ 
    Pojo pojo = new Pojo();
    pojo.deserialize(json, name);
    for(String keys:expectedResults.keySet()){
     String expctedResults = Util.formatString(expectedResults.get(keys));
     String actualResults = Util.formatString(pojo.results.get(keys));
     Assert.assertEquals(actualResults, expctedResults);
    }
  }
}
