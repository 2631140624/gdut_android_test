package com.example.test1.b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.test1.R;

import java.util.ArrayList;
import java.util.List;

public class BActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Bean> list;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        recyclerView=findViewById(R.id.recyclerview_b);
        list=new ArrayList<>();

        //*****
        list.add(new Bean(R.drawable.img,"红酒","20000"));
        list.add(new Bean(R.drawable.img_1,"手表","30000"));
        list.add(new Bean(R.drawable.img,"红酒","20000"));
        list.add(new Bean(R.drawable.img_1,"手表","30000"));
        list.add(new Bean(R.drawable.img,"红酒","20000"));
        list.add(new Bean(R.drawable.img_1,"手表","30000"));
        list.add(new Bean(R.drawable.img_1,"红酒","20000"));
        list.add(new Bean(R.drawable.img_1,"红酒","20000"));


        adapter=new Adapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}