package food.pantry;

public class Category {
	private Integer id;
	private String name;
	private String subcategory;
	
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
}
