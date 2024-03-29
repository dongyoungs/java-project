package myapp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import myapp.net.NetProtocol;

public class Prompt {

  StringBuffer buf = new StringBuffer();
  DataInputStream in;
  DataOutputStream out;



  public Prompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public String inputString(String title, Object... args) throws IOException{
    this.out.writeUTF(String.format(title, args));
    this.out.writeUTF(NetProtocol.PROMPT);
    return this.in.readUTF();
  }

  public int inputInt(String title, Object... args) throws IOException{
    return Integer.parseInt(this.inputString(title, args));
  }

  public void print(String str) {
    buf.append(str);
  }

  public void println(String str) {
    buf.append(str);
    buf.append("\n");
  }

  public void printf(String format, Object... args) {
    buf.append(String.format(format, args));
  }

  public void clear() {
    buf.setLength(0);
  }

  public void end() throws IOException {
    this.out.writeUTF(buf.toString());
    this.out.writeUTF(NetProtocol.RESPONSE_END);
    buf.setLength(0);
  }
}
