package myapp.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myapp.vo.product;

public class BBQMenuList {
  ArrayList<product> productList = new ArrayList<product>();
  ArrayList<String> menuList = new ArrayList<String>();
  HashMap<Integer, String> mainMenuMap = new HashMap<Integer, String>();
  HashMap<String, Map<Integer, String>> subMenuMap = new HashMap<String, Map<Integer, String>>();
  HashMap<Integer, String> foodMap1 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap2 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap3 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap4 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap5 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap6 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap7 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap8 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap9 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap10 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap11 = new HashMap<Integer, String>();
  HashMap<Integer, String> foodMap12 = new HashMap<Integer, String>();

  public BBQMenuList() {
    initData();
  }

  public HashMap<Integer, String> getMainMenuMap() {
    return mainMenuMap;
  }

  public HashMap<String, Map<Integer, String>> getSubMenuMap() {
    return subMenuMap;
  }

  public ArrayList<String> getMenuList() {
    return menuList;
  }

  public ArrayList<product> getProductList() {
    return productList;
  }

  public void addMenu(String menu, int menuSize) {
    for (int i = 0; i < productList.size(); i++) {
      if (productList.get(i).getName().equals(menu)) {
        productList.get(i).addSize(menuSize);
      }
    }
  }

  public product[] orderedMenuList() {
    ArrayList<product> list = new ArrayList<>();
    for (product goods : productList) {
      if (goods.getSize() > 0) {
        list.add(goods);
      }
    }
    product[] resultList = new product[list.size()];
    resultList = list.toArray(resultList);
    return resultList;
  }

  public product[] selectedMenuList(String detailMenuName) {
    ArrayList<product> list = new ArrayList<>();
    for (product goods : productList) {
      if (goods.getName().equals(detailMenuName)) {
        list.add(goods);
      }
    }
    product[] resultList = new product[list.size()];
    resultList = list.toArray(resultList);
    return resultList;
  }

  public void initProduct() {
    for (product goods : productList) {
      goods.init();
    }
  }

  private void initData() {
    // 메뉴 데이터 초기화
    productList.add(new product("황금올리브치킨", 0, 20000, "1"));
    productList.add(new product("황올 반+양념 반", 0, 21000, "2"));
    productList.add(new product("황금올리브치킨 블랙페퍼", 0, 21000, "3"));
    productList.add(new product("자메이카 소떡만나치킨", 0, 24000, "4"));
    productList.add(new product("자메이카 통다리구이", 0, 21500, "5"));
    productList.add(new product("황금올리브치킨 콤보", 0, 24000, "6"));
    productList.add(new product("TOP3세트메뉴 Set1", 0, 26000, "7"));
    productList.add(new product("황금올리브치킨 반마리", 0, 11000, "8"));
    productList.add(new product("BBQ 치킨버거(마일드)", 0, 5000, "9"));
    productList.add(new product("황올한팝콘 카라멜맛", 0, 1800, "10"));
    productList.add(new product("유자폰스소스", 0, 1500, "11"));
    productList.add(new product("스파클링 레몬보이 245ml", 0, 1000, "12"));

    mainMenuMap.put(1, "후라이드");
    mainMenuMap.put(2, "반반");
    mainMenuMap.put(3, "시즈닝");
    mainMenuMap.put(4, "양념");
    mainMenuMap.put(5, "구이");
    mainMenuMap.put(6, "황올 콤보시리즈");
    mainMenuMap.put(7, "세트메뉴");
    mainMenuMap.put(8, "1인분 메뉴");
    mainMenuMap.put(9, "피자/버거");
    mainMenuMap.put(10, "사이드메뉴");
    mainMenuMap.put(11, "소스류");
    mainMenuMap.put(12, "음료/주류");

    // food 추가
    foodMap1.put(1, "황금올리브치킨");
    foodMap2.put(1, "황올 반+양념 반");
    foodMap3.put(1, "황금올리브치킨 블랙페퍼");
    foodMap4.put(1, "자메이카 소떡만나치킨");
    foodMap5.put(1, "자메이카 통다리구이");
    foodMap6.put(1, "황금올리브치킨 콤보");
    foodMap7.put(1, "TOP3세트메뉴 Set1");
    foodMap8.put(1, "황금올리브치킨 반마리");
    foodMap9.put(1, "BBQ 치킨버거(마일드)");
    foodMap10.put(1, "황올한팝콘 카라멜맛");
    foodMap11.put(1, "유자폰스소스");
    foodMap12.put(1, "스파클링 레몬보이 245ml");

    // subMenuMap 추가
    subMenuMap.put(mainMenuMap.get(1), foodMap1);
    subMenuMap.put(mainMenuMap.get(2), foodMap2);
    subMenuMap.put(mainMenuMap.get(3), foodMap3);
    subMenuMap.put(mainMenuMap.get(4), foodMap4);
    subMenuMap.put(mainMenuMap.get(5), foodMap5);
    subMenuMap.put(mainMenuMap.get(6), foodMap6);
    subMenuMap.put(mainMenuMap.get(7), foodMap7);
    subMenuMap.put(mainMenuMap.get(8), foodMap8);
    subMenuMap.put(mainMenuMap.get(9), foodMap9);
    subMenuMap.put(mainMenuMap.get(10), foodMap10);
    subMenuMap.put(mainMenuMap.get(11), foodMap11);
    subMenuMap.put(mainMenuMap.get(12), foodMap12);
  }
}
