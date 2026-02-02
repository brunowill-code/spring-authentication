package app.backend.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.backend.products.dto.ProductDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAll(){
		List<ProductDTO> prods = productService.getall();
		return ResponseEntity.ok().body(prods);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Integer id){
		ProductDTO prod = productService.getById(id);
		return ResponseEntity.ok().body(prod);

	}
	//aplica as validações antes de criar o produto!
	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO obj){
		ProductDTO pdto = productService.addProduct(obj);
		return ResponseEntity.ok().body(pdto);	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProductDTO> uptateProduct(@Valid @RequestBody ProductDTO obj, @PathVariable Integer id){
		ProductDTO product = productService.updateProduct(obj, id);
		return ResponseEntity.ok().body(product);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Integer id){
		ProductDTO product = productService.deleteProduct(id);
		return ResponseEntity.ok().body(product);
	}
}
