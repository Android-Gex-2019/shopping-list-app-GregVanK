package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    ShoppingCart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        cart = (ShoppingCart)getIntent().getSerializableExtra("cart");
        if(savedInstanceState != null){
            if(cart == null)
                savedInstanceState.getSerializable("cart");
        }


    }

    public void itemSelection(View v){
         Button button  = (Button)v;
         cart.insertItem(button.getText().toString());
        Intent returnIntent = new Intent(this, MainActivity.class);
        returnIntent.putExtra("cart",cart);
        startActivity(returnIntent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(cart != null){
            outState.putSerializable("cart",cart);
        }

    }
}
