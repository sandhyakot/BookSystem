package customTags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LogOutHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		PageContext ctx=(PageContext)getJspContext();
		ctx.getSession().invalidate();
		HttpServletResponse resp=(HttpServletResponse)ctx.getResponse();
		resp.sendRedirect("login.jsp");
	}
	

}
