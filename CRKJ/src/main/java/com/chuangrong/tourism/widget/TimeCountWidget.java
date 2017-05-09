package com.chuangrong.tourism.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.util.LogUtil;

/**
 * Created by DELL on 2017/5/8.
 */

public class TimeCountWidget extends View {

    private Paint mPaint;
    private int time = 3000;

    private int width, height;
    private int cW, cY;
    private Rect textRect;
    private String title = "跳过";
    private int timeNub = 3;
    private String timeNubStr = "";

    private Handler mHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (timeNub <= 0) {
                if (onStopListener != null) onStopListener.stop();
                return;
            }
            invalidate();
            timeNub -= 1;
            mHandler.postDelayed(this, 1000);
        }
    };

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
        textRect = new Rect();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.timeCountBg));
        canvas.drawCircle(cW, cY, cW, mPaint);


        mPaint.setColor(getResources().getColor(R.color.timeCountStroke));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawCircle(cW, cY, cW - 5, mPaint);

        mPaint.setColor(getResources().getColor(R.color.white));
        textRect.setEmpty();
        mPaint.getTextBounds(title, 0, title.length(), textRect);
        mPaint.setTextSize(30);
        mPaint.setStrokeWidth(1);
        canvas.drawText(title, cW - mPaint.measureText(title) / 2, cY - 10, mPaint);


        timeNubStr = timeNub + "s";
        textRect.setEmpty();
        mPaint.getTextBounds(timeNubStr, 0, timeNubStr.length(), textRect);
        canvas.drawText(timeNubStr, cW - mPaint.measureText(timeNubStr) / 2, cY + textRect.height(), mPaint);


    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        cW = width / 2;
        cY = height / 2;
    }

    public void startCount() {
        mHandler.removeCallbacks(runnable);
        mHandler.postDelayed(runnable, 1000);
    }

    public void stopCount() {
        mHandler.removeCallbacks(runnable);
    }

    public OnStopListener onStopListener;

    public void setOnStopListener(OnStopListener onStopListener) {
        this.onStopListener = onStopListener;
    }

    public interface OnStopListener {
        void stop();
    }
}
