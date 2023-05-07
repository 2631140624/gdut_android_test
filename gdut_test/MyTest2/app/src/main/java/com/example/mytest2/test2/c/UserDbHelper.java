package com.example.mytest2.test2.c;

/**
 * @author :yinxiaolong
 * @describe : com.example.test2.c
 * @date :2023/4/15 21:22
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_EMAIL = "email";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER ," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_AGE + " INTEGER," +
                    COLUMN_EMAIL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean saveUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,user.getId());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_AGE, user.getAge());
        values.put(COLUMN_EMAIL, user.getEmail());
        List<User> users = getUsers();
        long rowId = 0;
        if (users.size()==0){
            rowId = db.insert(TABLE_NAME, null, values);
        }

        db.close();
        return rowId != -1;
    }

    public boolean updateUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,user.getId());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_AGE, user.getAge());
        values.put(COLUMN_EMAIL, user.getEmail());
        String selection = COLUMN_ID+ " = ?";
        String[] selectionArgs = {String.valueOf(user.getId())};

        int count=0;
        count = db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
        return count > 0;
    }

    public boolean deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        int count = db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
        return count > 0;
    }

    public List<User> getUsers() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_AGE,
                COLUMN_EMAIL
        };
        String sortOrder = COLUMN_ID + " ASC";
        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_AGE));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
            users.add(new User(id, name, age, email));
        }
        cursor.close();
        return users;
    }
}

