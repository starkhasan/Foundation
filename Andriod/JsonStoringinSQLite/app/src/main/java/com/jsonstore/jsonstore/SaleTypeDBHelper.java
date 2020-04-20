package com.jsonstore.jsonstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SaleTypeDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SaleTypeDB";
    public static final String SALE_TYPE_TABLE_NAME = "SALETYPE";

    public SaleTypeDBHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SALETYPE(id text,name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + SALE_TYPE_TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public boolean insertData(String tableid,String value)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",tableid);
        values.put("name",value);
        long flag = sqLiteDatabase.insert(SALE_TYPE_TABLE_NAME,null,values);
        sqLiteDatabase.close();
        if(flag == -1){
            return  false;
        }else{
            return  true;
        }
    }


    public ArrayList fetchData(String ids)
    {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String fetchdata = "SELECT * FROM SALETYPE WHERE id = "+ids;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(fetchdata, null);
        if(cursor.moveToFirst()){
            do
            {
                stringArrayList.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return stringArrayList;
    }

    public void deleteData(String jsonID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(SALE_TYPE_TABLE_NAME,"id"+"="+jsonID,null);
    }

    public void deleteAll(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ SALE_TYPE_TABLE_NAME);

    }

    public ArrayList fetchALL()
    {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String fetchdata = "SELECT * FROM SALETYPE";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(fetchdata, null);
        if(cursor.moveToFirst()){
            do
            {
                stringArrayList.add(cursor.getString(0)+cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return stringArrayList;
    }


}
