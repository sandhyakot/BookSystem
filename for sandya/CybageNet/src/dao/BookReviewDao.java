package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojos.BookReview;
import pojos.Employee;
import utilities.JdbcConnection;

public class BookReviewDao {
	private Connection conn;//creating reference for connection
	private PreparedStatement pst1 ;//reference for prepared statement
	ResultSet resultSet;//reference for result set
	Employee emp = null;
	BookReview review=null;

	public BookReviewDao() 
	{

	}

	//closing connection with database
	public void cleanUp() throws Exception {
	

		if (pst1 != null)
			pst1.close();
		if (resultSet != null)
			resultSet.close();
		conn.close();

	}

	
	//storing book review into database
	public int addBookReviews(BookReview review) {
			conn=JdbcConnection.getConn();//creating connection with db
		int row = 0;
		try {
			pst1 = conn.prepareStatement("Insert into book_reviews(`empid`,`review`,`bookid`) values(?,?,?)");
			pst1.setString(1, review.getEmpId());
			pst1.setString(2, review.getReview());
			pst1.setInt(3, review.getBookId());
			row = pst1.executeUpdate();

		} 
		catch (Exception e) //handling error
		{
			e.printStackTrace();
		}

		try {
			cleanUp();
		} catch (Exception e) {//handling error

			e.printStackTrace();
		}
		return row;
		 

	}
	
	//Retrieving reviews of books from db
	public ArrayList<String> getBookReviews(int bookId) {
		ArrayList<String> list1 = null;
		conn=JdbcConnection.getConn();//creating connection with db

		try {
			pst1 = conn.prepareStatement("SELECT r.review ,e.name FROM book_reviews r,cybageemployee e where bookid =? and r.empid=e.empid;");

			pst1.setInt(1, bookId);
			resultSet=pst1.executeQuery();

			if (resultSet.next()) 
			{
				resultSet.previous();
				list1 = new ArrayList<String>();
				while (resultSet.next()) 
				{
					list1.add(resultSet.getString(2)+" : "+ resultSet.getString(1));
				}

			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}



		try {
			cleanUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list1; 

	}
}
