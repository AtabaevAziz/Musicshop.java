package com.example.musicshop;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.MenuPopupWindow;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Drums");
        spinnerArrayList.add("Keyboard");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("Guitar", 236.63);
        goodsMap.put("Drums", 365.82);
        goodsMap.put("Keyboard", 481.59);

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
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
