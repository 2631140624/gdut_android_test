package com.example.mytest3.a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mytest3.R;

public class SubAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
}