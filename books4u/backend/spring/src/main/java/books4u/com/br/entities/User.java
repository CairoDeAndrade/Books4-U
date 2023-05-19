package books4u.com.br.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsers;
	
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	
	public User() {
	}

	public User(Long idUsers, String userEmail, String userPassword) {
		super();
		this.idUsers = idUsers;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public Long getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
