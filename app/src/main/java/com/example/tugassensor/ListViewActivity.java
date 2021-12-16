package com.example.tugassensor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {


    SQLiteDatabase SQLITEDATABASE;
    SQLiteHelper SQLITEHELPER;
    SQLiteListAdapter ListAdapter;

    Cursor cursor;

    ArrayList<String> ID_ArrayList = new ArrayList<>();
    ArrayList<String> TITLE_ArrayList = new ArrayList<>();
    ArrayList<String> X_ArrayList = new ArrayList<>();
    ArrayList<String> Y_ArrayList = new ArrayList<>();
    ArrayList<String> Z_ArrayList = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list);

        SQLITEHELPER = new SQLiteHelper(this);
    }

    @Override
    protected void onResume() {

        TampilSQLiteDBData();
        super.onResume();
    }

    private void TampilSQLiteDBData() {
        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM Nama_Tabel", null);

        ID_ArrayList.clear();
        TITLE_ArrayList.clear();
        X_ArrayList.clear();
        Y_ArrayList.clear();
        Z_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));
                TITLE_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_TITLE)));
                X_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_X)));
                Y_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Y)));
                Z_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Z)));
            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListViewActivity.this, ID_ArrayList, TITLE_ArrayList,X_ArrayList,Y_ArrayList, Z_ArrayList);

        listView.setAdapter(ListAdapter);
        cursor.close();
    }
}