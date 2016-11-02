package com.example.khalid.myapplication2.databse;

public class DatabaseConstants {

    public static final String DATABASE_NAME = "Database.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "CartDatabase";
    public static final String PRODUCT_NAME = "product_name";
    public static final String BRIEF_DESCRIPTION = "brief_description";
    public static final String FULL_DESCRIPTION = "full_description";
    public static final String PRODUCT_PRICE = "product_price";
    public static final String QUANTITY = "quantity";
    public static final String BRAND = "brand";
    public static final String PRODUCT_IMAGES = "product_images";
    public static final String ID_COLUMN = "ID";
    private static final String OPENING_BRACE = "(";
    private static final String CLOSING_BRACE = ")";

    public static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + OPENING_BRACE
            + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PRODUCT_NAME + " TEXT,"
            + BRIEF_DESCRIPTION + " TEXT,"
            + FULL_DESCRIPTION + " TEXT,"
            + PRODUCT_PRICE + " TEXT,"
            + QUANTITY + " TEXT,"
            + BRAND + " TEXT,"
            + PRODUCT_IMAGES + " TEXT"
            + CLOSING_BRACE;
}
