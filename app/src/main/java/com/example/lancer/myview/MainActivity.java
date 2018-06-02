package com.example.lancer.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.lancer.myview.view.MyView;
import com.example.lancer.myview.view.MyViewCanvs;
import com.example.lancer.myview.view.MyViewPath;
import com.example.lancer.myview.view.MyViewTextPath;

public class MainActivity extends AppCompatActivity {

    private FrameLayout pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        pool.addView(new MyViewCanvs(this));
    }

    private void initView() {
        pool = findViewById(R.id.pool);
    }
}
