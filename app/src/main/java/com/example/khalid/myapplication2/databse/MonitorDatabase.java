package com.example.khalid.myapplication2.databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MonitorDatabase extends SQLiteOpenHelper {

    public MonitorDatabase(Context context) {
        super(context, DatabaseConstants.DATABASE_NAME, null, DatabaseConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseConstants.TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DatabaseConstants.TABLE_NAME);
        onCreate(db);
    }

    public void createNewEntry(String productName, String fullDescription,String briefDescription
            , String productPrice, String brand, String productImages) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseConstants.PRODUCT_NAME, productName);
        values.put(DatabaseConstants.FULL_DESCRIPTION, fullDescription);
        values.put(DatabaseConstants.BRIEF_DESCRIPTION, briefDescription);
        values.put(DatabaseConstants.PRODUCT_PRICE, productPrice);
        values.put(DatabaseConstants.BRAND, brand);
        values.put(DatabaseConstants.PRODUCT_IMAGES, productImages);
        values.put(DatabaseConstants.PRODUCT_PRICE, productPrice);
        db.insert(DatabaseConstants.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<HashMap> getAllRecords() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseConstants.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<HashMap> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int unique_id = cursor.getInt(
                    cursor.getColumnIndex(DatabaseConstants.ID_COLUMN));
            String dataType = cursor.getString(
                    cursor.getColumnIndex(DatabaseConstants.FULL_DESCRIPTION));
            String uri = cursor.getString(
                    cursor.getColumnIndex(DatabaseConstants.PRODUCT_NAME));
            String time = cursor.getString(
                    cursor.getColumnIndex(DatabaseConstants.BRIEF_DESCRIPTION));
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("unique_id", String.valueOf(unique_id));
            hashMap.put("data_type", dataType);
            hashMap.put("uri", uri);
            hashMap.put("time_stamp", time);
            list.add(hashMap);
        }
        db.close();
        cursor.close();
        return list;
    }

    public void deleteEntry(int ID) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM "
                + DatabaseConstants.TABLE_NAME
                + " WHERE "
                + DatabaseConstants.ID_COLUMN
                + "="
                + ID;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        db.close();
        cursor.close();
    }

    public void clearTable() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + DatabaseConstants.TABLE_NAME;
        db.execSQL(query);
        db.close();
    }

    public boolean isEmpty() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseConstants.TABLE_NAME, null);
        boolean isEmpty;
        isEmpty = !cursor.moveToNext();
        cursor.close();
        return isEmpty;
    }
}
