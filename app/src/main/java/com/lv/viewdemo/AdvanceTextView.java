package com.lv.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 带闪动效果的TextView
 * Created by Lv on 2017/2/19.
 */

public class AdvanceTextView extends TextView {

    private int viewWidth;

    private Paint paint;

    private LinearGradient linearGradient;

    private Matrix matrix;

    private int translate;

    public AdvanceTextView(Context context) {
        super(context);
    }

    public AdvanceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (viewWidth == 0) {
            viewWidth = getMeasuredWidth();
            if (viewWidth > 0) {
                paint = new Paint();
                linearGradient = new LinearGradient(0, 0, viewWidth, 0, new int[]{Color.BLUE, 0xffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                paint.setShader(linearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (matrix != null) {
            translate += viewWidth / 5;
            if (translate > 2 * viewWidth) {
                translate -= viewWidth;
            }
            matrix.setTranslate(translate,0);
            linearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);
        }
    }
}
