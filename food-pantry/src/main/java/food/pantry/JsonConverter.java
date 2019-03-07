package food.pantry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class JsonConverter {
	static Double getJsonElementAsDouble(JsonArray arr, int[] index, String name) {
    	Double num;
    	try {
    		num = arr.get(index[0]).getAsJsonObject().get(name).getAsDouble();
    		index[0]++;
    	} catch (UnsupportedOperationException | 
    			NullPointerException | 
    			NumberFormatException e) {
			num = null;
		}
    	return num;
    }
	
	static Integer getJsonElementAsInt(JsonArray arr, int[] index, String name) {
    	Integer num;
    	try {
    		num = arr.get(index[0]).getAsJsonObject().get(name).getAsInt();
    		index[0]++;
    	} catch (UnsupportedOperationException | 
    			NullPointerException | 
    			NumberFormatException e) {
			num = null;
		}
    	return num;
    }
    
    static String getJsonElementAsString(JsonArray arr, int[] index, String name) {
    	String s;
    	try {
    		s = arr.get(index[0]).getAsJsonObject().get(name).getAsString();
    		index[0]++;
    	} catch (UnsupportedOperationException | 
    			NullPointerException e) {
			s = null;
		}
    	return s;
    }
    
    static JsonElement getFromJsonArray(JsonArray arr, int index) {
    	try {
    		return arr.get(index);
    	} catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
}
