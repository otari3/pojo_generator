package ge.data;

import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataSuplier {
  @DataProvider(name = "simpleJsonData")
  public Object[][] simpleJsonData(){ 
    String json = "{\n" + //
        "  \"id\": \"integer\",\n" + //
        "  \"name\": \"string\",\n" + //
        "  \"email\": \"string\",\n" + //
        "  \"isActive\": \"boolean\",\n" + //
        "  \"createdAt\": \"string\"\n" + //
        "}";
    Map<String,String> expectedResults = Map.of("RandomName", 
            "package ge.testClasses;\n" + //
            "public class RandomName { \n" + //
            "  public Integer id;\n" + //
            "  public String name;\n" + //
            "  public String email;\n" + //
            "  public Boolean isActive;\n" + //
            "  public String reatedAt;\n" + //
            " }");
    return new Object[][]{{json,expectedResults,"RandomName"}};
  }
}
