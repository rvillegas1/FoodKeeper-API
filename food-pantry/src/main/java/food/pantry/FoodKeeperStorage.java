package food.pantry;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import food.pantry.model.Category;
import food.pantry.model.CookingMethod;
import food.pantry.model.CookingTip;
import food.pantry.model.Product;

public class FoodKeeperStorage {
	public static void storeFoodKeeperData() {
		Gson gson = new Gson();
        
        try (Reader reader = new FileReader("foodkeeper.json")) {
        	JsonObject body = gson.fromJson(reader, JsonObject.class);
        	JsonArray sheets = body.get("sheets").getAsJsonArray();
        	
        	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
            MongoDatabase database = mongoClient.getDatabase("foodkeeper");
        	
        	JsonObject categoriesObj = sheets.get(1).getAsJsonObject();
        	List<Category> categories = getCategories(categoriesObj);
        	MongoCollection<Category> categoryCollection = database.getCollection("category", Category.class);
            categoryCollection.insertMany(categories);
        	
        	JsonObject productsObj = sheets.get(2).getAsJsonObject();
        	List<Product> products = getProducts(productsObj);
        	MongoCollection<Product> productCollection = database.getCollection("product", Product.class);
            productCollection.insertMany(products);
        	
        	JsonObject cookingTipsObj = sheets.get(3).getAsJsonObject();
        	List<CookingTip> cookingTips = getCookingTips(cookingTipsObj);
        	MongoCollection<CookingTip> cookingTipCollection = database.getCollection("cookingTip", CookingTip.class);
            cookingTipCollection.insertMany(cookingTips);
        	
        	JsonObject cookingMethodsObj = sheets.get(4).getAsJsonObject();
        	List<CookingMethod> cookingMethods = getCookingMethods(cookingMethodsObj);
        	MongoCollection<CookingMethod> cookingMethodCollection = database.getCollection("cookingMethod", CookingMethod.class);
            cookingMethodCollection.insertMany(cookingMethods);
            
            mongoClient.close();
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
}
