package com.example.fxrates;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null,  Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
                    + " TEXT, "+ ")" ;
            Log.d("dbdeepak", "Query being run is : "+ create);
            db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public void deleteById(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(id)});
//        db.close();
//    }
//
//    public void deleterate(Rates rates){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(rates)});
//        db.close();
//    }
}
