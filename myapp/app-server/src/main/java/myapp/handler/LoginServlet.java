package myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myapp.vo.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{


  private static final long serialVersionUID= 1L;
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Iterator<String> iter = request.getSession().getAttributeNames().asIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }

    Member m = new Member();
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));
    Member loginUser = InitServlet.memberDao.findByEmailAndPassword(m);
    if (loginUser != null) {
      //로그인 정보를 다른요청에서도 사용할 수 있도록 세션 보관소에 담아 둔다.
      // 기존에 접속한 유저가 있을 경우, 해당유저를 로그인 해제하고 새로 접속한 유저로
      // 재등록 시킨다.

      //System.out.println(request.getSession().getAttribute(m.getEmail()));
      if (request.getCookies() != null) {
        request.getCookies()[0].getValue();
      }
      if (InitServlet.sessionMap.containsKey(m.getEmail())) {
        HttpSession session = InitServlet.sessionMap.get(m.getEmail());
        Member deletMember = (Member)session.getAttribute(m.getEmail());
        session.removeAttribute(deletMember.getSessionId());
        session.removeAttribute(m.getEmail());

      }
      loginUser.setSessionId(request.getSession().getId());
      request.getSession().setAttribute(m.getEmail(), loginUser);
      request.getSession().setAttribute(request.getSession().getId(), m.getEmail());
      response.sendRedirect("/");
      InitServlet.sessionMap.put(m.getEmail(),request.getSession());
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/auth/form.html'>");
    out.println("<title>로그인</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<p>회원 정보가 일치하지 않습니다.</p>");
    out.println("</body>");
    out.println("</html>");


  }


}










