package pojos;

public class BookReview {
 
	int reviewId,bookId;
	String empId;
	String review;
	
	public BookReview(String review) {
		this.review = review;
	}
	
	public BookReview(int reviewId, String empId, int bookId, String review) {
		super();
		this.reviewId = reviewId;
		this.empId = empId;
		this.bookId = bookId;
		this.review = review;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "BookReview [reviewId=" + reviewId + ", empId=" + empId + ", bookId=" + bookId + ", review=" + review
				+ "]";
	}
	
	
	
}
