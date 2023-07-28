package myapp.dao;

import java.util.LinkedList;
import myapp.vo.BBQProduct;

public class MenuListDao {
  LinkedList<BBQProduct> list = new LinkedList<>();

  String fileName;

  public MenuListDao(String filename) {
    this.fileName = filename;

  }
}
