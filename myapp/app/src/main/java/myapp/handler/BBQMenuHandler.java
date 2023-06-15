package myapp.handler;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import myapp.util.Prompt;
import myapp.vo.product;

public class BBQMenuHandler {

  static String input = "";
  static int subMenuNum = 0;
  private Prompt prompt;
  private BBQMenuList list = new BBQMenuList();

  public BBQMenuHandler(Prompt prompt) {
    this.prompt = prompt;

  }

  public boolean putInShoppingCart(String menu) {
    input = this.prompt.inputString("선택하신 메뉴를 장바구니에 담으시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      input = this.prompt.inputString("갯수를 설정해주세요\n> ");
      list.addMenu(menu, Integer.parseInt(input.replaceAll("[^0-9]", "")));
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
    HashMap<Integer, String> mainMenuMap = list.getMainMenuMap();
    for (int i = 1; i < 13; i++) {
      System.out.printf("%d. %s\n", i, mainMenuMap.get(i));
    }
    System.out.println("13. 직원호출 메뉴");
    System.out.println("14. 주문수정");
    System.out.println("15. 주문하기");
    System.out.println("0번은 프로그램 종료입니다.");
  }

  public void orderedMenuListShow() {
    int sum = 0;
    System.out.println("----------------------------------------");
    System.out.println("주문내역");
    System.out.println("----------------------------------------");

    for (product goods : list.orderedMenuList()) {
      System.out.println(goods.getName() + "  수량 : " + goods.getSize() + "  주문 가격 : " + goods.totalPrice());
      sum += goods.totalPrice();
    }
    System.out.println("총 주문가격 : " + sum + "원입니다.");
    input = this.prompt.inputString("주문하시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      list.initProduct();
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
      orderedMenuListShow();
    }
  }

  public void menuSelectShow(int mainMenuNum) {
    HashMap<Integer, String> mainMenuMap = list.getMainMenuMap();
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
    for (product goods : list.selectedMenuList(detailMenuName)) {
      int num = 1;
      System.out.printf("%d. %s - %d\n", num, goods.getName(), goods.getPrice());
    }
  }

  public String setMenuName(int mainMenuNum, int subMenuNum) {
    HashMap<String, Map<Integer, String>> subMenuMap = list.getSubMenuMap();
    HashMap<Integer, String> mainMenuMap = list.getMainMenuMap();
    return subMenuMap.get(mainMenuMap.get(mainMenuNum)).get(subMenuNum);
  }

  public void editSelectedMenu() {
    ArrayList<String> menuList = list.getMenuList();
    System.out.println("-----------------------------");
    System.out.println("현재 주문내역");
    System.out.println("-----------------------------");
    int menuNo = 0;
    for (product goods : list.orderedMenuList()) {
      System.out.printf("%d. %s   수량 : %d   주문 가격 : %d\n", (menuList.size() + 1), goods.getName(), goods.getSize(),
          goods.totalPrice());
      menuNo++;
      menuList.add(goods.getName());
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
    ArrayList<product> productList = list.getProductList();
    for (int i = 0; i < productList.size(); i++) {
      product goods = productList.get(i);
      if (menuList.get(No - 1).equals(goods.getName()) && goods.getSize() > 0) {
        while (true) {
          input = this.prompt.inputString("해당 메뉴 주문을 취소하시려면 0, 수량 재설정을 원하시면 주문하실 수량를 입력해주세요\n> ");
          if (input == input.replaceAll("[^0-9]", "") && Integer.parseInt(input) >= 0) {
            goods.setSize(Integer.parseInt(input));
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
