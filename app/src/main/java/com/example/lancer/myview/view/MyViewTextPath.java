package com.example.lancer.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lancer on 2018/6/2.
 * 自定义View之文字
 */

public class MyViewTextPath extends View {
    private Context mContext;

    public MyViewTextPath(Context context) {
        super(context);
        mContext = context;
    }

    public MyViewTextPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewTextPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(50);
        paint.setAntiAlias(true);//抗锯齿

    /*   样式设置
        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
        paint.setStrikeThruText(true);//设置带有删除线效果*/

        canvas.drawText("Lancer", 10, 100, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Lancer", 10, 150, paint);

        paint.setTextSkewX((float) 0.25);//设置倾斜度
        canvas.drawText("Lancer", 10, 200, paint);

        paint.setTextScaleX(2);//水平拉伸两倍
        paint.setTextSkewX(0);
        canvas.drawText("Lancer", 10, 250, paint);

        //指定每个文字的位置
        float[] pos = {80, 300,
                80, 350,
                80, 400,
                80, 450};
        canvas.drawPosText("生死看淡", pos, paint);

        //设置字体样式
        String familyNmae = "隶书";
        Typeface font = Typeface.create(familyNmae, Typeface.ITALIC);
        paint.setTypeface(font);
        canvas.drawText("Lancer", 10, 500, paint);
    }
}
