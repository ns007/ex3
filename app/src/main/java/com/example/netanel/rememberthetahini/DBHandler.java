package com.example.netanel.rememberthetahini;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "tasks.db"; //name of my db
    public static final String TABLE_TASKS = "tasks"; //name of the table in the db
    public static final String COLUMN_ID = "_id"; // column in the table
    public static final String COLUMN_TASKNAME = "taskname"; // column in the table

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TASKS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + "," +
                COLUMN_TASKNAME + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //when we want to upgrade our DATEBASE
        db.execSQL("DROP TABLE IF EXSITS" + TABLE_TASKS);
        onCreate(db);
    }
    //add new row to database
    public void addTask(Tasks task) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKNAME,task.get_taskname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }
    //delete task to database
    public void deleteTask(String taskname) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM" + TABLE_TASKS + "WHERE" + COLUMN_TASKNAME + "=\"" + taskname +"\";");
        db.close();
    }
    //database to arraylist
    public ArrayList<String> databaseToArraylist()
    {
        ArrayList<String> myArrayList = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_TASKS + " WHERE 1";
        Cursor c = db.rawQuery(query,null);
        //move c to start
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("taskname"))!=null){
                myArrayList.add(c.getString(c.getColumnIndex("taskname")));
            }
        }
        db.close();
        return myArrayList;
    }
}
