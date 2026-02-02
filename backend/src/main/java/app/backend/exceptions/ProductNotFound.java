package app.backend.exceptions;

public class ProductNotFound extends RuntimeException {

	public ProductNotFound() {
		super("Produto não encontrado");
	}
	
}
