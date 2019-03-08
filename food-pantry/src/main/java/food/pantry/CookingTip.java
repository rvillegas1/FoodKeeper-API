package food.pantry;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CookingTip {
	private Integer id;
	private Integer productID;
	private String tips;
	private Integer safeMinTemp;
	private Integer restTime;
	private String restTimeMetric;
	
	public CookingTip() {}
	
	public CookingTip(Integer id, Integer productID, String tips, Integer safeMinTemp, Integer restTime,
			String restTimeMetric) {
		this.id = id;
		this.productID = productID;
		this.tips = tips;
		this.safeMinTemp = safeMinTemp;
		this.restTime = restTime;
		this.restTimeMetric = restTimeMetric;
	}

	public Integer getId() {
		return id;
	}

	public Integer getProductID() {
		return productID;
	}

	public String getTips() {
		return tips;
	}

	public Integer getSafeMinTemp() {
		return safeMinTemp;
	}

	public Integer getRestTime() {
		return restTime;
	}

	public String getRestTimeMetric() {
		return restTimeMetric;
	}
	
	@Override
	public String toString() {
		return "CookingTip [id=" + id + ", productID=" + productID + ", tips=" + tips + ", safeMinTemp=" + safeMinTemp
				+ ", restTime=" + restTime + ", restTimeMetric=" + restTimeMetric + "]";
	}
	
	public static CookingTip getFromJsonArray(JsonArray jsonArr) {
		Map<String, JsonElement> map = JsonConverter.getMapFromJsonArray(jsonArr);
		CookingTip newCookingTip = new CookingTip();
		
		newCookingTip.id = JsonConverter.getJsonElementAsInt(map.get("ID"));
		newCookingTip.productID = JsonConverter.getJsonElementAsInt(map.get("Product_ID"));
		newCookingTip.tips = JsonConverter.getJsonElementAsString(map.get("Tips"));
		newCookingTip.safeMinTemp = JsonConverter.getJsonElementAsInt(map.get("Safe_Minimum_Temperature"));
		newCookingTip.restTime = JsonConverter.getJsonElementAsInt(map.get("Rest_Time"));
		newCookingTip.restTimeMetric = JsonConverter.getJsonElementAsString(map.get("Rest_Time_metric"));
		
		return newCookingTip;
	}
}
