package com.example.mytest3.c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mytest3.R;

public class LVActivity extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);

        // Query data from database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = { "rowid _id", "name", "score", "gender" };
        Cursor cursor = db.query("students", projection, null, null, null, null, null);

        // Bind data to ListView using SimpleCursorAdapter
        String[] fromColumns = {"name", "score","gender"};
        int[] toViews = {R.id.name, R.id.score,R.id.gender};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item_student,
                cursor,
                fromColumns,
                toViews,
                0
        );
        listView.setAdapter(adapter);
    }
}