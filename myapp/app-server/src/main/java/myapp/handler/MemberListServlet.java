package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.vo.Member;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시글</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 목록</h1>");
    out.println("<div style='margin:5px;'>");
    out.printf("<a href='/member/memberForm.html'>새 글</a>\n");
    out.println("</div>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("  <tr><th>번호</th> <th>이름</th> <th>이메일</th> ");
    out.println("</thead>");


    List<Member> list = InitServlet.memberDao.findAll();

    for (Member m : list) {
      out.printf("<tr>"
          + "<td>%d</td>"
          + " <td><a href='/member/view?no=%d'>%s</td>"
          + " <td>%s</td></tr>\n",
          m.getNo(),m.getNo(), m.getName(), m.getEmail());
    }
    out.println("</tbody>");
    out.println("<table>");
    out.println("<a href='/'>메인</a>");
    out.println("</body>");
    out.println("</html>");

  }
}










