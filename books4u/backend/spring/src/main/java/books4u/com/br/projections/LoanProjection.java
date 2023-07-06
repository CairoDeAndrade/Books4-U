package books4u.com.br.projections;

import javax.persistence.Column;

public interface LoanProjection {
    @Column(name = "id_loan")
	Long getIdLoan();
    
    @Column(name = "loan_start_date")
	Integer getLoanStartDate();
    
    @Column(name = "loan_end_date")
	Integer getLoanEndDate();
    
    @Column(name = "loan_price")
	Double getLoanPrice();
    
    @Column(name = "book_copy")
	Integer getBookCopy();
    
    @Column(name = "book_isbn")
	Long getBookIsbn();
    
    @Column(name = "book_name")
	String getBookName();
    
    @Column(name = "bookcase_number")
	Integer getBookcaseNumber();
    
    @Column(name = "shelf")
	Character getShelf();
    
    @Column(name = "student_fullname")
	String getStudentFullname();
    
    @Column(name = "student_enrollment")
	Long getStudentEnrollment();
    
    @Column(name = "classroom_year")
	Integer getClassroomYear();
}
