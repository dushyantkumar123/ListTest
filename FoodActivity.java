package com.source.administrator.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {
    public static final String EXTRA_FOODNO = "foodNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        long foodno=(int)(getIntent().getExtras().get(EXTRA_FOODNO));
        Food food=Food.foods[(int)foodno];
        ImageView photo= (ImageView) findViewById(R.id.imageView2);
        TextView name= (TextView) findViewById(R.id.name);
        TextView description=(TextView)findViewById(R.id.description);
        photo.setImageResource(food.getImageResourceId());
        name.setText(food.getName());
        description.setText(food.getDescription());
    }
}
