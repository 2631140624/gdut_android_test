package com.example.mytest3.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author :yinxiaolong
 * @describe : com.example.mytest3.b
 * @date :2023/4/25 20:31
 */
public class MyLineView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint paint2=new Paint(Paint.ANTI_ALIAS_FLAG);
    public MyLineView(Context context) {
        super(context);
    }


    {
        paint.setColor(Color.parseColor("#b8bdc0"));
        paint2.setColor(Color.parseColor("#924660"));
        paint.setStrokeWidth(2);
        paint2.setStrokeWidth(2);
    }
    public MyLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private float currentPotion=0;

    public void setCurrentPotion(float present){
        currentPotion=getWidth()*present;
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0,getHeight()/2f,getWidth(),getHeight()/2f,paint);

        canvas.drawLine(0,getHeight()/2f,currentPotion,getHeight()/2f,paint2);
    }
}
