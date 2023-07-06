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

  public void initMainMenuList() {
    // 메뉴 데이터 초기화
    // productList.add(new BBQProduct("황금올리브치킨", 0, 20000, "후라이드", 1));
    // productList.add(new BBQProduct("황올 반+양념 반", 0, 21000, "반반", 1));
    // productList.add(new BBQProduct("황금올리브치킨 블랙페퍼", 0, 21000, "시즈닝", 1));
    // productList.add(new BBQProduct("자메이카 소떡만나치킨", 0, 24000, "양념", 1));
    // productList.add(new BBQProduct("자메이카 통다리구이", 0, 21500, "구이", 1));
    // productList.add(new BBQProduct("황금올리브치킨 콤보", 0, 24000, "황올 콤보시리즈", 1));
    // productList.add(new BBQProduct("TOP3세트메뉴 Set1", 0, 26000, "세트메뉴", 1));
    // productList.add(new BBQProduct("황금올리브치킨 반마리", 0, 11000, "1인분 메뉴", 1));
    // productList.add(new BBQProduct("BBQ 치킨버거(마일드)", 0, 5000, "피자/버거", 1));
    // productList.add(new BBQProduct("황올한팝콘 카라멜맛", 0, 1800, "사이드메뉴", 1));
    // productList.add(new BBQProduct("유자폰스소스", 0, 1500, "소스류", 1));
    // productList.add(new BBQProduct("스파클링 레몬보이 245ml", 0, 1000, "음류/주류", 1));
    // 메인메뉴 리스트
    // 데이터가 임의로 들어올 경우 메뉴 정렬 후 넣어야함
    mainMenuList.clear();
    for (int i = 0; i < productList.size(); i++) {
      if (1 == productList.get(i).getMenuOrder()) {
        mainMenuList.add(productList.get(i).getMenuCategory());
      }
    }

  }

  public void addMenuData(BBQProduct product) {
    productList.add(product);
  }

  public void getDataFromJson(String str) {

  }

}
