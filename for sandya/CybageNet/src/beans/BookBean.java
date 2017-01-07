package beans;

import java.util.ArrayList;
import dao.BookDao;
import dao.BookReviewDao;
import pojos.Book;

public class BookBean {

	private int bookId;
	private String bookName;
	private double price;
	private String author;
	private String category;
	private BookDao bookDao;//book DAO
	private BookReviewDao bookReviewDao;//book review DAO
	
	public BookBean() {
		bookDao=new BookDao();
		bookReviewDao=new BookReviewDao();
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	} 
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {

		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}	

	public String getCategory() {
		return category;
	}

	public ArrayList<String> getCategories() {
		return bookDao.getBookCategory();
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	//inserting book into database
	public void insertBook()
	{
		Book book = new Book(bookId, bookName, price, author, category);
		System.out.println(book);
		if(bookDao.insertBook(book))//
		{
			System.out.println("Inserted suceesfully");
		}		
	}	
	
	
	//removing book from database
	public void removeBook()
	{
		if(bookDao.removeBook(bookId))
		{
			System.out.println("Removed successfully");
		}
	}
	
	
	//view all books 
	public ArrayList<Book> showBooks(){

		return bookDao.showBooks();
	}
	

	//view book reviews
	public ArrayList<Book> getBookDetails() throws Exception {

		return bookDao.getBookDetails(bookName);
	}
	public ArrayList<String> getBookReviews()
	{
		return bookReviewDao.getBookReviews(bookId);
	}
}
