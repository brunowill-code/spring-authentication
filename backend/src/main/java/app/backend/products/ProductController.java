package app.backend.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.backend.products.dto.ProductDTO;

@RestController
@RequestMapping("produtos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAll(){
		List<ProductModel> prods = productService.getall();
		
		return ResponseEntity.ok().body(prods);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProductModel> getById(@PathVariable Integer id){
		ProductModel prod = productService.getById(id);
		return ResponseEntity.ok().body(prod);

	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO obj){
		ProductDTO pdto = productService.addProduct(obj);
		return ResponseEntity.ok().body(pdto);
		
	}
}
