package food.pantry.model;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import org.springframework.data.annotation.Id;

import food.pantry.JsonConverter;

public class Category {
	@Id private Integer id;
	
	private String name;
	private String subcategory;
	
	public Category() {}
	
	public Category(Integer id, String name, String subcategory) {
		this.id = id;
		this.name = name;
		this.subcategory = subcategory;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", subcategory=" + subcategory + "]";
	}
	
	public static Category getFromJsonArray(JsonArray jsonArr) {
		Map<String, JsonElement> map = JsonConverter.getMapFromJsonArray(jsonArr);
		Category newCategory = new Category();

		newCategory.id = JsonConverter.getJsonElementAsInt(map.get("ID"));
		newCategory.name = JsonConverter.getJsonElementAsString(map.get("Category_Name"));
		newCategory.subcategory = JsonConverter.getJsonElementAsString(map.get("Subcategory_Name"));
		
		return newCategory;
	}
}
