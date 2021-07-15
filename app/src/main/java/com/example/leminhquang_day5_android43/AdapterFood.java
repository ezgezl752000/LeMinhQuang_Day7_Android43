package com.example.leminhquang_day5_android43;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFood extends BaseAdapter {
    List<Food> foodList;

    public AdapterFood(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = layoutInflater.inflate(R.layout.item_food,viewGroup,false);

        TextView tvName = view1.findViewById(R.id.tvName);

        Food food = foodList.get(i);

        if(food.getNumber() >0 )tvName.setText(food.getName() + "(" + food.getNumber() + ")");
        else tvName.setText(food.getName());

        return view1;
    }
}
