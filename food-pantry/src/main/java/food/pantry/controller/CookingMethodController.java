package food.pantry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import food.pantry.model.CookingMethod;
import food.pantry.repository.CookingMethodRepository;

@RestController
@RequestMapping("/cookingMethod")
public class CookingMethodController {
	@Autowired
	private CookingMethodRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<CookingMethod> getAllCookingMethods() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CookingMethod getCookingMethodById(@PathVariable("id") Integer id) {
		return repository.findByid(id);
	}
}
