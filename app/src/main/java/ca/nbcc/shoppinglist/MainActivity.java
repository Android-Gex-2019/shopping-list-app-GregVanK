package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

/**
 * File: MainActivity
 * Author: Greg VanKampen
 * Date: 2/9/2019
 */
public class MainActivity extends AppCompatActivity {

    ShoppingCart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //grab any existing cart sent by an intent
        cart = (ShoppingCart)getIntent().getSerializableExtra("cart");

        if(savedInstanceState != null){
            //if a cart wasn't grabbed, but one exists in a save instance
            if(cart == null)
            savedInstanceState.getSerializable("cart");
        }

        //update list
        if(cart !=null){
            TextView list = findViewById(R.id.text_shoppinglist);
            list.setText(cart.toString());
        }


    }

    public void moveToItemSelect(View v){
        Intent moveIntent = new Intent(this, SecondActivity.class);

        //create a new cart if no existing cart
        if(cart == null)
            cart = new ShoppingCart();
        moveIntent.putExtra("cart",cart);
        startActivity(moveIntent);
    }

    //save cart
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(cart != null){
            outState.putSerializable("cart",cart);
        }

    }
}
