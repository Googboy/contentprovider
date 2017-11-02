package com.example.contentwrite;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });
    }
    public void write(){
        ContentValues values = new ContentValues();
        values.put("name","JAVA");
        getContentResolver().insert(Myprovider.URI,values);
        values.put("name","Swift");
        getContentResolver().insert(Myprovider.URI,values);
        values.put("name","Python");
        getContentResolver().insert(Myprovider.URI,values);
        values.put("name","c#");
        getContentResolver().insert(Myprovider.URI,values);
        Toast.makeText(getApplicationContext(),"写入成功",Toast.LENGTH_SHORT).show();
    }
}
