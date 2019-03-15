package food.pantry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import food.pantry.model.Product;
import food.pantry.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable("id") Integer id) {
		return repository.findByid(id);
	}
	
	@RequestMapping(value = "/{id}/name", method = RequestMethod.GET)
	public String getProductName(@PathVariable("id") Integer id) {
		return repository.findByid(id).getName();
	}
}
