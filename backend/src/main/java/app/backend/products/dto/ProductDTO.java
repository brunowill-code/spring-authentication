package app.backend.products.dto;

import java.util.Date;
import java.util.Locale.Category;

import app.backend.products.ProductCategory;
import app.backend.products.ProductModel;

public class ProductDTO {

	private String nome;
	private String descricao;
	private Double preco;
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
