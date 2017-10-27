package com.example.xxsj.yuekaodemo;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Point point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //倒计时跳转到主页面
        Handler handler = new Handler();
        handler.postDelayed(new Thread() {
            @Override
            public void run() {
                super.run();
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

    public void onClick(View v) {

        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(1000, 1000);
        //fraction是一个从0到1变化的值
        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new TypeEvaluator<Point>() {
            @Override
            public Point evaluate(float fraction, Point startValue, Point endValue) {
                float startX = startValue.getX();
                float endX = endValue.getX();
                float currentX = startX + fraction * (endX - startX);

                float startY = startValue.getY();
                float endY = endValue.getY();
                float currentY = startY + fraction * (endY - startY);
                return new Point(currentX, currentY);
            }
        }, startPoint, endPoint);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                point = (Point) animation.getAnimatedValue();
            }
        });

    }


}
