package com.example.leminhquang_day5_android43;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Orderfood extends AppCompatActivity {
    List<Food> foodList,listOrderFood;
    Food food1,food2,food3,food6,food4,food5;
    AdapterFood adapterFood;
    ListView lvFood,lvFoodCart;
    int numberOrder;
    int price;
    ImageButton ibCart;
    Button btnOrder;
    TextView tvPrice, tvNumber, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);
        init();
        adapterFood = new AdapterFood(foodList);
        lvFood.setAdapter(adapterFood);
        itemOrder();
        getDetailCart();
        getFoodList();
        order();
    }

    private void init(){
        lvFoodCart = findViewById(R.id.lvFoodCart);
        numberOrder = 0;
        price = 0;
        tvResult = findViewById(R.id.tvResult);
        lvFood = findViewById(R.id.lvFood);
        ibCart = findViewById(R.id.ibCart);
        btnOrder = findViewById(R.id.btnOrder);
        tvPrice = findViewById(R.id.tvPrice);
        tvNumber = findViewById(R.id.tvNumber);

        listOrderFood =  new ArrayList<Food>();
        foodList = new ArrayList<>();
        food1 = new Food("Pizza Panda",10,0);
        food2 = new Food("KFC Super",11,0);
        food3 = new Food("Bread Eggs",12,0);
        food4 = new Food("Coca Cola",13,0);
        food5 = new Food("Chicken Super",14,0);
        food6 = new Food("Cup cake",15,0);

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);
    }
    private void itemOrder(){
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                foodList.get(i).setNumber( foodList.get(i).getNumber()+1 );
                numberOrder++;
                price += foodList.get(i).getPrice();
                tvPrice.setText(price + "$");
                tvNumber.setText(numberOrder + "");
            }
        });
    }

    private  void getFoodList(){
        for (Food i : foodList) {
            if( i.getNumber() > 0) listOrderFood.add(i);
        }
    }

    private void getDetailCart(){
        ibCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFoodList();
                Intent intent = new Intent(getBaseContext(), OrderDetail.class);
                intent.putExtra("totalPrice",price);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("orderList", (ArrayList<? extends Parcelable>) listOrderFood);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private void order(){
        btnOrder.setOnClickListener(new View.OnClickListener() {
            String result ="";
            @Override
            public void onClick(View view) {
                getFoodList();
                result = "Thank you! Your order is sent to restaurant !";
                Toast.makeText(getBaseContext(),result,Toast.LENGTH_LONG).show();
            }
        });
    }
}