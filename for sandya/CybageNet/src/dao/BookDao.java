package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Book;
import pojos.Employee;
import utilities.JdbcConnection;

public class BookDao {

	private Connection conn;
	private PreparedStatement pst1  ;
	String deleteQuery,insertQuery;
	ResultSet resultSet;
	Employee emp = null;

	//writng sql methods in constructor
	public BookDao() 
	{
		System.out.println("in  BookDao()");

		insertQuery = "insert into books(bookname,price,author,category) values (?,?,?,?)";

		deleteQuery =  "DELETE FROM books WHERE bookid=?" ;



	}

	//closing connection with database
	public void cleanUp() throws Exception {
		System.out.println("in  cleanUp()");

		if (pst1 != null)
			pst1.close();
		if (resultSet != null)
			resultSet.close();
		conn.close();

	}


	//delete book from database
	public boolean removeBook(int id)
	{
		boolean status =false ;

		try (Connection	con = JdbcConnection.getConn();
				PreparedStatement removeBookByName = con.prepareStatement(deleteQuery))	{		
			removeBookByName.setInt(1,id);
			int a =	removeBookByName.executeUpdate();
			System.out.println("Row deleted : "+a);
			status=true;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			status =false ;
		}

		return status;
	}

	//insert into book
	public boolean insertBook(Book book)
	{
		//check status after insert
		boolean status =false ;
		//Create connection with db
		try (Connection	con = JdbcConnection.getConn();
				PreparedStatement insertBookByBean = con.prepareStatement(insertQuery);){	
			//"insert into books(bookname,price,author,category) values (?,?,?,?)"
			insertBookByBean.setString(1,book.getBookName());
			insertBookByBean.setDouble(2, book.getPrice());
			insertBookByBean.setString(3, book.getAuthor());
			insertBookByBean.setString(4, book.getCategory());
			insertBookByBean.execute();
			status=true;
		}
		catch (SQLException e) 
		{
			status=false;
			e.printStackTrace();
		}
		return status;
	}

	//book view by name
	public ArrayList<Book> getBookDetails(String bookName) {
		ArrayList<Book> list1 = null;
		System.out.println("in  getBookDetails of dao..");
		conn=JdbcConnection.getConn();

		try {
			pst1 = conn.prepareStatement("select * from books where bookname=?");
			pst1.setString(1, bookName);
			resultSet=pst1.executeQuery();

			if (resultSet.next()) 
			{
				resultSet.previous();
				list1 = new ArrayList<Book>();
				while (resultSet.next()) //storing result into list
				{
					list1.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getString(5)));
				}

			}
		} 
		catch (Exception e) //handling exception
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


	//book view all
	public ArrayList<Book> showBooks() {
		ArrayList<Book> list1 = null;
		System.out.println("in  getBookDetails of dao..");
		conn=JdbcConnection.getConn();

		try {
			pst1 = conn.prepareStatement("select * from books ");


			resultSet=pst1.executeQuery();

			if (resultSet.next()) 
			{
				resultSet.previous();
				list1 = new ArrayList<Book>();
				while (resultSet.next()) 
				{
					list1.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getString(5)));
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

//get book category
	public ArrayList<String> getBookCategory() {
		ArrayList<String> list1 = null;
		System.out.println("in  getBookDetails of dao..");
		conn=JdbcConnection.getConn();

		try {
			pst1 = conn.prepareStatement("SELECT distinct category FROM mydb.books;");
			resultSet=pst1.executeQuery();

			if (resultSet.next())//storing results into Arraylist 
			{
				resultSet.previous();
				list1 = new ArrayList<>();
				while (resultSet.next()) 
				{
					list1.add( resultSet.getString(1));
				}

			}
		} 
		catch (Exception e) //Sql exception
		{
			e.printStackTrace();
		}


//closing connection
		try {
			cleanUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list1; //return list

	}


}
