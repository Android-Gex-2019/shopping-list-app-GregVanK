package ca.nbcc.shoppinglist;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

public class ShoppingCart implements Serializable {

    Map<String,Integer> cart;
    public ShoppingCart(){
        cart =  new Hashtable<String,Integer>();
    }

    public void insertItem(String item){

        if(cart.containsKey(item)){
            cart.put(item,cart.get(item)+1);
    }
    else{
        cart.putIfAbsent(item,1);
        }
    }
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
