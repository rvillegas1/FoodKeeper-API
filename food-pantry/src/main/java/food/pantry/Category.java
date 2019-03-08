package food.pantry;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Category {
	private Integer id;
	private String name;
	private String subcategory;
	
	public Category() {}
	
	public Category(Integer id, String name, String subcategory) {
		this.id = id;
		this.name = name;
		this.subcategory = subcategory;
	}

	public Integer getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSubcategory() {
		return subcategory;
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
