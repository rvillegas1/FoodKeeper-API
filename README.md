# FoodKeeper API
API for USDA FSIS FoodKeeper data (<https://www.fsis.usda.gov/shared/data/EN/foodkeeper.json>)

Rest API Endpoints:

| Method | Endpoint  | Body  | Return | Note |
| -----  | --------- | ----- | ------ | ---- |
| GET    | /product/*id* | | {<br>"id": *id*, "name": *"name"*, "subtitle": *"subtitle"*, "keywords": *"keywords"*, <br>"pantryLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"pantryAfterOpeningLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"refrigeratorLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"refrigrateAfterOpeningLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"refrigerateAfterThawingLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"freezerLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"dop_pantryLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"dop_refrigeratorLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*}, <br>"dop_freezerLife": {"min": *min*, "max": *max*, "metric": *"metric"*, "tips": *"tips"*} <br>} | Returns product with given id |
| GET   | /product/*id*/name | | *name* | Returns name for this product id |
| GET   | /category/*id* | | {"id": *id*, "name": *"name"*, "subcategory": *"subcategory"*} | Returns category with given id |
| GET   | /cookingMethod/*id* | | {"id": *id*, "method": *"method"*, "measureFrom": *measureFrom*, "measureTo": *measureTo*, "sizeMetric": *"sizeMetric"*, "cookingTemp", *"cookingTemp"*, "timingFrom": *timingfrom*, "timingTo": *timingTo*, "timingMetric": *"timingMetric"*, "timingPer": *"timingPer"*, "productId": *productId*} | Returns cooking method with given id |
| GET   | /cookingTip/*id* | | {"id": *id*, "tips": *"tips"*, "safeMinTemp": *safeMinTemp*, "restTime": *restTime*, "restTimeMetric": *"restTimeMetric"*} | Returns cooking tip with given id |


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
