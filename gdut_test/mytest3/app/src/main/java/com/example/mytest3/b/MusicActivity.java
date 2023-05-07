package com.example.mytest3.b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mytest3.R;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {

    private MusicService.MusicBinder musicBinder;
    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicBinder= (MusicService.MusicBinder) iBinder;//连接成功后获取服务中的binder对象
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    lineView.setCurrentPotion(musicBinder.getPresent());
                    String[]time=musicBinder.time();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_end.setText(time[0]);
                            tv_start.setText(time[1]);
                        }
                    });

                }
            },0, 1000);

            setUI();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private Button btn_play;
    private Button btn_next;
    private Button btn_exit;

    private MyLineView lineView;

    private Timer timer;


    private TextView tv_name;
    private int img_url;

    private ImageView imageView;
    private TextView tv_start;
    private TextView tv_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        tv_name=findViewById(R.id.tv_name);
        tv_end=findViewById(R.id.tv_end_time);
        tv_start=findViewById(R.id.tv_start_time);
        imageView=findViewById(R.id.imageView);

        btn_play=findViewById(R.id.btn_play);
        btn_next=findViewById(R.id.btn_next);
        btn_exit=findViewById(R.id.btn_exit);
        lineView=findViewById(R.id.lineView);
        bindService(new Intent(MusicActivity.this, MusicService.class), mConnection, BIND_AUTO_CREATE);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(musicBinder == null)) {
                    musicBinder.playMusic();
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicBinder!=null){
                    musicBinder.playNext();
                    setUI();
                }
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicBinder!=null){
                    musicBinder.stopService();
                    finish();
                }
            }
        });


    }


    void setUI(){
        RequestOptions options = new RequestOptions().circleCropTransform();
        Glide.with(MusicActivity.this).load(musicBinder.getBgResId()).apply(options).into(imageView);
        tv_name.setText(musicBinder.getMusicName());
    }



    @Override
    protected void onDestroy() {

        unbindService(mConnection);
        timer.cancel();
        super.onDestroy();
    }
}