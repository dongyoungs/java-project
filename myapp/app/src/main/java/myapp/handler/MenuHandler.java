package myapp.handler;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import myapp.util.Prompt;
import myapp.vo.product;

public class MenuHandler {

  static String input = "";
  static int subMenuNum = 0;
  private Prompt prompt;

  static ArrayList<product> productList = new ArrayList<product>();
  static ArrayList<String> menuList = new ArrayList<String>();
  static HashMap<Integer, String> mainMenuMap = new HashMap<Integer, String>();
  static HashMap<String, Map<Integer, String>> subMenuMap = new HashMap<String, Map<Integer, String>>();
  static HashMap<Integer, String> foodMap1 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap2 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap3 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap4 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap5 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap6 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap7 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap8 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap9 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap10 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap11 = new HashMap<Integer, String>();
  static HashMap<Integer, String> foodMap12 = new HashMap<Integer, String>();

  public MenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void initData() {
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

  public boolean putInShoppingCart(String menu) {
    input = this.prompt.inputString("선택하신 메뉴를 장바구니에 담으시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      input = this.prompt.inputString("갯수를 설정해주세요\n> ");
      subMenuNum = Integer.parseInt(input.replaceAll("[^0-9]", ""));
      for (int i = 0; i < productList.size(); i++) {
        if (productList.get(i).getName().equals(menu)) {
          productList.get(i).addMenu(subMenuNum);
        }
      }
      System.out.println("선택하신 메뉴를 장바구니에 담았습니다.");
      System.out.println("메인메뉴로 돌아갑니다");
      System.out.println("\n\n");
      stopping(1500);
      return true;

    } else if (input.equalsIgnoreCase("n")) {
      return false;
    } else {
      System.out.println("잘못 입력하셧습니다.");
      System.out.println("\n\n");
      return false;
    }
  }

  public void mainMenuShow() {

    for (int i = 1; i < 13; i++) {
      System.out.printf("%d. %s\n", i, mainMenuMap.get(i));
    }
    System.out.println("13. 직원호출 메뉴");
    System.out.println("14. 주문수정");
    System.out.println("15. 주문하기");
    System.out.println("0번은 프로그램 종료입니다.");
  }

  public void selectedMenuListShow() {
    int sum = 0;
    System.out.println("----------------------------------------");
    System.out.println("주문내역");
    System.out.println("----------------------------------------");
    for (int i = 0; i < productList.size(); i++) {
      product goods = productList.get(i);
      if (goods.getSize() > 0) {
        System.out.println(goods.getName() + "  수량 : " + goods.getSize() + "  주문 가격 : " + goods.totalPrice());
        sum += goods.totalPrice();
      }
    }
    System.out.println("총 주문가격 : " + sum + "원입니다.");
    input = this.prompt.inputString("주문하시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      for (int i = 0; i < productList.size(); i++) {
        product goods = productList.get(i);
        goods.init();
      }
      System.out.println("주문이 완료되었습니다.");
      System.out.println("\n\n");
      stopping(1500);
    } else if (input.equalsIgnoreCase("n")) {
      System.out.println("메인메뉴로 돌아갑니다.");
      System.out.println("\n\n");
      stopping(1500);
    } else {
      System.out.println("잘못입력하셧습니다");
      System.out.println("\n\n");
      selectedMenuListShow();
    }
  }

  public void menuSelectShow(int mainMenuNum) {
    String menu = mainMenuMap.get(mainMenuNum);
    while (true) {
      System.out.println("-----------------------------");
      System.out.println("        " + menu + "         ");
      System.out.println("-----------------------------");
      detailMenuShow(mainMenuNum);
      input = this.prompt.inputString(">");
      subMenuNum = Integer.parseInt(input.replaceAll("[^0-9]", ""));
      String menuName = setMenuName(mainMenuNum, subMenuNum);
      if (putInShoppingCart(menuName)) {
        break;
      } else {
        continue;
      }
    }
  }

  void detailMenuShow(int mainMenuNum) {
    String detailMenuName = setMenuName(mainMenuNum, 1);
    for (int i = 0; i < productList.size(); i++) {
      product goods = productList.get(i);
      if (goods.getName().equals(detailMenuName)) {
        int num = 1;
        System.out.printf("%d. %s - %d\n", num, goods.getName(), goods.getPrice());
      }
    }
  }

  public String setMenuName(int mainMenuNum, int subMenuNum) {
    return subMenuMap.get(mainMenuMap.get(mainMenuNum)).get(subMenuNum);
  }

  public void editSelectedMenu() {
    menuList.clear();
    System.out.println("-----------------------------");
    System.out.println("현재 주문내역");
    System.out.println("-----------------------------");
    int menuNo = 0;
    for (int i = 0; i < productList.size(); i++) {
      product goods = productList.get(i);
      if (goods.getSize() > 0) {
        System.out.printf("%d. %s   수량 : %d   주문 가격 : %d\n", (menuList.size() + 1), goods.getName(), goods.getSize(),
            goods.totalPrice());
        menuNo++;
        menuList.add(goods.getName());
      }
    }
    if (menuNo == 0) {
      System.out.println("현재 주문내역이 없습니다. 메인화면으로 이동합니다");
      System.out.println("\n\n");
      stopping(1500);
      return;
    }
    System.out.println("\n\n");
    System.out.println("수정할 메뉴 번호를 입력해주세요");
    int No = Integer.parseInt(this.prompt.inputString("> "));
    if (No == 0) {
      System.out.println("잘못입력하셧습니다. 메인메뉴로 돌아갑니다.");
      System.out.println("\n\n");
      stopping(1500);
    }

    for (int i = 0; i < productList.size(); i++) {
      product goods = productList.get(i);
      if (menuList.get(No - 1).equals(goods.getName()) && goods.getSize() > 0) {
        while (true) {
          input = this.prompt.inputString("해당 메뉴 주문을 취소하시려면 0, 수량 재설정을 원하시면 주문하실 수량를 입력해주세요\n> ");
          if (input == input.replaceAll("[^0-9]", "") && Integer.parseInt(input) >= 0) {
            goods.addMenu(Integer.parseInt(input));
            System.out.println("주문이 수정되었습니다 ");
            System.out.println("\n\n");
            stopping(1500);
            return;
          } else {
            System.out.println("잘못 입력하셧습니다.  입력시 문자 포함없이 숫자만입력하십시오");
          }
        }

      }
    }
    System.out.println("잘못 입력하셧습니다.  메인화면으로 돌아갑니다.");
    System.out.println("\n\n");
    stopping(1500);

  }

  private void stopping(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      System.out.println("error");
    }
  }

}
