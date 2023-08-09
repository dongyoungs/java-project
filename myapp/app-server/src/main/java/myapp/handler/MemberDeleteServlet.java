package myapp.handler;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.vo.Member;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;


  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String emailKey = (String)request.getSession().getAttribute(request.getSession().getId());
    Member loginUser = (Member) request.getSession().getAttribute(emailKey);
    if (loginUser == null) {
      response.sendRedirect("/auth/form");
      return;
    }

    try {
      if (InitServlet.memberDao.delete(Integer.parseInt(request.getParameter("no"))) == 0) {
        InitServlet.sqlSessionFactory.openSession(false).rollback();
        throw new Exception("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
      } else {
        response.sendRedirect("/member/list");
      }
      InitServlet.sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException();
    }


  }
}










