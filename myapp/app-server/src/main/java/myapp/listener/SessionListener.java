package myapp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class SessionListener implements HttpSessionBindingListener{
  @Override
  public void valueBound(HttpSessionBindingEvent event) {
    // Get my custom application-scoped attribute
    System.out.println("Session 리스너 valueBound" + this);
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    //HttpSession session = event.getSession();
    System.out.println("Session 리스너 valueUnBound" + this);
  }
}
