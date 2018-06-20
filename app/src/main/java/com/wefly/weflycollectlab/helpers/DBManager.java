package com.wefly.weflycollectlab.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.wefly.weflycollectlab.models.Token;

public class DBManager {
    public static final String TABLE_NAME = "jwt";
    public static final String JWT_ID = "id";
    public static final String JWT_VALUE = "value";
    protected Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context, "jwt.db", null, 1);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    /**
     * @param val le token à ajouter à la base
     */
    public void ajouter(String val) {
        ContentValues value = new ContentValues();
        value.put(DBManager.JWT_VALUE, val);
        database.insert(DBManager.TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du token à supprimer
     */
    public void supprimer(long id) {
        database.delete(TABLE_NAME, JWT_ID + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * @param t le token modifié
     */
    public void modifier(Token t) {
        ContentValues value = new ContentValues();
        value.put(JWT_VALUE, t.getValeur());
        database.update(TABLE_NAME, value, JWT_ID + " = ?", new String[]{String.valueOf(t.getId())});
    }

    /**
     * token à récupérer
     */
    public Cursor selectionner() {
        String[] columns = new String[]{DatabaseHelper.JWT_VALUE};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    /**
     * Supprime tous les enregistrements
     */
    public void deleteAll() {
        database.execSQL("delete from " + TABLE_NAME);
    }
}
