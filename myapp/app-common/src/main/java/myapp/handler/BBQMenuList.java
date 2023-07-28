package myapp.handler;

import java.util.ArrayList;
import myapp.vo.BBQProduct;

public class BBQMenuList {
  ArrayList<BBQProduct> productList = new ArrayList<BBQProduct>();
  ArrayList<String> mainMenuList = new ArrayList<String>();

  public ArrayList<BBQProduct> getSubMenuProductList(int num) {
    String filter = mainMenuList.get(num - 1);
    ArrayList<BBQProduct> subMenuList = new ArrayList<>();
    for (BBQProduct obj : productList) {
      if (obj.getMenuCategory().equals(filter)) {
        subMenuList.add(obj);
      }
    }
    return subMenuList;
  }

  public ArrayList<String> getSubMenuList(int num) {
    String filter = mainMenuList.get(num - 1);
    ArrayList<String> subMenuList = new ArrayList<>();
    for (BBQProduct obj : productList) {
      if (obj.getMenuCategory().equals(filter)) {
        subMenuList.add(obj.getName());
      }
    }
    return subMenuList;
  }

  public BBQMenuList() {
    // initData();
  }

  public ArrayList<BBQProduct> getProductList() {
    return productList;
  }

  public void addMenu(String menu, int menuSize) {
    for (int i = 0; i < productList.size(); i++) {
      if (productList.get(i).getName().equals(menu)) {
        productList.get(i).addSize(menuSize);
      }
    }
  }

  public ArrayList<String> getMainMenuList() {
    return this.mainMenuList;
  }

  public BBQProduct[] orderedMenuList() {
    ArrayList<BBQProduct> list = new ArrayList<>();
    for (BBQProduct goods : productList) {
      if (goods.getSize() > 0) {
        list.add(goods);
      }
    }
    BBQProduct[] resultList = new BBQProduct[list.size()];
    resultList = list.toArray(resultList);
    return resultList;
  }

  public BBQProduct[] selectedMenuList(String detailMenuName) {
    ArrayList<BBQProduct> list = new ArrayList<>();
    for (BBQProduct goods : productList) {
      if (goods.getName().equals(detailMenuName)) {
        list.add(goods);
      }
    }
    BBQProduct[] resultList = new BBQProduct[list.size()];
    resultList = list.toArray(resultList);
    return resultList;
  }

  public void initProduct() {
    for (BBQProduct goods : productList) {
      goods.init();
    }
  }


  public void addMenuData(BBQProduct product) {
    productList.add(product);
  }

  public void getDataFromJson(String str) {

  }

}
