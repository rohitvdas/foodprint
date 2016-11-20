package hackduke.foodprint;

/**
 * Created by pciporin on 11/20/16.
 */


public class Food {
    String myType;
    double myco2kg;

    public Food(String name, double co2kg){
        myType = name;
        myco2kg = co2kg;
    }

    public String getType(){
        return myType;
    }
    public double getco2kg(){
        return myco2kg;
    }
}
