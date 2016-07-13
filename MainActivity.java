package com.source.administrator.listtest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }

            }
        };
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(itemClickListener);
        //listView.setOnClickListener((itemClickListener));
       ListView fav = (ListView) findViewById(R.id.list_favourite);
        SQLiteOpenHelper helper = new SqlLiteHelper(this);
        db = helper.getWritableDatabase();
       cursor = db.query("DRINK", new String[]{"_id", "NAME"}, "FAVOURITE=1", null, null, null, null);
       CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, cursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
       fav.setAdapter(cursorAdapter);
    }


    public void onDestroy() {
        super.onDestroy();
        db.close();
       cursor.close();

    }
    public void onRestart()
    {
        super.onRestart();
        SQLiteOpenHelper helper = new SqlLiteHelper(this);
        db = helper.getWritableDatabase();
       Cursor newcursor = db.query("DRINK", new String[]{"_id", "NAME"}, "FAVOURITE=1", null, null, null, null);
        ListView listView= (ListView) findViewById(R.id.list_favourite);
        CursorAdapter cursorAdapter= (CursorAdapter) listView.getAdapter();
        cursorAdapter.changeCursor(newcursor);
        cursor=newcursor;

    }
}
