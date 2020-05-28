package com.example.carl.carlcontentresovler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Carl";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnInsert(View view) {
        //1.得到ContentResolver对象
        ContentResolver resolver = getContentResolver();
        //2.调用insert
        Uri uri = Uri.parse("content://com.example.carl.carlcontentprovider.personprovider/person/");
        ContentValues values = new ContentValues();
        values.put("name","JACK");
        uri = resolver.insert(uri,values);
        Log.i(TAG,"uri:"+uri.toString());
    }

    public void OnUpdate(View view) {
        //1.得到ContentResolver对象
        ContentResolver resolver = getContentResolver();
        //2.update
        Uri uri = Uri.parse("content://com.example.carl.carlcontentprovider.personprovider/person/2");
        ContentValues values = new ContentValues();
        values.put("name","JACK2");
        int updateCount = resolver.update(uri,values,null,null);
        Log.i(TAG,"updateCount:"+updateCount);
    }

    public void OnDelete(View view) {
        //1.得到ContentResolver对象
        ContentResolver resolver = getContentResolver();
        //2.update
        Uri uri = Uri.parse("content://com.example.carl.carlcontentprovider.personprovider/person/2");
        int deleteCount = resolver.delete(uri,null,null);
        Log.i(TAG,"deleteCount:"+deleteCount);
    }

    public void OnQuery(View view) {
        //1.得到ContentResolver对象
        ContentResolver resolver = getContentResolver();
        //2.调用query，得到cursor
        //Uri uri = Uri.parse("content://com.example.carl.carlcontentprovider.personprovider/person/1");
        Uri uri = Uri.parse("content://com.example.carl.carlcontentprovider.personprovider/person");
        Cursor cursor = resolver.query(uri,null,null,null,null);
        //3.取出cursor中的数据，并显示
        while (cursor.moveToNext()){
            int id =cursor.getInt(0);
            String name =cursor.getString(1);
            Log.i(TAG,id+":"+name);
        }
        cursor.close();
    }
}
