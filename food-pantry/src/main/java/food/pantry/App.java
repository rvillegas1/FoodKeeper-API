package food.pantry;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.*;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        
        try (Reader reader = new FileReader("foodkeeper.json")) {
        	JsonObject body = gson.fromJson(reader, JsonObject.class);
        	JsonArray sheets = body.get("sheets").getAsJsonArray();
        	
        	JsonObject categoriesObj = sheets.get(1).getAsJsonObject();
        	List<Category> categories = getCategories(categoriesObj);
        	printList(categories);
        	
        	JsonObject productsObj = sheets.get(2).getAsJsonObject();
        	List<Product> products = getProducts(productsObj);
        	printList(products);
        	
        	JsonObject cookingTipsObj = sheets.get(3).getAsJsonObject();
        	List<CookingTip> cookingTips = getCookingTips(cookingTipsObj);
        	printList(cookingTips);
        	
        	JsonObject cookingMethodsObj = sheets.get(4).getAsJsonObject();
        	List<CookingMethod> cookingMethods = getCookingMethods(cookingMethodsObj);
        	printList(cookingMethods);
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    static List<CookingMethod> getCookingMethods(JsonObject obj) {
    	List<CookingMethod> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		
    		JsonArray cookingMethodArr = element.getAsJsonArray();
    		
    		int[] index = {0};
    		Integer id = JsonConverter.getJsonElementAsInt(cookingMethodArr, index, "ID");
    		Integer productId = JsonConverter.getJsonElementAsInt(cookingMethodArr, index, "Product_ID");
    		String cookingMethod = JsonConverter.getJsonElementAsString(cookingMethodArr, index, "Cooking_Method");
    		Double measureFrom = JsonConverter.getJsonElementAsDouble(cookingMethodArr, index, "Measure_from");
    		Double measureTo = JsonConverter.getJsonElementAsDouble(cookingMethodArr, index, "Measure_to");
    		String sizeMetric = JsonConverter.getJsonElementAsString(cookingMethodArr, index, "Size_metric");
    		String cookingTemp = JsonConverter.getJsonElementAsString(cookingMethodArr, index, "Cooking_Temperature");
    		Double timingFrom = JsonConverter.getJsonElementAsDouble(cookingMethodArr, index, "Timing_from");
    		Double timingTo = JsonConverter.getJsonElementAsDouble(cookingMethodArr, index, "Timing_to");
    		String timingMetric = JsonConverter.getJsonElementAsString(cookingMethodArr, index, "Timing_metric");
    		String timingPer = JsonConverter.getJsonElementAsString(cookingMethodArr, index, "Timing_per");
    		
    		list.add(new CookingMethod(id, productId, cookingMethod,
    								   measureFrom, measureTo, sizeMetric, cookingTemp,
    								   timingFrom, timingTo, timingMetric, timingPer));
    	}
    	return list;
    }
    
    static List<CookingTip> getCookingTips(JsonObject obj) {
    	List<CookingTip> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		
    		JsonArray cookingTipsArr = element.getAsJsonArray();
    		
    		int[] index = {0};
    		Integer id = JsonConverter.getJsonElementAsInt(cookingTipsArr, index, "ID");
    		Integer productId = JsonConverter.getJsonElementAsInt(cookingTipsArr, index, "Product_ID");
    		String tips = JsonConverter.getJsonElementAsString(cookingTipsArr, index, "Tips");
    		Integer safeMinTemp = JsonConverter.getJsonElementAsInt(cookingTipsArr, index, "Safe_Minimum_Temperature");
    		Integer restTime = JsonConverter.getJsonElementAsInt(cookingTipsArr, index, "Rest_Time");
    		String restTimeMetric = JsonConverter.getJsonElementAsString(cookingTipsArr, index, "Rest_Time_Metric");
    		
    		list.add(new CookingTip(id, productId, tips, safeMinTemp, restTime, restTimeMetric));
    	}
    	return list;
    }
    
    static List<Product> getProducts(JsonObject obj) {
    	List<Product> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray productArr = element.getAsJsonArray();
    		
    		// Using int array to pass by reference, assumes variables are in correct order and are all present
    		int[] index = {0};
    		Integer id = JsonConverter.getJsonElementAsInt(productArr, index, "ID");
    		Integer categoryID = JsonConverter.getJsonElementAsInt(productArr, index, "Category_ID");
    		
    		String name = JsonConverter.getJsonElementAsString(productArr, index, "Name");
    		String subtitle = JsonConverter.getJsonElementAsString(productArr, index, "Name_subtitle");
    		String keywords = JsonConverter.getJsonElementAsString(productArr, index, "Keywords");
    		
    		ShelfLife pantryLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "Pantry");
    		ShelfLife DOP_pantryLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "DOP_Pantry");
    		ShelfLife pantryAfterOpeningLife = ShelfLife.getFromJsonArr(productArr, index, "Pantry_After_Opening");
    		ShelfLife refrigerateLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "Refrigerate");
    		ShelfLife DOP_refrigerateLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "DOP_Refrigerate");
    		ShelfLife refrigerateAfterOpeningLife = ShelfLife.getFromJsonArr(productArr, index, "Refrigerate_After_Opening");
    		ShelfLife refrigerateAfterThawingLife = ShelfLife.getFromJsonArr(productArr, index, "Refrigerate_After_Thawing");
    		ShelfLife freezerLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "Freeze");
    		ShelfLife DOP_freezerLife = ShelfLifeWithTips.getFromJsonArr(productArr, index, "DOP_Freeze");
    		
    		list.add(new Product(id, categoryID, name, subtitle, keywords, 
    				pantryLife, DOP_pantryLife, pantryAfterOpeningLife,
    				refrigerateLife, DOP_refrigerateLife,
    				refrigerateAfterOpeningLife, refrigerateAfterThawingLife,
    				freezerLife, DOP_freezerLife));
    		System.out.println(list.get(list.size() - 1));
    	}
    	return list;
    }
    
    static List<Category> getCategories(JsonObject obj) {
    	List<Category> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray categoryArr = element.getAsJsonArray();
    		
    		int[] index = {0};
    		Integer id = JsonConverter.getJsonElementAsInt(categoryArr, index, "ID");
    		String name = JsonConverter.getJsonElementAsString(categoryArr, index, "Category_Name");
    		String subcategory = JsonConverter.getJsonElementAsString(categoryArr, index, "Subcategory_Name");
    		list.add(new Category(id, name, subcategory));
    	}
    	return list;
    }
    
    static <T> void printList(List<T> list) {
    	for (T obj : list) {
    		System.out.println(obj);
    	}
    }
}
