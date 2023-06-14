package myapp.vo;

public class product {
  String name;
  String menuCategory;
  int size;
  int price;

  public product(String str, int num, int menuPrice, String menu) {
    this.name = str;
    this.size = num;
    this.price = menuPrice;
    this.menuCategory = menu;
  }

  public int totalPrice() {
    return this.price * this.size;
  }

  public int getPrice() {
    return this.price;
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

  public void addMenu(int a) {
    size += a;
  }

}