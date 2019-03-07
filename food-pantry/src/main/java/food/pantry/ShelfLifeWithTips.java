package food.pantry;

import com.google.gson.JsonArray;

public class ShelfLifeWithTips extends ShelfLife {
	private String tips;
	
	public ShelfLifeWithTips(Integer min, Integer max, String metric, String tips) {
		super(min, max, metric);
		this.tips = tips;
	}
	
	public String getTips() {
		return tips;
	}

	@Override
	public String toString() {
		return "ShelfLifeWithTips [min=" + getMin() + ", max=" + getMax() + ", metric=" + getMetric() + ", metrictips=" + tips + "]";
	}
	
	static ShelfLife getFromJsonArr(JsonArray arr, int[] index, String data) {
    	try {
       		ShelfLife shelfLife = new ShelfLifeWithTips(
       				JsonConverter.getJsonElementAsInt(arr, index, data + "_Min"),
       				JsonConverter.getJsonElementAsInt(arr, index, data + "_Max"),
       				JsonConverter.getJsonElementAsString(arr, index, data + "_Metric"),
       				JsonConverter.getJsonElementAsString(arr, index, data + "_tips"));
       		return shelfLife;
    	} catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
}
