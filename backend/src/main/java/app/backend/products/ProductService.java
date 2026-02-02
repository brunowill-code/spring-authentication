package app.backend.products;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.backend.exceptions.ProductNotFound;
import app.backend.products.dto.ProductDTO;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getall() {
		List<ProductDTO> produtos = productRepository.findAll()
	            .stream()
	            .map(ProductDTO::fromModel)
	            .toList(); // Java 16+

	    System.out.println(produtos);

	    return produtos;
	}

	public ProductDTO getById(Integer id) {
		return productRepository.findById(id)
	            .map(ProductDTO::fromModel)
	            .orElseThrow(ProductNotFound::new);
		
	}

	public ProductDTO addProduct(ProductDTO obj) {
		ProductModel p = productRepository.save(obj.toModel());
		return ProductDTO.fromModel(p);
	}
}
