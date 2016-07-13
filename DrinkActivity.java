package com.source.administrator.listtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        long drinkno=(int)(getIntent().getExtras().get(EXTRA_DRINKNO));
        try{
            SQLiteOpenHelper starbuzzHelper=new SqlLiteHelper(this);
            SQLiteDatabase db=starbuzzHelper.getReadableDatabase();
            Cursor cursor=db.query("DRINK",
                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID","FAVOURITE"},"_id=?",new String[]{Long.toString(drinkno)},null,null,null);
            if(cursor.moveToFirst())
            {
                String nameText=cursor.getString(0);
                String description=cursor.getString(1);
                int photoId=cursor.getInt(2);
                boolean isFAvourite=(cursor.getInt(3)==1);
                CheckBox checkBox= (CheckBox) findViewById(R.id.checkBox);
                checkBox.setChecked(isFAvourite);
                ImageView photo= (ImageView) findViewById(R.id.imageView2);
                TextView name= (TextView) findViewById(R.id.name);
                TextView desc=(TextView)findViewById(R.id.description);
                photo.setImageResource(photoId);
                name.setText(nameText);
                desc.setText(description);
            }
            cursor.close();
            db.close();
        }catch (Exception e)
        {

        }
    }
    public void onFavouriteClick(View v)
    {
        int drinkNo=(Integer)getIntent().getExtras().get("drinkNo");
        /*CheckBox favourite= (CheckBox) findViewById(R.id.checkBox);
        ContentValues contentValues=new ContentValues();
        contentValues.put("FAVOURITE",favourite.isChecked());
        SQLiteOpenHelper helper=new SqlLiteHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        db.update("DRINK",contentValues,"_id=?",new String[]{Integer.toString(drinkNo)});
        db.close();*/
        new UpdateDrinkTAsk().execute(drinkNo);

    }
    private class UpdateDrinkTAsk extends AsyncTask<Integer,Void,Boolean> {
        ContentValues drinkValues;

        @Override

        protected void onPreExecute(){
            CheckBox favourite= (CheckBox) findViewById(R.id.checkBox);
            drinkValues=new ContentValues();
            drinkValues.put("FAVOURITE",favourite.isChecked());
        }
        protected Boolean doInBackground(Integer... drinks)
        {
            int drinkNo=drinks[0];
            SQLiteOpenHelper helper=new SqlLiteHelper(DrinkActivity.this);
            SQLiteDatabase db=helper.getWritableDatabase();
            db.update("DRINK",drinkValues,"_id=?",new String[]{Integer.toString(drinkNo)});
            db.close();
            return true;
        }
        protected void onPostExecute(Boolean success)
        {
            if(!success){
                Toast.makeText(DrinkActivity.this,"database unavailable",Toast.LENGTH_LONG).show();
            }
        }
    }
}
