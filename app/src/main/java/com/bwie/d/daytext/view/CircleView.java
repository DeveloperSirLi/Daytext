package com.bwie.d.daytext.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by d on 2017/11/1.
 */

//画实心圆
public class CircleView extends View{
    //画笔
    private Paint mpaint;
    //XY轴中心点
    private int x;
    private int y;
    public CircleView(Context context) {
        super(context);
    }


    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化 画笔在构造方法  两个参数中NEW
        mpaint = new Paint();

    }

    //得到宽高的模式和实际数值
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    //onDraw 画布  把画圆的代码写在里面
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //getwidth  getheight  得到宽高
        x = getWidth()/2;
        y = getHeight()/2;
        mpaint.setColor(Color.RED);
        //canvas调用画圆的方法  参数XY的中心点,圆的半径,使用的画笔
        canvas.drawCircle(x,y,50,mpaint);
    }
}
