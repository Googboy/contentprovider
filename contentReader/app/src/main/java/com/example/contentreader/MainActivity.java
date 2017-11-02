package com.example.contentreader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Uri URI = Uri.parse("content://com.example.contentwrite");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(URI,null,null,null,null);
        cursor.moveToFirst();//将指针移动到第一位，不然会报指标越界异常
        for (int i = 0;i<cursor.getCount();i++){
            String value = cursor.getString(cursor.getColumnIndex("name"));
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
        }

    }
}
