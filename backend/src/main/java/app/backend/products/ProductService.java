package app.backend.products;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductModel> getall() {
		System.out.println(productRepository.findAll());
		 return productRepository.findAll();
		
	}

	public ProductModel getById(Integer id) {
		Optional<ProductModel> prod = productRepository.findById(id);
		return prod.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", id));
		
	}
}
