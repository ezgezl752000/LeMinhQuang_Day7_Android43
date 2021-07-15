package com.example.leminhquang_day5_android43;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail extends AppCompatActivity {
    int price;
    ImageButton ibBack;
    TextView tvPriceCart;
    List<Food> listOrderFood;
    AdapterFood adapterFood;
    ListView lvFoodCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        price = 0;
        init();
        toBack();
    }

    void init(){
        lvFoodCart = findViewById(R.id.lvFoodCart);
        tvPriceCart= findViewById(R.id.tvPriceCart);
        ibBack = findViewById(R.id.ibBack);
        listOrderFood = new ArrayList<Food>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        listOrderFood = bundle.getParcelableArrayList("orderList");
        int totalPrice = intent.getIntExtra("totalPrice",0);
        tvPriceCart.setText(totalPrice + "$");

        adapterFood = new AdapterFood(listOrderFood);
        lvFoodCart.setAdapter(adapterFood);
    }

    void toBack(){
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Orderfood.class));
            }
        });
    }
}