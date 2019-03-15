package food.pantry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import food.pantry.model.Category;
import food.pantry.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category getCategoryById(@PathVariable("id") Integer id) {
		return repository.findByid(id);
	}
}
