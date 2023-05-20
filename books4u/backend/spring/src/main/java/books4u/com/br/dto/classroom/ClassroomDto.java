package books4u.com.br.dto.classroom;

import java.io.Serializable;

import books4u.com.br.entities.Classroom;

public class ClassroomDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer classroomYear;
	private Character classroomShift;
	private Boolean classroomStatus;
	
	public ClassroomDto() {
	}

	public ClassroomDto(Integer classroomYear, Character classroomShift, Boolean classroomStatus) {
		super();
		this.classroomYear = classroomYear;
		this.classroomShift = classroomShift;
		this.classroomStatus = classroomStatus;
	}
	
	public ClassroomDto(Classroom entity) {
		classroomYear = entity.getClassroomYear();
		classroomShift = entity.getClassroomShift();
		classroomStatus = entity.getClassroomStatus();
	}

	public Integer getClassroomYear() {
		return classroomYear;
	}

	public void setClassroomYear(Integer classroomYear) {
		this.classroomYear = classroomYear;
	}

	public Character getClassroomShift() {
		return classroomShift;
	}

	public void setClassroomShift(Character classroomShift) {
		this.classroomShift = classroomShift;
	}

	public Boolean getClassroomStatus() {
		return classroomStatus;
	}

	public void setClassroomStatus(Boolean classroomStatus) {
		this.classroomStatus = classroomStatus;
	}
}
