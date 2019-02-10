package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {


    ShoppingCart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cart = (ShoppingCart)getIntent().getSerializableExtra("cart");
        if(savedInstanceState != null){
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
        if(cart == null)
            cart = new ShoppingCart();

        moveIntent.putExtra("cart",cart);
        startActivity(moveIntent);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(cart != null){
            outState.putSerializable("cart",cart);
        }

    }
}
