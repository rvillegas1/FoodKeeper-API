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
    		CookingMethod cookingMethod = CookingMethod.getFromJsonArray(cookingMethodArr);
    		list.add(cookingMethod);
    	}
    	return list;
    }
    
    static List<CookingTip> getCookingTips(JsonObject obj) {
    	List<CookingTip> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray cookingTipsArr = element.getAsJsonArray();
    		CookingTip cookingTip = CookingTip.getFromJsonArray(cookingTipsArr);
    		list.add(cookingTip);
    	}
    	return list;
    }
    
    static List<Product> getProducts(JsonObject obj) {
    	List<Product> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray productArr = element.getAsJsonArray();		
    		Product product = Product.getFromJsonArray(productArr);
    		list.add(product);
    	}
    	return list;
    }
    
    static List<Category> getCategories(JsonObject obj) {
    	List<Category> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray categoryArr = element.getAsJsonArray();
    		Category category = Category.getFromJsonArray(categoryArr);
    		list.add(category);
    	}
    	return list;
    }
    
    static <T> void printList(List<T> list) {
    	for (T obj : list) {
    		System.out.println(obj);
    	}
    }
}
