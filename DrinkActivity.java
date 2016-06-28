package com.source.administrator.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkno=(int)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink=Drink.drinks[drinkno];
        ImageView photo= (ImageView) findViewById(R.id.imageView2);
        TextView name= (TextView) findViewById(R.id.name);
        TextView description=(TextView)findViewById(R.id.description);
        photo.setImageResource(drink.getImageResourceId());
        name.setText(drink.getName());
        description.setText(drink.getDescription());

    }
}
