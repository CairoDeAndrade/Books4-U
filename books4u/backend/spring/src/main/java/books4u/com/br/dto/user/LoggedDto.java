package books4u.com.br.dto.user;

import java.io.Serializable;

public class LoggedDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean logged;
	
	public LoggedDto() {
	}

	public LoggedDto(boolean logged) {
		super();
		this.logged = logged;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
