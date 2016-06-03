package com.yuyife.flyui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuyife on 16-6-1.
 */
public class FlyView extends View {

    private Paint mPaint;
    public FlyView(Context context) {
        super(context);
        init();
    }

    public FlyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.CYAN);

        mPaint.setColor(Color.BLACK);

        canvas.drawRect(0,0,200,200,mPaint);
    }
}
