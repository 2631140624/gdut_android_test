package com.example.mytest3.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "拦截", Toast.LENGTH_SHORT).show();
        //拦截广播
       abortBroadcast();
       context.startActivity(new Intent(context,SubAActivity.class));
    }
}