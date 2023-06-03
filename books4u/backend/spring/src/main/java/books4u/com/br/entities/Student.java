package books4u.com.br.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStudent;
	private String studentFullname;

	
	@Column(unique = true)
	private Long studentEnrollment;
	private Boolean studentStatus;
		
	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;
	
	@OneToMany(mappedBy = "student")
	private List<Loan> loan = new ArrayList<>();
	
	public Student() {
	}

	public Student(Long idStudent, String studentName, Long studentEnrollment, Boolean status) {
		super();
		this.idStudent = idStudent;
		this.studentFullname = studentName;
		this.studentEnrollment = studentEnrollment;
		this.studentStatus = status;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getStudentFullname() {
		return studentFullname;
	}

	public void setStudentFullname(String studentFullname) {
		this.studentFullname = studentFullname;
	}

	public Long getStudentEnrollment() {
		return studentEnrollment;
	}

	public void setStudentEnrollment(Long studentEnrollment) {
		this.studentEnrollment = studentEnrollment;
	}

	public Boolean getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(Boolean studentStatus) {
		this.studentStatus = studentStatus;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStudent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(idStudent, other.idStudent);
	}
}
