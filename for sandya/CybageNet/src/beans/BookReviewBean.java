package beans;

import dao.BookReviewDao;
import pojos.BookReview;

public class BookReviewBean {
	private int reviewId,bookId;
	private String empId;
	private String review;
	private BookReviewDao bookReviewDao;
	
	public BookReviewBean() {
		bookReviewDao=new BookReviewDao();
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public int addBookReviews()
	{
		BookReview bookReview=new BookReview(reviewId, empId, bookId, review);
		System.out.println(bookReview);
		return bookReviewDao.addBookReviews(bookReview);
		
	}
}
