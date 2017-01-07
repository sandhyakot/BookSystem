package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Employee;
import utilities.AESencrp;
import utilities.JdbcConnection;

public class ValidatorDao {
	private Connection conn;//creating reference for connection
	private PreparedStatement pst1 ;//reference for prepared statement
	ResultSet rst;//reference for resultset
	Employee emp = null;

	//constructor to initialized connection with database
	public ValidatorDao() 
	{
		conn=JdbcConnection.getConn();
	}


	//to release the connection
	public void cleanUp() throws Exception {
		//if prepared statement not null closing prepared statement
		if (pst1 != null)
			pst1.close();
		if (rst != null)
			rst.close();

		conn.close();//connection close

	}

	public Employee validate(String empId) {//is employee name is unique or not
		try {
			pst1 = conn.prepareStatement("Select * from cybageemployee where empid=(?)");
			pst1.setString(1, empId);
			rst=pst1.executeQuery();

			if(rst.next())
			{
				emp = new Employee(rst.getString(1), rst.getString(3),AESencrp.decrypt(rst.getString(2)),rst.getString(4),rst.getString(5)); 

			}
		} catch (SQLException e) {//handal sqlException  
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//closing the connections
		try {
			cleanUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return emp; //return employee

	}


}
