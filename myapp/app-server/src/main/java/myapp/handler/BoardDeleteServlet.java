package myapp.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.vo.Board;
import myapp.vo.Member;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

  private static final long serialVersionUID= 1L;



  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }

    int category = Integer.parseInt(request.getParameter("category"));
    Board b = new Board();
    b.setNo(Integer.parseInt(request.getParameter("no")));
    b.setWriter((Member) request.getSession().getAttribute("loginUser"));
    b.setCategory(category);

    try {
      if (InitServlet.boardDao.delete(b) == 0) {
        InitServlet.sqlSessionFactory.openSession(false).rollback();
        throw new Exception("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
      } else {
        response.sendRedirect("/board/list?category="+ category);
      }
      InitServlet.sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException();
    }


  }




}









