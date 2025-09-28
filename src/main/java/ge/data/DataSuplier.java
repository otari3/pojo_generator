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
    Map<String,String> expectedResults = Map.of(Constants.SIMPLE_JSON_FILE_NAME, 
            "package ge.testClasses;\n" + //
            "public class %s { \n".formatted(Constants.SIMPLE_JSON_FILE_NAME) + //
            "  public Integer id;\n" + //
            "  public String name;\n" + //
            "  public String email;\n" + //
            "  public Boolean isActive;\n" + //
            "  public String createdAt;\n" + //
            " }");
    return new Object[][]{{json,expectedResults}};
  }
  @DataProvider(name = "oneNestedJson")
  public Object[][] oneNestedJson(){ 
    String json = Constants.oneNestedJson;
    Map<String,String> expectedResults = Map.of(  
            Constants.ONE_NESETED_JSON_FILES_NAME.get(0), 
                            "package ge.testClasses;\n" + //
                            "public class OneNestedJsonFileName { \n" + //
                            "  public Integer id;\n" + //
                            "  public Category category;\n" + //
                            "  public String name;\n" + //
                            "  public String status;\n" + //
                            " }",
            Constants.ONE_NESETED_JSON_FILES_NAME.get(1),
                            "package ge.testClasses;\n" + //
                            "public class Category { \n" + //
                            "  public Integer id;\n" + //
                            "  public String name;\n" + //
                            " }"
                            );
    return new Object[][]{{json,expectedResults}};
  }
   @DataProvider(name = "multipleNestedJson")
  public Object[][] multipleNestedJson(){ 
    String json = Constants.multipleNestedJsonObjects;
      Map<String,String> expectedResults = Map.of(  
                  Constants.MULTIPLE_NESTED_JSON_FILES_NAMES.get(0),  
                                    "package ge.testClasses;\n" + //
                                    "public class MultipleNestedJson { \n" + //
                                    "  public Integer orderId;\n" + //
                                    "  public String status;\n" + //
                                    "  public Customer customer;\n" + //
                                    " }",
                  Constants.MULTIPLE_NESTED_JSON_FILES_NAMES.get(1),  
                                      "package ge.testClasses;\n" + //
                                        "public class BillingAddress { \n" + //
                                        "  public String street;\n" + //
                                        "  public String zipCode;\n" + //
                                        "  public String country;\n" + //
                                        " }",
                  Constants.MULTIPLE_NESTED_JSON_FILES_NAMES.get(2),  
                                        "package ge.testClasses;\n" + //
                                        "public class Customer { \n" + //
                                        "  public Integer id;\n" + //
                                        "  public String name;\n" + //
                                        "  public BillingAddress billingAddress;\n" + //
                                        "  public ShippingAddress shippingAddress;\n" + //
                                        " }",
                  Constants.MULTIPLE_NESTED_JSON_FILES_NAMES.get(3),    
                                      "package ge.testClasses;\n" + //
                                        "public class ShippingAddress { \n" + //
                                        "  public String street;\n" + //
                                        "  public String zipCode;\n" + //
                                        "  public String country;\n" + //
                                        " }"
                      
                            );
    return new Object[][]{{json,expectedResults}};
  }
}
