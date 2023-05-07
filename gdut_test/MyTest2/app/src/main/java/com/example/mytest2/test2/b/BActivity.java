package com.example.mytest2.test2.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytest2.R;

public class BActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_return);
        findViewById(R.id.btn_startsub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this, SubActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            String psw = data.getStringExtra("psw"); // 获取返回结果数据
            String name = data.getStringExtra("name");
            textView.setText("账号："+name+"\n"+"密码："+psw);
            // 处理返回结果

    }

}