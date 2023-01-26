package com.example.simple_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "users.db";
    public static final int DATABASE_VERSION = 1;
    public static final String COLUMN_USERNAMES = "username";
    public static final String COLUMN_PASSWORDS = "password";
    private final Context context;
    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");

    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert(DATABASE_NAME, null, values);
        db.close();
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});

        Cursor cursor = db.rawQuery("SELECT * from " + DATABASE_NAME + " where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
        Cursor cursor = db.rawQuery("SELECT * from " + DATABASE_NAME + " where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

//    public Boolean checkAllInfo(String username, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ? and email = ?", new String[]{username, password, email});
//        if (cursor.getCount() > 0)
//            return true;
//        else return false;
//    }
}

