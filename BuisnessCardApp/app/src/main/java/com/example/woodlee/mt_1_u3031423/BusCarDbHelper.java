package com.example.woodlee.mt_1_u3031423;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Woodlee on 1/4/17.
 */

public class BusCarDbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "business_cards";
    public static final String COLUMN_ID = "id";
    public static final String NAME = "name";
    public static final String IMAGE_RESOURCE = "image_resource";
    public static final String JOBTITLE = "jobtitle";
    public static final String COMPANY = "company";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String WEBSITE = "website";

    private static final int VERSION = 1;
    private static final String DB_NAME = "BusinessCardDb";


    public BusCarDbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(" +
                COLUMN_ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                IMAGE_RESOURCE + " integer, " + JOBTITLE + " text, " + COMPANY + " text, " + EMAIL + " text, " + PHONE + " String, " +
                WEBSITE + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<BusinessCard> getAllCards() {
        ArrayList<BusinessCard> cardsList = new ArrayList<BusinessCard>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            BusinessCard card = new BusinessCard(
                    res.getLong(res.getColumnIndex(COLUMN_ID)), res.getString(res.getColumnIndex(NAME)),
                    res.getInt(res.getColumnIndex(IMAGE_RESOURCE)), res.getString(res.getColumnIndex(JOBTITLE)),
                    res.getString(res.getColumnIndex(COMPANY)), res.getString(res.getColumnIndex(WEBSITE)),
                    res.getString(res.getColumnIndex(EMAIL)), res.getString(res.getColumnIndex(PHONE)));
            cardsList.add(card);
            res.moveToNext();
        }
        return cardsList;
    }

    public long insertCard(BusinessCard card) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, card.getName());
        contentValues.put(IMAGE_RESOURCE, card.getImageResource());
        contentValues.put(JOBTITLE, card.getJobTitle());
        contentValues.put(COMPANY, card.getCompany());
        contentValues.put(PHONE, card.getPhone());
        contentValues.put(EMAIL, card.getEmail());
        contentValues.put(WEBSITE, card.getWebsite());
        return db.insert(TABLE_NAME, null, contentValues);

    }

    public Integer deleteCard(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ? ", new String[]{id});
    }

    public boolean updateCard(String id, BusinessCard card) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, card.getName());
        contentValues.put(IMAGE_RESOURCE, card.getImageResource());
        contentValues.put(JOBTITLE, card.getJobTitle());
        contentValues.put(COMPANY, card.getCompany());
        contentValues.put(PHONE, card.getPhone());
        contentValues.put(EMAIL, card.getEmail());
        contentValues.put(WEBSITE, card.getWebsite());
        if(db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{id}) == 0){
        }
        return true;
    }

}
