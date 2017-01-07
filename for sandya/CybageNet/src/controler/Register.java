package controler;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import pojos.Employee;
import utilities.JdbcConnection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		//Register DAO
		RegisterDao rdao=new RegisterDao();
         
		//getting parameters from Register.jsp page
		String empId=request.getParameter("empid");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String dept=request.getParameter("department");
		
		//creating object of Employee
		Employee employee = new Employee(empId, name, password, dept, "U");
		int row = 0;

		try 
		{
			row=rdao.register(employee);//Inserting employee object into database

		}
		catch (SQLException e ) {//if EmpId/UserName is repeated then send to register page
			request.setAttribute("registerMsg", "Employee id : "+empId +" already registered...please try again");
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
			e.printStackTrace();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(row!=0)//if successfully registered 
		{
			request.setAttribute("registerMsg", "You Are successfully registered with employee Id : "+empId+"...Now Login");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else//if registration failed
		{
			request.setAttribute("registerMsg", "Unable to register, please try again...");
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}

	}		


}

