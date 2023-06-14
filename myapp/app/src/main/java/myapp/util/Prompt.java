package myapp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  Scanner scanner = new Scanner(System.in);

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public Prompt(InputStream in) {
    this.scanner = new Scanner(in);
  }

  public String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return scanner.nextLine();
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(this.inputString(title,args));
  }

  public void close() {
    this.scanner.close();
  }
}
