package myapp.vo;

public class BBQProduct {
  private String name;
  private String menuCategory;
  private int menuOrder = 1;
  private int size;
  private int price;

  // int firstCost; // 원가 추후 회계처리를위해 구현예정
  // boolean isEvent = flase // 이벤트기간인지 확인 , 이벤트시 변경되는 메뉴 저장할 별도의 클래스 필요

  public BBQProduct(String str, int num, int menuPrice, String menu, int menuOrder) {
    this.name = str;
    this.size = num;
    this.price = menuPrice;
    this.menuCategory = menu;
    this.menuOrder = menuOrder;

    // this.isEvent = false;
  }

  public int totalPrice() {
    return this.price * this.size;
  }

  public int getPrice() {
    return this.price;
  }

  public int getMenuOrder() {
    return this.menuOrder;
  }

  public void init() {
    size = 0;
  }

  public String getName() {
    return this.name;
  }

  public int getSize() {
    return this.size;
  }

  public String getMenuCategory() {
    return this.menuCategory;
  }

  public void addSize(int a) {
    size += a;
  }

  public void setSize(int a) {
    size = a;
  }

  public static BBQProduct fromCsvString(String str, String format) {
    String[] values = str.split(format);
    // System.out.println("메뉴이름 :" + values[0] +
    // " 갯수 : " + values[1] +
    // " 가격 : " + values[2] +
    // " 메뉴 카테고리 : " + values[3] +
    // " 하위번호 : " + values[4]);
    BBQProduct product = new BBQProduct(
        values[0], // 메뉴 이름
        Integer.parseInt(values[1]), // 갯수 (0개)
        Integer.parseInt(values[2]), // 가격
        values[3], // 메뉴 카테고리
        Integer.parseInt(values[4]) // 카테고리 하위 번호
        );
    return product;
  }

}