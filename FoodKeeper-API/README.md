# Food Pantry Software
Contains code to convert (using GSON) locally stored food pantry json file to java objects representing the data found within the file.

File URL: <https://www.fsis.usda.gov/shared/data/EN/foodkeeper.json>

Class Representation of Food Keeper Data:

1. Category
	* ID: Integer
	* Category_Name: String
	* Subcategory_Name: String
2. Product
	* ID: Integer (of Product)
	* Category_ID: Integer (related to Category)
	* Name: String
	* Name_subtitle: String
	* Keywords: String
	* Pantry_Min: Integer (These can be null)
	* Pantry_Max: Integer
	* Pantry_Metric: String 
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* Pantry_tips: String
	* DOP\_Pantry_Min: Integer
	* DOP\_Pantry_Max: Integer
	* DOP\_Pantry_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* DOP\_Pantry_tips: String
	* Pantry\_After\_Opening_Min: Integer
	* Pantry\_After\_Opening_Max: Integer
	* Pantry\_After\_Opening_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* Refrigerate_Min: Integer
	* Refrigerate_Max: Integer
	* Refrigerate_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* Refrigerate_tips: String
	* DOP\_Refrigerate_Min: Integer
	* DOP\_Refrigerate_Max: Integer
	* DOP\_Refrigerate_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* DOP\_Refrigerate_tips: String
	* Refrigerate\_After\_Opening_Min: Integer
	* Refrigerate\_After\_Opening_Max: Integer
	* Refrigerate\_After\_Opening_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended, Package use-by date)
	* Refrigerate\_After\_Thawing_Min: Integer
	* Refrigerate\_After\_Thawing_Max: Integer
	* Refrigerate\_After\_Thawing_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* Freeze_Min: Integer
	* Freeze_Max: Integer
	* Freeze_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* Freeze_Tips: String
	* DOP\_Freeze_Min: Integer
	* DOP\_Freeze_Max: Integer 
	* DOP\_Freeze_Metric: String
		* (Days, Weeks, Months, When Ripe, Indefinitely, Not Recommended)
	* DOP\_Freeze_Tips: String
3. CookingTip
	* ID: Integer
	* Product_ID: Integer
	* Tips: String
	* Safe\_Minimum_temperature: Integer
	* Rest_Time: Integer
	* Rest\_Time_metric: String
4. CookingMethod
	* ID: Integer
	* Product_ID: Integer
	* Cooking_Method: String (e.g. Skillet or Oven, etc.)
	* Measure_from: Decimal
	* Measure_to: Decimal
	* Size_metric: String
		* Pounds, Ounces, Inches
	* Cooking_Temperature: String
	* Timing_from: Decimal
	* Timing_to: Decimal
	* Timing_metric: String
		* Hours, Minutes, Seconds
	* Timing_per: String
		* Pound, Ounce, Inch
