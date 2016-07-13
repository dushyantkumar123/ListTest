package com.source.administrator.listtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 7/11/2016.
 */
public class SqlLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="starbuzz";
    private static final int DB_VERSION=7;

    public SqlLiteHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT,"+"DESCRIPTION TEXT,"+"IMAGE_RESOURCE_ID INTEGER"+"FAVOURITE INTEGER);");
       // updateMyDatabase(db,0,DB_VERSION);

        insertDrink(db,"latte","Esspresso and steamed milk",R.drawable.latte);
        insertDrink(db,"filter","dddddddddddddd",R.drawable.filter);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
        insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);

    }
    private static void insertDrink(SQLiteDatabase db,String name,String description,int resourceId)
    {
        ContentValues drinkValues=new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);

    }
    private void updateMyDatabase(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        if(oldVersion<1)
        {
            db.execSQL("CREATE TABLE DRINK(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT,"+"DESCRIPTION TEXT,"+"IMAGE_RESOURCE_ID INTEGER);");

        }
        if(oldVersion<7)
        {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVOURITE INTEGER");
            insertDrink(db,"latte","Esspresso and steamed milk",R.drawable.latte);
            insertDrink(db,"filter","dddddddddddddd",R.drawable.filter);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);
            insertDrink(db,"cappucinno","ssssssssssssss",R.drawable.cappuccino);

        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DELETE FROM DRINK WHERE 1=1;");
        updateMyDatabase(db,i,DB_VERSION);
    }
}
