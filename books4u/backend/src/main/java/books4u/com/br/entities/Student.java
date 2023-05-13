package books4u.com.br.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String studentName;
	private Long studentEnrollment;
	private Long idClassroom;
	private boolean status;
	
	public Student() {
	}

	public Student(Long id, String studentName, Long studentEnrollment, Long idClassroom, boolean status) {
		this.id = id;
		this.studentName = studentName;
		this.studentEnrollment = studentEnrollment;
		this.idClassroom = idClassroom;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentEnrollment() {
		return studentEnrollment;
	}

	public void setStudentEnrollment(Long studentEnrollment) {
		this.studentEnrollment = studentEnrollment;
	}

	public Long getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(Long idClassroom) {
		this.idClassroom = idClassroom;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
