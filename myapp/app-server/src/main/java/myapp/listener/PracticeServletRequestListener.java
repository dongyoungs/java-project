package myapp.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import myapp.handler.InitServlet;
import myapp.util.SqlSessionFactoryProxy;
@WebListener // 서블릿 컨테이너에게 이 클래스가 리스너임을 알린다.
public class PracticeServletRequestListener implements ServletRequestListener {

  public PracticeServletRequestListener() {
    System.out.println("리스너 객체 생성");
  }
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    ((SqlSessionFactoryProxy) InitServlet.sqlSessionFactory).clean();
  }

}

