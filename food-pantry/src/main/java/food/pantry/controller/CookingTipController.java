package food.pantry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import food.pantry.model.CookingTip;
import food.pantry.repository.CookingTipRepository;

@RestController
@RequestMapping("/cookingTip")
public class CookingTipController {
	@Autowired
	private CookingTipRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<CookingTip> getAllCookingTips() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CookingTip getCookingTipById(@PathVariable("id") Integer id) {
		return repository.findByid(id);
	}
}
