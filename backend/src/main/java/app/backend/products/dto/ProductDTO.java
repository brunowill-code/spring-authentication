package app.backend.products.dto;

import java.util.Date;
import java.util.Locale.Category;

import app.backend.products.ProductCategory;
import app.backend.products.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 100, message ="Nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotBlank(message = "Descrição é obrigatório")
	@Size(max = 255, message ="Descrição deve ter no máximo 255 caracteres")
	private String descricao;
	
	@NotNull(message = "Preço é obrigatório")
	@Positive(message = "Preço deve ser positivo")
	private Double preco;
	
	@NotNull(message = "Categoria é obrigatório")
	private ProductCategory categoria;
	
	public ProductModel toModel() {
		ProductModel p = new ProductModel();
		p.setNome(this.getNome());
		p.setDescricao(this.getDescricao());
		p.setPreco(this.getPreco());
		p.setCategoria(this.getCategoria());
		p.setInserido_em(new Date());
		p.setId_usuario(1);
		return p;
	}
	
	public static ProductDTO fromModel(ProductModel p) {
		ProductDTO pDTO = new ProductDTO(p.getNome(), p.getDescricao(), p.getPreco(), p.getCategoria());
		return pDTO;
	}
	
	public ProductDTO() {
	}
	
	public ProductDTO(String nome, String descricao, Double preco, ProductCategory categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ProductCategory getCategoria() {
		return categoria;
	}

	public void setCategoria(ProductCategory categoria) {
		this.categoria = categoria;
	}
	
	
}
