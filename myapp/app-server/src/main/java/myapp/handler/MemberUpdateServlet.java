package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }

    request.setCharacterEncoding("UTF-8");
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setGender(request.getParameter("gender").charAt(0));
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.printf("<meta http-equiv='refresh' content='1;url=/member/list'>\n");
    out.println("<title>게시글</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 변경</h1>");


    try {
      if (InitServlet.memberDao.update(member) == 0) {
        out.println("해당 게시글은 변경 불가능 합니다.");
        InitServlet.sqlSessionFactory.openSession(false).rollback();

      } else {
        out.println("변경했습니다!");
        InitServlet.sqlSessionFactory.openSession(false).commit();
      }
      return;
    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("회원정보 변경 실패입니다!");
      e.printStackTrace();
    }
    out.println("</body>");
    out.println("</html>");

  }
}










