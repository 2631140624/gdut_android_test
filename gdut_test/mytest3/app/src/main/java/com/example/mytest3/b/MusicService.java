package com.example.mytest3.b;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.mytest3.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener,MediaPlayer.OnCompletionListener,MediaPlayer.OnErrorListener{

    private static String TAG="MusicLifeCycle";
    private MediaPlayer mMediaPlayer;

    private int[] musicResId={
            R.raw.dydyzyq,
            R.raw.hqwbmg,
            R.raw.sxdqw
    };

    private String[] musicName={
            "多远都要在一起",
            "红蔷薇白玫瑰",
            "手心的蔷薇"
    };

    private  int[] bgResId={
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2
    };

    private int currentCount=0;

    private float present=0;

    private final MusicBinder musicBinder=new MusicBinder();

    class MusicBinder extends Binder{


        public void playMusic() {

            if (!mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
            }else {
                mMediaPlayer.pause();
            }
        }


        //获取歌曲的播放进度
        public float getPresent(){
            return present;
        }
        public void playNext(){
            setCurrentCount();
            prepare();
        }

        public void stopService(){
            stopSelf();
        }

        public int getMusicResId(){
            return musicResId[currentCount];
        }

        public int getBgResId(){
            return bgResId[currentCount];
        }

        public String getMusicName(){
            return musicName[currentCount];
        }

        public String[] time(){

            String time1=new SimpleDateFormat("mm:ss").format(new Date(mMediaPlayer.getDuration()));
            String time2=new SimpleDateFormat("mm:ss").format(new Date(mMediaPlayer.getCurrentPosition()));

            String[] times={time1,time2};

            return times;

        }

    }


    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");

        return musicBinder;
    }

    Timer timer;
    //第一次播放时
    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: ");
        mMediaPlayer = MediaPlayer.create(this, R.raw.dydyzyq);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnErrorListener(this);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    //播放结束
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //present=0;
        setCurrentCount();
        prepare();
    }

    private void setCurrentCount(){
        currentCount++;
        if (currentCount==3){
            currentCount=0;
        }
    }

    /**
     * 准备歌曲
     */
    private void prepare(){
        timer.cancel();
        mMediaPlayer.reset();
        try {
            mMediaPlayer.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + musicResId[currentCount]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mMediaPlayer.prepareAsync();
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
//创建定时任务
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                present= (float) mediaPlayer.getCurrentPosition()/ (float) mediaPlayer.getDuration();
            }
        },0, 1000);
    }



    @Override
    public void onDestroy() {
        timer.cancel();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }




}