package food.pantry;

public class CookingTip {
	private Integer id;
	private Integer productID;
	private String tips;
	private Integer safeMinTemp;
	private Integer restTime;
	private String restTimeMetric;
	
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
}
