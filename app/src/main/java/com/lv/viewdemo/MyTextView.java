package com.lv.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Lv on 2017/2/19.
 */

public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint1 = new Paint();
        paint1.setColor(getResources().getColor(android.R.color.holo_red_light));
        paint1.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(android.R.color.white));
        paint2.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);
        canvas.save();
        //绘制文字前向前平移10像素
        //canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
