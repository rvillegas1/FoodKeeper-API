package food.pantry;

public class Product {
	private Integer id;
	private Integer categoryId;
	private String name;
	private String subtitle;
	private String keywords;
	private ShelfLife pantryLife;
	private ShelfLife DOP_pantryLife;
	private ShelfLife pantryAfterOpenLife;
	private ShelfLife refrigeratorLife;
	private ShelfLife DOP_refrigeratorLife;
	private ShelfLife refrigerateAfterOpeningLife;
	private ShelfLife refrigerateAfterThawingLife;
	private ShelfLife freezerLife;
	private ShelfLife DOP_freezerLife;
	
	public Product(Integer id, Integer categoryId, 
			String name, String subtitle, String keywords,
			ShelfLife pantryLife, ShelfLife DOP_pantryLife, ShelfLife pantryAfterOpenLife,
			ShelfLife refrigeratorLife, ShelfLife DOP_refrigeratorLife,
			ShelfLife refrigerateAfterOpeningLife, ShelfLife refrigerateAfterThawingLife,
			ShelfLife freezerLife, ShelfLife DOP_freezerLife) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subtitle = subtitle;
		this.keywords = keywords;
		this.pantryLife = pantryLife;
		this.DOP_pantryLife = DOP_pantryLife;
		this.pantryAfterOpenLife = pantryAfterOpenLife;
		this.refrigeratorLife = refrigeratorLife;
		this.DOP_refrigeratorLife = DOP_refrigeratorLife;
		this.refrigerateAfterOpeningLife = refrigerateAfterOpeningLife;
		this.refrigerateAfterThawingLife = refrigerateAfterThawingLife;
		this.freezerLife = freezerLife;
		this.DOP_freezerLife = DOP_freezerLife;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getKeywords() {
		return keywords;
	}

	public ShelfLife getPantryLife() {
		return pantryLife;
	}

	public ShelfLife getDOP_pantryLife() {
		return DOP_pantryLife;
	}

	public ShelfLife getRefrigeratorLife() {
		return refrigeratorLife;
	}

	public ShelfLife getDOP_refrigeratorLife() {
		return DOP_refrigeratorLife;
	}

	public ShelfLife getRefrigerateAfterOpeningLife() {
		return refrigerateAfterOpeningLife;
	}

	public ShelfLife getRefrigerateAfterThawingLife() {
		return refrigerateAfterThawingLife;
	}

	public ShelfLife getFreezerLife() {
		return freezerLife;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subtitle=" + subtitle
				+ ", keywords=" + keywords + ", pantryLife=" + pantryLife + ", DOP_pantryLife=" + DOP_pantryLife
				+ ", pantryAfterOpenLife=" + pantryAfterOpenLife + ", refrigeratorLife=" + refrigeratorLife
				+ ", DOP_refrigeratorLife=" + DOP_refrigeratorLife + ", refrigerateAfterOpeningLife="
				+ refrigerateAfterOpeningLife + ", refrigerateAfterThawingLife=" + refrigerateAfterThawingLife
				+ ", freezerLife=" + freezerLife + ", DOP_freezerLife=" + DOP_freezerLife + "]";
	}
}
