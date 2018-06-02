package com.example.lancer.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.security.PrivilegedAction;

/**
 * Created by Lancer on 2018/6/2.
 * 自定义View之基本几何图形绘制
 */

public class MyView extends View {
    private Context mContext;

    public MyView(Context context) {
        super(context);
        mContext = context;
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

      /* pts:是点的集合，大家下面可以看到，这里不是形成连接线，而是每两个点形成一条直线，pts的组织方式为｛x1,y1,x2,y2,x3,y3,｝
       （上面有四个点：（10，10）、（100，100），（200，200），（400，400）），两两连成一条直线;*/
        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawLines(pts, paint);


      /*
        圆角矩形
        RectF rect:要画的矩形
        float rx:生成圆角的椭圆的X轴半径
        float ry:生成圆角的椭圆的Y轴半径*/
        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawRoundRect(rectF, 20, 10, paint);

   /*
        圆形
        float cx：圆心点X轴坐标
        float cy：圆心点Y轴坐标
        float radius：圆的半径*/
        canvas.drawCircle(200, 400, 20, paint);

       /*
        椭圆
        RectF oval：用来生成椭圆的矩形*/
        RectF rect = new RectF(10, 100, 100, 300);
        canvas.drawRect(rect, paint);//画矩形
        paint.setColor(Color.GREEN);//更改画笔颜色
        canvas.drawOval(rect, paint);//同一个矩形画椭圆

       /*
        弧
        RectF oval:生成椭圆的矩形
        float startAngle：弧开始的角度，以X轴正方向为0度
        float sweepAngle：弧持续的角度
        boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧*/
        RectF rectF1 = new RectF(350, 10, 450, 100);
        canvas.drawArc(rectF1, 0, 90, true, paint);
    }
}
