package com.pnu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String tableName="users";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table Students(email  text primary key , password text)");
        db.execSQL("create table "+ tableName +"("+KEY_NAME+" text primary key , "+KEY_PASSWORD +" text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("drop table if exists Students");
        db.execSQL("drop table if exists users");
    }

      public void addUser(User user) {
         db = this.getWritableDatabase();
        //User u=new User();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName()); // User Name
        values.put(KEY_PASSWORD, user.getPassword()); // User pass
        db.insert(tableName, null, values);
        db.close(); // Closing database connection
    }

    public List<User> getUsers(String username) {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM users where "+KEY_NAME+"='"+username+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User u = new User();
                u.setName(cursor.getString(0));
                u.setPassword(cursor.getString(1));
                // Adding user to list
                userList.add(u);
            } while (cursor.moveToNext());
        }
        // return users list
        return userList;
    }
}