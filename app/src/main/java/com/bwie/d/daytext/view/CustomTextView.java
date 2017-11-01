package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import com.bwie.d.daytext.R;

/**
 * Created by d on 2017/10/31.
 */

public class CustomTextView extends TextView {

    private String text;
    private int color;
    private int textSize;
    private Paint mPaint;
    private Rect mRect;
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray typedArray =  context.obtainStyledAttributes(attrs,R.styleable.CustomTextView);
        int count = typedArray.getIndexCount();
        for(int i=0; i<count; i++){
            int attr = typedArray.getIndex(i);
            switch (attr)
            {
                case R.styleable.CustomTextView_text:
                    text = typedArray.getString(attr);
                    break;
                case R.styleable.CustomTextView_textColor:
                    color = typedArray.getInt(attr, Color.BLUE);
                    break;
                case R.styleable.CustomTextView_textSize:
                    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                    textSize = typedArray.getDimensionPixelSize(attr, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(textSize);
        mRect = new Rect();
        mPaint.getTextBounds(text,0,text.length(),mRect);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(color);
        canvas.drawText(text,(getWidth()-mRect.width())/2,(getHeight()+mRect.height())/2,mPaint);


    }
}
