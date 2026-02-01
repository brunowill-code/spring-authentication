package app.backend.products;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="product")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@Column(name="nome", nullable = false)
	private String nome;

	@Column(name="descricao")
	private String descricao;

	@Column(name="preco", nullable = false)
	private Double preco;

	@Column(name="inserido_em", nullable = false)
	private Date inserido_em;
	
	@Column(name="id_usuario", nullable = false)
	private Integer id_usuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="categoria", nullable = false)
	private ProductCategory categoria;
	
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

	public Date getInserido_em() {
		return inserido_em;
	}

	public void setInserido_em(Date inserido_em) {
		this.inserido_em = inserido_em;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public ProductCategory getCategoria() {
		return categoria;
	}

	public void setCategoria(ProductCategory categoria) {
		this.categoria = categoria;
	}

	public ProductModel(Integer id, String nome, String descricao, Double preco, Date inserido_em, Integer id_usuario,
			ProductCategory categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.inserido_em = inserido_em;
		this.id_usuario = id_usuario;
		this.categoria = categoria;
	}

	public ProductModel() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
