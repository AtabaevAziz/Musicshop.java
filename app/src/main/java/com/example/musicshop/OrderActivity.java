package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"rano.jabbarova70@gmail.com"};
    String subject = "Order from Music Shop";
    String emailText;

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

        emailText = "Customer's Name: " + userName
                + "\n" + "Subject: " + goodsName
                + "\n" + "Quantity: " + quantity
                + "\n" + "Price: " + price
                + "\n" + "Order Price: " + orderPrice;
        orderTextView.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL,  addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

