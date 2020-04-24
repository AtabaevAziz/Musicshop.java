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
        Intent reciverdOrderIntent = getIntent();
        String userName = reciverdOrderIntent.getStringExtra("userName");
        double orderPrice = reciverdOrderIntent.getDoubleExtra("orderPrice", 0);
        int quantity = reciverdOrderIntent.getIntExtra("quantity", 0);
        String goodsName = reciverdOrderIntent.getStringExtra("goodsName");
        TextView orderTextView = findViewById(R.id.orderUserName);

        orderTextView.setText(userName + "\n" + goodsName + "\n" + quantity + "\n" + orderPrice);
    }
}
