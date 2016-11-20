package hackduke.foodprint;

/**
 * Created by pciporin on 11/20/16.
 */

import java.util.HashMap;

public class Vendor {
    public MenuItem[] myMenu;
    public double myVop;
    public String myName;
    public HashMap<String,MenuItem[]> menus= new HashMap<>();
    public HashMap<String,Double> vop = new HashMap<>();




    public Vendor(String name){
        MenuItem[] McD = new MenuItem[4];
        MenuItem cheeseburger = new MenuItem("Cheeseburger");
        MenuItem hamburger = new MenuItem("Hamburger");
        MenuItem chickenNug = new MenuItem("Chicken Nuggets");
        MenuItem salad = new MenuItem("Salad");
        McD[0] = cheeseburger;
        McD[1] = hamburger;
        McD[2] = chickenNug;
        McD[3] = salad;
        menus.put("McDonald's",McD);
        MenuItem[] TanD = new MenuItem[5];
        MenuItem chickenCur = new MenuItem("Chicken Curry");
        MenuItem lambCur = new MenuItem("Curry Lamb");
        MenuItem tofu = new MenuItem("Curry Tofu");
        MenuItem veg = new MenuItem("Veggies");
        MenuItem rice = new MenuItem("Rice");
        TanD[0] = chickenCur;
        TanD[1] = lambCur;
        TanD[2] = tofu;
        TanD[3] = veg;
        TanD[4] = rice;
        menus.put("Tandoor",TanD);
        MenuItem[] FS = new MenuItem[3];
        MenuItem chickenBr = new MenuItem("Chicken Breast");
        MenuItem roastB = new MenuItem("Roast Beef");
        MenuItem vegg = new MenuItem("Veggies");
        FS[0] = chickenBr;
        FS[1] = roastB;
        FS[2] = vegg;
        menus.put("Farmstead",FS);

        vop.put("McDonald's",1.75);
        vop.put("Tandoor",1.4);
        vop.put("Farmstead",1.1);
        myName = name;
        myVop= getVOp(name);
        myMenu = getMenu(name);

    }
    public double getVOp(String name){
        double V_Op = vop.get(name);
        return V_Op;
    }

    public MenuItem[] getMenu(String name){
        MenuItem[] menu = menus.get(name);
        return menu;
    }
    public String getName(){
        return myName;
    }
}
