package hackduke.foodprint;

/**
 * Created by pciporin on 11/20/16.
 */

import java.util.HashMap;

public class MenuItem {
    public Food myMainFood;
    public Double myMainFoodAmt; //in kg's from a map
    public String myItem;
    public Food beef = new Food("beef",27.0);
    public Food chicken = new Food("chicken",6.9);
    public Food veg = new Food("veg",2.0);
    public Food lamb = new Food("lamb",39.2);
    public Food tofu = new Food("tofu",2.0);
    public Food rice  = new Food("rice",2.7);
    public HashMap<String,Double> amts = new HashMap<>();
    public HashMap<String,Food> foodType= new HashMap<>();



    public MenuItem(String item){
        amts.put("Cheeseburger",0.51);
        amts.put("Hamburger",0.5);
        amts.put("Chicken Nuggets",0.25);
        amts.put("Salad",0.1);
        amts.put("Chicken Curry",0.5);
        amts.put("Curry Lamb",0.5);
        amts.put("Curry Tofu",0.5);
        amts.put("Rice",0.2);
        amts.put("Veggies",0.5);
        amts.put("Chicken Breast",0.75);
        amts.put("Roast Beef",0.75);
        foodType.put("Cheeseburger",beef);
        foodType.put("Hamburger",beef);
        foodType.put("Chicken Nuggets",chicken);
        foodType.put("Veggies",veg);
        foodType.put("Salad",veg);
        foodType.put("Chicken Curry",chicken);
        foodType.put("Curry Lamb",lamb);
        foodType.put("Curry Tofu",tofu);
        foodType.put("Rice",rice);
        foodType.put("Chicken Breast",chicken);
        foodType.put("Roast Beef",beef);
        myItem = item;
        myMainFoodAmt = getMainFoodAmt(item);
        myMainFood = getMainFood(item);

    }
    public double getMainFoodAmt(String item){
        double mAmt = amts.get(item);
        return mAmt;
    }
    public Food getMainFood(String item){
        Food mFood = foodType.get(item);
        return mFood;
    }

    public double outCO2(){
        //  Food f = myMainFood;
        double CO2 = myMainFood.getco2kg();
        double amt = myMainFoodAmt;
        return CO2*amt;
    }
}
