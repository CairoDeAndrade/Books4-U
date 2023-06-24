package books4u.com.br.services.exceptions;

public class LoanException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LoanException(String msg) {
		super(msg);
	}
}
