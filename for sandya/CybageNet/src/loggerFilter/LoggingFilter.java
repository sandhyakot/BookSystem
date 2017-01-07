package loggerFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter
{
	private FilterConfig filterConfigObj = null;

	@Override
	public void destroy()
	{
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException
	{
		  String remoteAddress =  request.getRemoteAddr();
		  String uri = ((HttpServletRequest) request).getRequestURI();
		  String protocol = request.getProtocol();
		  System.out.println("filter called..");
		  chain.doFilter(request, response);
		  filterConfigObj.getServletContext().log("Logging Filter Servlet called");
		  filterConfigObj.getServletContext().log("**************************");
		  filterConfigObj.getServletContext().log("User Logged ! " +" User IP:  " + remoteAddress + " Resource File: " + uri + " Protocol: " + protocol);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.filterConfigObj=filterConfig;
	}	
}
