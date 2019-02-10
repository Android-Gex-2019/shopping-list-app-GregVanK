package ca.nbcc.shoppinglist;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;
/**
 * File: ShoppingCart
 * Author: Greg VanKampen
 * Date: 2/9/2019
 */

//cart inherits from Serializable for easy intent attachment
public class ShoppingCart implements Serializable {

    Map<String,Integer> cart;
    public ShoppingCart(){
        cart =  new Hashtable<String,Integer>();
    }

    //create a new item or add to an existing count
    public void insertItem(String item){

        if(cart.containsKey(item)){
            cart.put(item,cart.get(item)+1);
    }
    else{
        cart.putIfAbsent(item,1);
        }
    }
    //print out contents
    @Override
    public String toString(){
        String results = "";

        //iterate through map
        for(Map.Entry<String,Integer> entry : cart.entrySet()){
            results += entry.getKey() + " " + entry.getValue().toString() + "\n";
        }

        return results;
    }
}
