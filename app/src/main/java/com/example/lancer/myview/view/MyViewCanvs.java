package com.example.lancer.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lancer on 2018/6/2.
 * 自定义VIew之canvas的变换和操作（注意canvas在变换之后是不可逆的）
 */

public class MyViewCanvs extends View {
    private Context mContext;

    public MyViewCanvs(Context context) {
        super(context);
        mContext = context;
    }

    public MyViewCanvs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewCanvs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

      /*  这里需要注意的是移动画布不等同于移动屏幕
        canvas相当于一个透明图层，每次Canvas画图时（即调用Draw系列函数），都会产生一个透明图层，
        然后在这个图层上画图，画完之后覆盖在屏幕上显示。*/
        RectF rectF = new RectF(0, 0, 100, 100);
        canvas.drawRect(rectF, paint);
        canvas.save();//保存画布当前的状态

        canvas.translate(100, 100);//移动画布，画布默认在（0,0）点
        paint.setColor(Color.RED);
        canvas.drawRect(rectF, paint);

        canvas.rotate(30);//旋转画布，这时的画布原点已经是（100,100）了
        paint.setColor(Color.BLUE);
        canvas.drawRect(rectF, paint);

        canvas.scale(0.5f, 1);//缩放，x轴为原来的0.5，y轴和原来相同
        paint.setColor(Color.BLACK);
        canvas.drawRect(rectF, paint);

        /*float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，
        float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值，*/
        canvas.skew(1.732f, 0);//斜切
        paint.setColor(Color.YELLOW);
        canvas.drawRect(rectF, paint);

        //剪裁画布（clip系列）也是不可逆的

        //画布的save（）和restore（）方法
        canvas.restore();//恢复保存的画布的状态
        RectF rectF2 = new RectF(150, 0, 250, 100);
        paint.setColor(Color.WHITE);
        canvas.drawRect(rectF2, paint);


    }
}
