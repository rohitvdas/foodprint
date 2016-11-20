package hackduke.foodprint;

/**
 * Created by pciporin on 11/20/16.
 */

import java.util.HashMap;

public class Transaction {
    String restName;
    Vendor myVendor;
    //HashMap<String,Integer> myOrder;

    //  public transaction(String vendor, HashMap<String,int> order){
    public Transaction(String vendor){
        restName = vendor;
        myVendor = new Vendor(vendor);
        //myOrder = order;
    }

    public double tScore(String order){
        //HashMap a = this.MyOrder;
        // double temp = 0.0;
        //for(String key: a.keySet()){
        //int numItems = a.get(key);
        MenuItem mIt = new MenuItem(order);
        //temp+=mIt.outCO2()*numItems;
        return mIt.outCO2();
    }
    public double eqCO2(String order, String restr){
        double a = this.tScore(order);
        double vOP = myVendor.getVOp(restr);
        return a*vOP;
    }
}

