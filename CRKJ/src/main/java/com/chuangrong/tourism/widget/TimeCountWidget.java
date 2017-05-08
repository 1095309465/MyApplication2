package com.chuangrong.tourism.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.chuangrong.tourism.R;

/**
 * Created by DELL on 2017/5/8.
 */

public class TimeCountWidget extends View {

    private Paint mPaint;
    private int time = 3000;

    private int width, height;
    private int cW, cY;


    public TimeCountWidget(Context context) {
        this(context, null);
    }

    public TimeCountWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeCountWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeCountWidget);
        time = typedArray.getInt(R.styleable.TimeCountWidget_time, 3000);
        typedArray.recycle();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setDither(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GRAY);
        canvas.drawCircle(cW, cY, cW, mPaint);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        cW = width / 2;
        cY = height / 2;
    }
}
