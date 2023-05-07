package com.example.mytest3.a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytest3.R;

public class AActivity extends AppCompatActivity {

    AReceiver aReceiver;
    BReceiver bReceiver;
    CReceiver cReceiver;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        btn_send=findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("Intercept_Stitch");
                sendOrderedBroadcast(intent,null);//如果是该自定义的广播接收者发送广播，第二个参数一般为null
            }
        });

        IntentFilter filterA = new IntentFilter();
        filterA.setPriority(1001);
        filterA.addAction("Intercept_Stitch");
        aReceiver=new AReceiver();
        registerReceiver(aReceiver,filterA);

        IntentFilter filterB = new IntentFilter();
        filterA.setPriority(1000);
        filterA.addAction("Intercept_Stitch");
        bReceiver=new BReceiver();
        registerReceiver(bReceiver,filterB);

        IntentFilter filterC = new IntentFilter();
        filterA.setPriority(1000);
        filterA.addAction("Intercept_Stitch");
        cReceiver=new CReceiver();
        registerReceiver(cReceiver,filterC);

    }

    @Override
    protected void onDestroy() {

        unregisterReceiver(aReceiver);
        unregisterReceiver(bReceiver);
        unregisterReceiver(cReceiver);

        super.onDestroy();
    }
}