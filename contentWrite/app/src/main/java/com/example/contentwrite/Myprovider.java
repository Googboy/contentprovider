package com.example.contentwrite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 潘硕 on 2017/11/2.
 */

public class Myprovider extends ContentProvider {
    public static final Uri URI = Uri.parse("content://com.example.contentwrite");//定义一个路径，就和隐式Intent方式差不多
    SQLiteDatabase database ;
    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE,null);//创建一个数据库
        database.execSQL("create table tab(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = database.query("tab",null,null,null,null,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        database.insert("tab","_id",values);
        //database.close();
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
