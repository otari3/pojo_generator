package ge.data;

import java.util.List;

public class Constants {
  public static String simpleJsonObjet = "{\n" + //
        "  \"id\": \"integer\",\n" + //
        "  \"name\": \"string\",\n" + //
        "  \"email\": \"string\",\n" + //
        "  \"isActive\": \"boolean\",\n" + //
        "  \"createdAt\": \"string\"\n" + //
        "}";
  public static String oneNestedJson =  
        "{\n" + //
        "  \"id\": integer,\n" + //
        "  \"category\": {\n" + //
        "    \"id\": integer,\n" + //
        "    \"name\": \"string\"\n" + //
        "  },\n" + //
        "  \"name\": \"string\",\n" + //
        "  \"status\": \"string\"\n" + //
        "}";
 public static final String SIMPLE_JSON_FILE_NAME = "SimpleJsonTest";
 public static final String ONE_NESTED_JSON_FILE_NAME = "OneNestedJsonFileName";
 public static final List<String> ONE_NESETED_JSON_FILES_NAME = List.of(ONE_NESTED_JSON_FILE_NAME,"Category");
 public static final String MULTIPLE_NESTED_JSON_FILE_NAME = "MultipleNestedJson";
 public static final List<String> MULTIPLE_NESTED_JSON_FILES_NAMES = List.of(MULTIPLE_NESTED_JSON_FILE_NAME,"BillingAddress","Customer","ShippingAddress");
 public static final String multipleNestedJsonObjects =     
            "{\n" + //
              "  \"orderId\": \"integer\",\n" + //
              "  \"status\": \"string\",\n" + //
              "  \"customer\": {\n" + //
              "    \"id\": \"integer\",\n" + //
              "    \"name\": \"string\",\n" + //
              "    \"billingAddress\": {\n" + //
              "      \"street\": \"string\",\n" + //
              "      \"zipCode\": \"string\",\n" + //
              "      \"country\": \"string\"\n" + //
              "    },\n" + //
              "    \"shippingAddress\": {\n" + //
              "      \"street\": \"string\",\n" + //
              "      \"zipCode\": \"string\",\n" + //
              "      \"country\": \"string\"\n" + //
              "    }\n" + //
              "  }\n" + //
              "}";
}
