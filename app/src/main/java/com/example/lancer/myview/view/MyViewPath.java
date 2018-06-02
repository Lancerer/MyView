package com.example.lancer.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.security.PrivilegedAction;

/**
 * Created by Lancer on 2018/6/2.
 * 自定义VIew之路径path
 */

public class MyViewPath extends View {
    private Context mContext;

    public MyViewPath(Context context) {
        super(context);
        mContext = context;
    }

    public MyViewPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);


        Path path = new Path();
        path.moveTo(10, 10); //设定起始点
        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
        path.lineTo(300, 100);//画第二条直线
//        path.lineTo(400, 100);//第三条直线
        path.close();//闭环
        canvas.drawPath(path, paint);



/*先创建两个大小一样的路径（两者看上去没什么区别，但是就是在文字的排版上会按照路径去显示）
Path.Direction.CCW：是counter-clockwise缩写，指创建逆时针方向的矩形路径；
Path.Direction.CW：是clockwise的缩写，指创建顺时针方向的矩形路径；*/
//第一个逆向生成
        Path CCWRectpath = new Path();
        RectF rect1 = new RectF(50, 150, 240, 250);
        CCWRectpath.addRect(rect1, Path.Direction.CCW);
//第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 = new RectF(290, 150, 480, 250);
        CWRectpath.addRect(rect2, Path.Direction.CW);
//先画出这两个路径
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);

        String text = "生死看淡，不服就上";
        paint.setColor(Color.BLACK);
        paint.setTextSize(18);
        /*float hOffset  : 与路径起始点的水平偏移距离
        float vOffset  : 与路径中心的垂直偏移量*/
        canvas.drawTextOnPath(text, CCWRectpath, 0, 10, paint);
        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint);



/*
        圆角矩形
        第一个构造函数：可以定制每个角的圆角大小：
        float[] radii：必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
        第二个构造函数：只能构建统一圆角大小
        float rx：所产生圆角的椭圆的横轴半径；
        float ry：所产生圆角的椭圆的纵轴半径；*/
        RectF rect11 = new RectF(50, 300, 240, 400);
        path.addRoundRect(rect11, 10, 15, Path.Direction.CCW);

        RectF rect22 = new RectF(290, 300, 480, 400);
        float radii[] = {10, 15, 20, 25, 30, 35, 40, 45};
        path.addRoundRect(rect22, radii, Path.Direction.CCW);

        canvas.drawPath(path, paint);

        //圆形路径
        path.addCircle(50, 450, 50, Path.Direction.CCW);
        canvas.drawPath(path, paint);


        //圆弧路径
        RectF rectF = new RectF(10, 500, 100, 550);
        path.addArc(rectF, 0, 90);
        canvas.drawPath(path,paint);
    }
}
