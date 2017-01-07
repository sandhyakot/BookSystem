package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ValidatorDao;
import pojos.Employee;
import utilities.JdbcConnection;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/Validator")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Validator() {
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		//create session
		HttpSession session= request.getSession();
		//set session attribute Sessionid  
		session.setAttribute("SessionId", session.getId());

		Employee emp = null;
		ValidatorDao vDao =new ValidatorDao();
		String empId=request.getParameter("empid");
		String password=request.getParameter("password");
		//check for user name validation 
		emp = vDao.validate(empId);
		//set employee attribute into session to be used in every page
		session.setAttribute("emp", emp);

		if(emp!=null)//if object not null
		{
			if(!password.equals(emp.getPassword()))
			{

				request.setAttribute("msg", "Wrong Password Retry...");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else{
				if("A".equalsIgnoreCase(emp.getRole()))
				{
					response.sendRedirect("Admin.jsp");


				}
				else
				{
					response.sendRedirect("User.jsp");


				}
			}

		}
		else
		{
			request.setAttribute("msg", "Either Wrong Employee id /You are Not registered....");



			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}

	} 



}

