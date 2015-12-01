package com.example.android.fineweather.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View {
    Paint paint;
    int myHeight;
    int myWidth;
    private float direction;

    public MyView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {

        myHeight = getMeasuredHeight()-10;
        myWidth = getMeasuredWidth()-10;
        int radius;
        if (myHeight > myWidth) radius = myWidth / 2;
        else radius = myHeight / 2;

        paint.setColor(getResources().getColor(R.color.fineweather_light_blue));
        paint.setStrokeWidth(30);
        canvas.drawCircle(myWidth / 2, myHeight / 2, radius, paint);

        paint.setColor(getResources().getColor(R.color.white));
        paint.setStrokeWidth(5);
        canvas.drawLine(myWidth / 2,
                myHeight / 2,
                (float) (myWidth / 2 + radius * Math.sin(Math.toRadians(direction))),
                (float) (myHeight / 2 - radius * Math.cos(Math.toRadians(direction))),
                paint);

        paint.setColor(getResources().getColor(R.color.fineweather_light_blue));
        paint.setTextSize(15);
        canvas.drawText("N", myWidth / 2, myHeight, paint);

        paint.setColor(getResources().getColor(R.color.fineweather_light_blue));
        paint.setTextSize(15);
        canvas.drawText("S",25,50,paint);
    }

    public void update (float dir){
        direction=dir;
        invalidate();

    }
}
