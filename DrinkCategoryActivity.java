package com.source.administrator.listtest;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {
        Cursor cursor;
        SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listDrinks= getListView();
        try{
            SQLiteOpenHelper starbuzzHelper=new SqlLiteHelper(this);
             db=starbuzzHelper.getReadableDatabase();
            cursor=db.query("DRINK",new String[]{"_id","NAME"},null,null,null,null,null);
            CursorAdapter listAdapter=new SimpleCursorAdapter(this,android.R.layout.simple_expandable_list_item_1,cursor,new String[]{"NAME"},new int[]{android.R.id.text1},0);

            listDrinks.setAdapter(listAdapter);

        }catch (Exception e)
        {

        }

        //ArrayAdapter<Drink>listAdapter=new ArrayAdapter<Drink>(this,android.R.layout.simple_list_item_1,Drink.drinks);
        //listDrinks.setAdapter(listAdapter);

    }
    public void onDestroy()
    {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    public void onListItemClick(ListView listView,View itemView,int position,long id)
    {
        Intent intent=new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO,(int)id);
        startActivity(intent);
    }
}
