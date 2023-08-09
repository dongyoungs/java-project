package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class mainWindowServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getParameter("initLogin") != null) {
      if (request.getParameter("initLogin").equals("1")) {
        String emailKey = (String)request.getSession().getAttribute(request.getSession().getId());
        InitServlet.sessionMap.remove(emailKey);
        request.getSession().removeAttribute(emailKey);
        request.getSession().removeAttribute(request.getSession().getId());
      }
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>PracticeApp</h1>");
    out.println("<ul>");
    out.println(" <li><a href=\"/member/list\">회원</a></li>");
    out.println("<li><a href=\"/board/list?category=1\">게시판</a></li>");
    out.println("<li><a href=\"/board/list?category=2\">독서록</a></li>");
    if (request.getCookies() != null) {
      if (request.getSession().getAttribute(request.getSession().getId()) != null) {
        out.println("<li><a href=\"/?initLogin=1\">로그아웃</a></li>");
      } else {
        out.println("<li><a href=\"/auth/form\">로그인</a></li>");
      }
    } else {
      out.println("<li><a href=\"/auth/form\">로그인</a></li>");
    }

    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
  }
}
