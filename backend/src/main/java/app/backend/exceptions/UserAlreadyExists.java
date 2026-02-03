package app.backend.exceptions;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists() {
		super("Usuário já existe");
	}
	
}
