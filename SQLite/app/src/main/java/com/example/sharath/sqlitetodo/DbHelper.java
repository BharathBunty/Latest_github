package com.example.sharath.sqlitetodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sharath on 26-02-2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Tester";
    private static final String DB_TABLE = "Task";
    private static final String DB_COLOUMN = "TaskName";
    private static final int DB_VER = 1;


    public DbHelper(Context context){
        super(context, DB_NAME, null , DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT , %s TEXT NOT NULL);", DB_TABLE, DB_COLOUMN);
      sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = String.format("DELETE  TABLE IF EXISTS %s", DB_TABLE);
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }


    public  void  insertNewTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLOUMN, task);
        db.insertWithOnConflict(DB_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void  deleteTask(String task){
        SQLiteDatabase db =  this.getWritableDatabase();
        db.delete(DB_TABLE, DB_COLOUMN + " = ?" , new String[]{task});
        db.close();
    }


    public ArrayList<String> getTaskList(){
         ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(DB_TABLE, new String[]{DB_COLOUMN}, null, null, null, null, null);
        while (cursor.moveToNext()){
            int index = cursor.getColumnIndex(DB_COLOUMN);
            taskList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return  taskList;
    }




}
