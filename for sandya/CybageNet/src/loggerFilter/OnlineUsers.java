package loggerFilter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineUsers
 *
 */
@WebListener
public class OnlineUsers implements HttpSessionListener {
	static int count=0;
	 private List sessions = new ArrayList();
    /**
     * Default constructor. 
     */
    public OnlineUsers() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
      public void sessionCreated(HttpSessionEvent event)  {
    	  count ++;
    	HttpSession session = event.getSession();
    	System.out.println(session.getId());
    	
        sessions.add(session.getId());
        session.setAttribute("counter", this);
        System.out.println("Created..... "+sessions.size()+"......."+count);
    }

    public void sessionDestroyed(HttpSessionEvent event)  {
    	count--;
    	HttpSession session = event.getSession();
    	System.out.println(session.getId());
        sessions.remove(session.getId());
        session.setAttribute("counter", this);
        System.out.println("Destroyed ..... "+sessions.size()+"......."+count);
    }
    public int getActiveSessionNumber()
    {
        return sessions.size();
    }
    
    public static int getCount() {
		return count;
	}
}
