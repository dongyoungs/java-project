package myapp.handler;

import java.io.IOException;
import java.util.ArrayList;
import myapp.util.Prompt;
import myapp.vo.BBQProduct;

public class BBQMenuHandler {

  static String input = "";
  static int subMenuNum = 0;
  private Prompt prompt;
  private BBQMenuList list;

  public BBQMenuHandler(Prompt prompt, BBQMenuList list) {
    this.prompt = prompt;
    this.list = list;

  }

  public boolean putInShoppingCart(String menu) throws IOException{
    input = prompt.inputString("선택하신 메뉴를 장바구니에 담으시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      input = this.prompt.inputString("갯수를 설정해주세요\n> ");
      list.addMenu(menu, Integer.parseInt(input.replaceAll("[^0-9]", "")));
      prompt.println("선택하신 메뉴를 장바구니에 담았습니다.");
      prompt.println("메인메뉴로 돌아갑니다");
      prompt.println("\n");

      return true;

    } else if (input.equalsIgnoreCase("n")) {
      return false;
    } else {
      prompt.println("잘못 입력하셧습니다.");
      prompt.println("\n");
      return false;

    }
  }

  public void mainMenuShow() throws IOException{
    ArrayList<String> mainMenus = list.getMainMenuList();
    for (int i = 1; i < 13; i++) {
      prompt.printf("%d. %s\n", i, mainMenus.get(i - 1));
    }
    prompt.println("13. 직원호출 메뉴");
    prompt.println("14. 주문수정");
    prompt.println("15. 주문하기");
    prompt.println("0번은 프로그램 종료입니다.");
    prompt.end();
  }

  public void orderedMenuListShow() throws IOException{
    int sum = 0;
    prompt.println("----------------------------------------");
    prompt.println("주문내역");
    prompt.println("----------------------------------------");

    for (BBQProduct goods : list.orderedMenuList()) {
      prompt.println(goods.getName() + "  수량 : " + goods.getSize() + "  주문 가격 : " + goods.totalPrice());
      sum += goods.totalPrice();
    }
    prompt.println("총 주문가격 : " + sum + "원입니다.");
    prompt.end();
    input = this.prompt.inputString("주문하시겠습니까? (Y/n)\n> ");
    if (input.equals("") || input.equalsIgnoreCase("Y")) {
      list.initProduct();
      prompt.println("주문이 완료되었습니다.");
      prompt.println("\n");
      prompt.end();

    } else if (input.equalsIgnoreCase("n")) {
      prompt.println("메인메뉴로 돌아갑니다.");
      prompt.println("\n");
      prompt.end();
    } else {
      prompt.println("잘못입력하셧습니다");
      prompt.println("\n");
      orderedMenuListShow();
      prompt.end();
    }
  }

  public void menuSelectShow(int mainMenuNum) throws IOException{
    ArrayList<String> mainMenus = list.getMainMenuList();
    String menu = mainMenus.get(mainMenuNum - 1);
    while (true) {
      prompt.println("-----------------------------");
      prompt.println("        " + menu + "         ");
      prompt.println("-----------------------------");
      detailMenuShow(mainMenuNum);
      input = this.prompt.inputString(">");
      subMenuNum = Integer.parseInt(input.replaceAll("[^0-9]", ""));
      String menuName = setMenuName(mainMenuNum, subMenuNum);
      prompt.println(menuName);
      prompt.end();
      if (subMenuNum == 0) {
        prompt.println("메인메뉴로 돌아갑니다.");
        prompt.println("\n");
        prompt.end();
        break;
      }
      if (putInShoppingCart(menuName)) {
        break;
      } else {
        continue;
      }
    }
  }

  void detailMenuShow(int mainMenuNum) throws IOException {
    // String detailMenuName = setMenuName(mainMenuNum, 1);
    for (BBQProduct goods : list.getSubMenuProductList(mainMenuNum)) {
      prompt.printf("%d. %s - %d\n", goods.getMenuOrder(), goods.getName(), goods.getPrice());
    }
    prompt.end();
  }

  public String setMenuName(int mainMenuNum, int subMenuNum) {
    ArrayList<BBQProduct> subMenuList = list.getSubMenuProductList(mainMenuNum);
    for (BBQProduct obj : subMenuList) {
      if (obj.getMenuOrder() == subMenuNum) {
        return obj.getName();
      }
    }
    return "";
  }

  public void editSelectedMenu() throws IOException{
    ArrayList<String> menuList = new ArrayList<>();
    prompt.println("-----------------------------");
    prompt.println("현재 주문내역");
    prompt.println("-----------------------------");
    prompt.end();
    int menuNo = 0;
    BBQProduct[] orderedMenuList = list.orderedMenuList();
    for (BBQProduct goods : orderedMenuList) {
      prompt.printf("%d. %s   수량 : %d   주문 가격 : %d\n", (menuList.size() + 1), goods.getName(), goods.getSize(),
          goods.totalPrice());
      menuNo++;
      menuList.add(goods.getName());
    }
    prompt.end();

    if (menuNo == 0) {
      prompt.println("현재 주문내역이 없습니다. 메인화면으로 이동합니다");
      prompt.println("\n");
      prompt.end();
      return;
    }
    prompt.println("\n");
    prompt.println("수정할 메뉴 번호를 입력해주세요 (나가기 - 99)");
    prompt.end();
    int No = Integer.parseInt(this.prompt.inputString("> "));
    if (No == 99) {
      prompt.println("메인메뉴로 돌아갑니다.");
      prompt.println("\n");
      prompt.end();
      return;
    }
    if (No == 0 || No > orderedMenuList.length) {
      prompt.println("잘못입력하셧습니다. 메인메뉴로 돌아갑니다.");
      prompt.println("\n");
      prompt.end();
      return;
    }
    ArrayList<BBQProduct> productList = list.getProductList();
    for (int i = 0; i < productList.size(); i++) {
      BBQProduct goods = productList.get(i);
      if (menuList.get(No - 1).equals(goods.getName()) && goods.getSize() > 0) {
        while (true) {

          input = this.prompt.inputString("해당 메뉴 주문을 취소하시려면 0, 수량 재설정을 원하시면 주문하실 수량를 입력해주세요\n> ");
          if (input == input.replaceAll("[^0-9]", "") && Integer.parseInt(input) >= 0) {
            goods.setSize(Integer.parseInt(input));
            prompt.println("주문이 수정되었습니다 ");
            prompt.println("\n");
            prompt.end();
            return;
          } else {
            prompt.println("잘못 입력하셧습니다.  입력시 문자 포함없이 숫자만입력하십시오");
            prompt.end();
          }
        }

      }
    }
    prompt.println("잘못 입력하셧습니다.  메인화면으로 돌아갑니다.");
    prompt.println("\n");
    prompt.end();

  }



}
