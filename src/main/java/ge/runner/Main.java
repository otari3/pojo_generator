package ge.runner;

import ge.data.Constants;
import ge.pojo.Pojo;

public class Main {
  public static void main(String[] args) {
    Pojo pojo = new Pojo();
    pojo.deserialize(Constants.simpleJsonObjet,"RandomName");
  }
}
