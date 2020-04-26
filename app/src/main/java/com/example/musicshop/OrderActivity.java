package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("ADD TO CART");

        Intent reciverdOrderIntent = getIntent();
        String userName = reciverdOrderIntent.getStringExtra("userName");
        double price = reciverdOrderIntent.getDoubleExtra("price", 0);
        String orderPrice = reciverdOrderIntent.getStringExtra("orderPrice");
        int quantity = reciverdOrderIntent.getIntExtra("quantity", 0);
        String goodsName = reciverdOrderIntent.getStringExtra("goodsName");
        TextView orderTextView = findViewById(R.id.orderUserName);

        orderTextView.setText("Customer's Name: " + userName
                + "\n" + "Subject: " + goodsName
                + "\n" + "Quantity: " + quantity
                + "\n" + "Price: " + price
                + "\n" + "Order Price: " + orderPrice);
    }
}
