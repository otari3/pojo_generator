package ge.data;

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
}
