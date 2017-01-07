package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.Employee;
import utilities.AESencrp;
import utilities.JdbcConnection;

public class RegisterDao {
	private Connection conn;//creating reference for connection
	private PreparedStatement pst1 ;//reference for prepared statement
	ResultSet rst;//reference for resultset
	Employee emp = null;
	
	//constructor to initialized connection with database
	public RegisterDao() 
	{
			conn=JdbcConnection.getConn();
	}
	
	//to release the connection
	public void cleanUp() throws Exception {
		//if prepared statement not null closing prepared statement
		if (pst1 != null)
			pst1.close();
		
		conn.close();//connection close
		
	}
	
	
	//inserting employee details into database
	public int register(Employee employee) throws Exception {
		
			pst1 = conn.prepareStatement("Insert into cybageemployee values(?,?,?,?,?)");
			pst1.setString(1, employee.getEmpId());
			pst1.setString(2, AESencrp.encrypt(employee.getPassword()));
			pst1.setString(3, employee.getEmpName());
			pst1.setString(4, employee.getDepartment());
			pst1.setString(5, employee.getRole());
			int row = pst1.executeUpdate();//executing preapared statement

		
	try {
		cleanUp();
	} catch (Exception e) {//handling error
		
		e.printStackTrace();
	}
		
		return row; 
		
	}
}
