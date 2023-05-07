package com.example.test2.b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.test1.R;

public class SubActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        editTextName=findViewById(R.id.edt_name);
        editTextPsw=findViewById(R.id.edt_paw);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {


        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", editTextName.getText().toString()); // 将结果数据存放在 Intent 中
        resultIntent.putExtra("psw", editTextPsw.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent); // 设置返回结果和数据
        super.onBackPressed();
    }

}