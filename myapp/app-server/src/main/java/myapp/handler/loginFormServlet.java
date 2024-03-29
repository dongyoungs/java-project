package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/form")
public class loginFormServlet extends HttpServlet {


  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='/auth/login' method=\"post\">");
    out.println("<table border=\"1\">");
    out.println("<tr>");
    out.println("<th>이메일</th> <td><input type='email' name='email'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>암호</th> <td><input type='password' name='password'></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<button>로그인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}

