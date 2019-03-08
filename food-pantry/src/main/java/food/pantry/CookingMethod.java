package food.pantry;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CookingMethod {
	private Integer id;
	private Integer productID;
	private String method;
	private Double measureFrom;
	private Double measureTo;
	private String sizeMetric;
	private String cookingTemp;
	private Double timingFrom;
	private Double timingTo;
	private String timingMetric;
	private String timingPer;
	
	public CookingMethod() {}
	
	public CookingMethod(Integer id, Integer productID, String method, Double measureFrom, Double measureTo,
			String sizeMetric, String cookingTemp, Double timingFrom, Double timingTo, String timingMetric,
			String timingPer) {
		this.id = id;
		this.productID = productID;
		this.method = method;
		this.measureFrom = measureFrom;
		this.measureTo = measureTo;
		this.sizeMetric = sizeMetric;
		this.cookingTemp = cookingTemp;
		this.timingFrom = timingFrom;
		this.timingTo = timingTo;
		this.timingMetric = timingMetric;
		this.timingPer = timingPer;
	}

	public Integer getId() {
		return id;
	}

	public Integer getProductID() {
		return productID;
	}

	public String getMethod() {
		return method;
	}

	public Double getMeasureFrom() {
		return measureFrom;
	}

	public Double getMeasureTo() {
		return measureTo;
	}

	public String getSizeMetric() {
		return sizeMetric;
	}

	public String getCookingTemp() {
		return cookingTemp;
	}

	public Double getTimingFrom() {
		return timingFrom;
	}

	public Double getTimingTo() {
		return timingTo;
	}

	public String getTimingMetric() {
		return timingMetric;
	}

	public String getTimingPer() {
		return timingPer;
	}

	@Override
	public String toString() {
		return "CookingMethod [id=" + id + ", productID=" + productID + ", method=" + method + ", measureFrom="
				+ measureFrom + ", measureTo=" + measureTo + ", sizeMetric=" + sizeMetric + ", cookingTemp="
				+ cookingTemp + ", timingFrom=" + timingFrom + ", timingTo=" + timingTo + ", timingMetric="
				+ timingMetric + ", timingPer=" + timingPer + "]";
	}
	
	public static CookingMethod getFromJsonArray(JsonArray jsonArr) {
		Map<String, JsonElement> map = JsonConverter.getMapFromJsonArray(jsonArr);
		CookingMethod newCookingMethod = new CookingMethod();
		
		newCookingMethod.id = JsonConverter.getJsonElementAsInt(map.get("ID"));
		newCookingMethod.productID = JsonConverter.getJsonElementAsInt(map.get("Product_ID"));
		newCookingMethod.method = JsonConverter.getJsonElementAsString(map.get("Cooking_Method"));
		newCookingMethod.measureFrom = JsonConverter.getJsonElementAsDouble(map.get("Measure_from"));
		newCookingMethod.measureTo = JsonConverter.getJsonElementAsDouble(map.get("Measure_to"));
		newCookingMethod.sizeMetric = JsonConverter.getJsonElementAsString(map.get("Size_metric"));
		newCookingMethod.cookingTemp = JsonConverter.getJsonElementAsString(map.get("Cooking_Temperature"));
		newCookingMethod.timingFrom = JsonConverter.getJsonElementAsDouble(map.get("Timing_from"));
		newCookingMethod.timingTo = JsonConverter.getJsonElementAsDouble(map.get("Timing_to"));
		newCookingMethod.timingMetric = JsonConverter.getJsonElementAsString(map.get("Timing_metric"));
		newCookingMethod.timingPer = JsonConverter.getJsonElementAsString(map.get("Timing_per"));
		
		return newCookingMethod;
	}
}
