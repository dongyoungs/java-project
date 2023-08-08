package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.vo.Member;

@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {


  private static final long serialVersionUID = 1L;


  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

    String memberNo = request.getParameter("no");
    Member member = InitServlet.memberDao.findBy(
        Integer.parseInt(memberNo));
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시글</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    if (member == null) {
      out.println("<p>말씀하신 회원을 찾지 못했습니다.</p>");
    } else {
      out.println("<form action='/member/update' method='post'>");
      out.println("<table border='1'>");
      out.printf("<tr><th style='width:120px;'>번호</th>"
          + " <td style='width:300px;'><input type='text' name='no' value='%d' readonly='readonly'></td></tr>\n", member.getNo());
      out.printf("<tr><th>이름</th>"
          + " <td><input type='text' name='name' value='%s'></td></tr>\n", member.getName());
      out.printf("<tr><th>이메일</th>"
          + " <td><input type='text' name='email' value='%s'></td></tr>\n", member.getEmail());
      out.println("<tr><th>암호</th>"
          + " <td><input type='password' name='password'></td></tr>");
      out.printf("<tr><th>성별</th>"
          + " <td><input type='text' name='gender' value='%s'></td></tr>\n", String.valueOf( member.getGender()));

      out.printf("<tr><th>등록일</th> <td>%tY-%1$tm-%1$td</td></tr>\n", member.getCreatedDate());
      out.println("</table>");

      out.println("<div>");
      out.println("<button>변경</button>");
      out.println("<button type='reset'>초기화</button>");
      out.printf("<a href='/member/delete?no=%d'>삭제</a>\n",member.getNo());
      out.printf("<a href='/member/list'>목록</a>\n");
      out.println("</div>");
      out.println("</form>");
      try {
        InitServlet.sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        InitServlet.sqlSessionFactory.openSession(false).rollback();
      }
    }

    out.println("</body>");
    out.println("</html>");


  }


}










