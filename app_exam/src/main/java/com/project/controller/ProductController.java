package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.ResourceNotFoundException;
import com.project.model.Product;
import com.project.model.ProductDetail;
import com.project.repository.ProductRepository;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping("/createProduct")
	public Product createProduct(@Validated @RequestBody ProductDetail productD) {
		Product product = new Product(productD.getName(), productD.getPrice());
		return productRepository.save(product);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id,
			@RequestBody ProductDetail productD) throws ResourceNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

		product.setName(productD.getName());
		product.setPrice(productD.getPrice());
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
