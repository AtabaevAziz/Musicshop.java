package com.example.musicshop;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.MenuPopupWindow;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    Spinner spinner;
    ArrayList  spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    EditText userNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();

        createMap();
        userNameTextView = findViewById(R.id.editText);

    }

    private void createMap() {
        goodsMap = new HashMap();
        goodsMap.put("Guitar", 236.63);
        goodsMap.put("Drums", 365.82);
        goodsMap.put("Keyboard", 481.59);
    }

    private void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Drums");
        spinnerArrayList.add("Keyboard");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.price);
        priceTextView.setText("" + quantity*price);

    }

    public void decreaseQuantity(View view) {
        if (quantity == 0) {
            return ;
        }
        quantity = quantity - 1;
        TextView quantityTextView = findViewById((R.id.quantityTextView));
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.price);
        priceTextView.setText("" + quantity*price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.price);
        priceTextView.setText("" + quantity*price);
        ImageView goodsImageView = findViewById(R.id.goodsImageView);
        switch (goodsName) {
            case "Drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "Keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.userName = userNameTextView.getText().toString();
        order.quantity = quantity;
        order.goodsName = goodsName;
        order.orderPrice = quantity * price;
        //Log.d("order", "" + order.orderPrice);
        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userName",order.userName);
        orderIntent.putExtra("quantity",order.quantity);
        orderIntent.putExtra("goodsName",order.goodsName);
        orderIntent.putExtra("orderPrice",order.orderPrice);

        startActivity(orderIntent);
    }
}
