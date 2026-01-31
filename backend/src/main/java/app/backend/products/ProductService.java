package app.backend.products;

import java.util.List;

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
}
