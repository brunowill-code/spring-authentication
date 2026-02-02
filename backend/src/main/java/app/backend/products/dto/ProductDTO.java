package app.backend.products.dto;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import app.backend.products.ProductCategory;
import app.backend.products.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	@JsonIgnore
	private Optional<Integer> id;
	
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
	
	@JsonIgnore
	private Optional<Date> inseridoEm;
	
	@JsonIgnore
	private Optional<Integer> idUsuario;

	
	public ProductModel toModel() {
		
		ProductModel p = new ProductModel();
	
		if(this.id != null && this.id.isPresent()) {
			p.setId(this.id.get());
		}
		
		if(this.idUsuario != null && this.idUsuario.isPresent()) {
			p.setId_usuario(this.idUsuario.get());
		}
		
		boolean hasInseridoEm = this.inseridoEm  != null && this.inseridoEm.isPresent();
		
		p.setNome(this.getNome());
		p.setDescricao(this.getDescricao());
		p.setPreco(this.getPreco());
		p.setCategoria(this.getCategoria());
		p.setInserido_em(hasInseridoEm ? this.inseridoEm.get() : new Date());
		p.setId_usuario(1);
		return p;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", categoria=" + categoria + ", inseridoEm=" + inseridoEm + ", idUsuario=" + idUsuario + "]";
	}

	public static ProductDTO fromModel(ProductModel p) {
		ProductDTO pDTO = new ProductDTO(
				Optional.ofNullable(p.getId()),
				p.getNome(),
				p.getDescricao(),
				p.getPreco(),
				p.getCategoria(),
				Optional.ofNullable(p.getInserido_em()),
				Optional.ofNullable(p.getId_usuario()));
		return pDTO;
	}
	
	public ProductDTO() {
	}
	
	

	public ProductDTO(Optional<Integer> id,
			@NotBlank(message = "Nome é obrigatório") @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres") String nome,
			@NotBlank(message = "Descrição é obrigatório") @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres") String descricao,
			@NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser positivo") Double preco,
			@NotNull(message = "Categoria é obrigatório") ProductCategory categoria, Optional<Date> inseridoEm,
			Optional<Integer> idUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.inseridoEm = inseridoEm;
		this.idUsuario = idUsuario;
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
	
	 @JsonProperty("id")
	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public Integer getIdValue() {
	        return id != null ? id.orElse(null) : null;
	    }

	    @JsonProperty("inseridoEm")
	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public Date getInseridoEmValue() {
	        return inseridoEm != null ? inseridoEm.orElse(null) : null;
	    }

	    @JsonProperty("idUsuario")
	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public Integer getIdUsuarioValue() {
	        return idUsuario != null ? idUsuario.orElse(null) : null;
	    }
	
	
}
