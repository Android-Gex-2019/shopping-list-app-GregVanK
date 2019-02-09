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


    }

    public void itemSelection(View v){
         Button button  = (Button)v;
         cart.insertItem(button.getText().toString());
        Intent returnIntent = new Intent(this, MainActivity.class);
        returnIntent.putExtra("cart",cart);
        startActivity(returnIntent);
    }
}
