package com.wefly.weflycollectlab.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information
    static final String DB_NAME = "jwt.db";

    // database version
    static final int DB_VERSION = 1;

    public static final String JWT_ID = "id";
    public static final String JWT_VALUE = "value";

    public static final String TABLE_NAME = "jwt";
    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" + JWT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + JWT_VALUE+ " TEXT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TABLE_DROP);
        onCreate(db);
    }
}
