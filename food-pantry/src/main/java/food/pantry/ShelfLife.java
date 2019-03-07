package food.pantry;

import com.google.gson.JsonArray;

public class ShelfLife {	
	private Integer min;
	private Integer max;
	private String metric;
	
	public ShelfLife(Integer min, Integer max, String metric) {
		this.min = min;
		this.max = max;
		this.metric = metric;
	}
	
	public Integer getMin() {
		return min;
	}
	
	public Integer getMax() {
		return max;
	}
	
	public String getMetric() {
		return metric;
	}

	@Override
	public String toString() {
		return "ShelfLife [min=" + min + ", max=" + max + ", metric=" + metric;
	}
	
    static ShelfLife getFromJsonArr(JsonArray arr, int[] index, String data) {
    	try {
       		ShelfLife shelfLife = new ShelfLife(
        			JsonConverter.getJsonElementAsInt(arr, index, data + "_Min"),
        			JsonConverter.getJsonElementAsInt(arr, index, data + "_Max"),
        			JsonConverter.getJsonElementAsString(arr, index, data + "_Metric"));
       		return shelfLife;
    	} catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
}
