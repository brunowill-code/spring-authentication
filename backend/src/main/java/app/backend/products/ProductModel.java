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
	
	@Column(name="name", nullable = false)
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="price", nullable = false)
	private Double price;

	@Column(name="inserted_on", nullable = false)
	private Date inserted_on;
	
	@Column(name="id_usuario", nullable = false)
	private Integer id_usuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="category", nullable = false)
	private ProductCategory category;
	
	public ProductModel(Integer id, String name, String description, Double price, Date inserted_on, Integer id_usuario,
			ProductCategory category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.inserted_on = inserted_on;
		this.id_usuario = id_usuario;
		this.category = category;
	}

	public ProductModel() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getInserted_on() {
		return inserted_on;
	}

	public void setInserted_on(Date inserted_on) {
		this.inserted_on = inserted_on;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	
	
}
