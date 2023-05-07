package com.example.mytest3.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytest3.R;

public class CActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;


    private EditText editName;
    private EditText editScore;
    private EditText editGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        
        editName=findViewById(R.id.edit_name);
        editScore=findViewById(R.id.edit_score);
        editGender=findViewById(R.id.edit_gender);

        //跳转到下一个activity 展示数据
        findViewById(R.id.see).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStudents();
            }
        });

        
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });


    }

    private void insert(){
        String name=editName.getText().toString();
        String score=editScore.getText().toString();
        String gender=editGender.getText().toString();
        if (!(name.equals("")||score.equals("")||gender.equals(""))) {
            dbHelper = new DatabaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("score", score);
            values.put("gender", gender);
            long newRowId = db.insert("students", null, values);
        }else {
            Toast.makeText(this, "所有项都不能为空", Toast.LENGTH_SHORT).show();
        }
    }
    // handle "Let me see!" button click event
    public void showStudents() {
        Intent intent = new Intent(this, LVActivity.class);
        startActivity(intent);
    }
}