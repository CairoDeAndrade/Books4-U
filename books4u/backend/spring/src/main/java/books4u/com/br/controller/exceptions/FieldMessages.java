package books4u.com.br.controller.exceptions;

import java.io.Serializable;

public class FieldMessages implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String message;
	
	public FieldMessages() {
	}

	public FieldMessages(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
