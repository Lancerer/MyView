package com.example.lancer.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lancer on 2018/6/2.
 * 自定义View之Range（区域)
 */

public class MyViewRange extends View {
    private Context mContext;

    public MyViewRange(Context context) {
        super(context);
        mContext = context;
    }

    public MyViewRange(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewRange(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
