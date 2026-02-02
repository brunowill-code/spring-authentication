package app.backend.exceptions;

public class ErrorResponse {
	
	private String mensagem;

	public ErrorResponse(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
