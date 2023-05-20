package books4u.com.br.dto;

import java.io.Serializable;

public class ExistsIsbnDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean exists;
	
	public ExistsIsbnDto() {
	}

	public ExistsIsbnDto(boolean exists) {
		super();
		this.exists = exists;
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
}
