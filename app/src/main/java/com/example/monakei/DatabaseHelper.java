package com.example.monakei;

// DatabaseHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "akei.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProductsTable = "CREATE TABLE Product (id INTEGER PRIMARY KEY, name TEXT, description TEXT, price REAL, weight REAL)";
        String createVehiclesTable = "CREATE TABLE Vehicle (id INTEGER PRIMARY KEY, name TEXT, brand TEXT, licensePlate TEXT, fuelType TEXT, capacity REAL)";
        String createEmployeesTable = "CREATE TABLE Employee (id INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, department TEXT)";

        db.execSQL(createProductsTable);
        db.execSQL(createVehiclesTable);
        db.execSQL(createEmployeesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Product");
        db.execSQL("DROP TABLE IF EXISTS Vehicle");
        db.execSQL("DROP TABLE IF EXISTS Employee");
        onCreate(db);
    }
}
