package books4u.com.br.dto;

import books4u.com.br.entities.User;

public class UserLoginDto {
	
	private String userEmail;
	private String userPassword;
	
	public UserLoginDto() {
	}

	public UserLoginDto(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	public UserLoginDto(User entity) {
		userEmail = entity.getUserEmail();
		userPassword = entity.getUserPassword();
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
