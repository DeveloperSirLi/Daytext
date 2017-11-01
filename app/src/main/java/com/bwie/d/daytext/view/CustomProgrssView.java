package com.bwie.d.daytext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by d on 2017/11/1.
 */

//100%progress
public class CustomProgrssView extends View {
    private Paint mpaint;
    private int progress = 0;
    private boolean running = true;
    public CustomProgrssView(Context context) {
        super(context);
    }

    public CustomProgrssView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //创建一个画笔
        mpaint = new Paint();
        //抗锯齿
        mpaint.setAntiAlias(true);
        //设置颜色
        mpaint.setColor(Color.RED);
        //设置样式  空心
        mpaint.setStyle(Paint.Style.STROKE);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(running){
                        if(progress>=360){
                            running = false;
                            return;
                        }
                            progress+=10;
                            //子线程刷新系统调用ondraw方法
                            postInvalidate();

                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();


    }

    //float sweep ;

    public CustomProgrssView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = getWidth()/2;
        int y = getHeight()/2;
        //定义半径
        int radius = 200;
        //设置画笔的粗细
        mpaint.setStrokeWidth(30);
        //定义一个区域
        RectF rectF = new RectF(x-radius,y-radius,x+radius,y+radius);
        //画弧
        canvas.drawArc(rectF,-90,progress,false,mpaint);
        int text = (int)((float)progress/360*100);
        //拿到字符串的长度
        float textwidth = mpaint.measureText(text+"%");
        Rect recttext = new Rect();
        mpaint.getTextBounds(text+"%",0,(text+"%").length(),recttext);

        mpaint.setTextSize(30);
        mpaint.setStrokeWidth(1);
        canvas.drawText(text+"%",x-textwidth/2,y+recttext.height()/2,mpaint);
    }
}
