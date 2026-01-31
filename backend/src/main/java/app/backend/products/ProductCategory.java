package app.backend.products;

public enum ProductCategory {
	ROUPA("Roupa"),
	ELETRONICO("Eletonico"),
	ESCRITORIO("Escritorio"),
	MOVEIS("Moveis");
	
	private final String value;
	
	ProductCategory(String valor){
		this.value = valor;
	}
	
	public String getValue() {
		return this.value;
	}
}
