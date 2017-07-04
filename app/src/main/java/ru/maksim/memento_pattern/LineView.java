package ru.maksim.memento_pattern;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LineView extends View {

    private static final int DEFAULT_LINE_COLOR = 0xff000000;

    private Paint mPaint;
    private int mLineColor = DEFAULT_LINE_COLOR;
    private float mFromX = 0.0f;
    private float mFromY = 0.0f;
    private float mToX = 0.0f;
    private float mToY = 0.0f;

    public LineView(Context context) {
        super(context);
        init();
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LineView,
                0, 0
        );
        try {
            mLineColor = styledAttributes.getColor(R.styleable.LineView_lineColor,
                                                   DEFAULT_LINE_COLOR
            );
            mFromX = styledAttributes.getDimension(R.styleable.LineView_fromX, 0.0f);
            mFromY = styledAttributes.getDimension(R.styleable.LineView_fromY, 0.0f);
            mToX = styledAttributes.getDimension(R.styleable.LineView_toX, 0.0f);
            mToY = styledAttributes.getDimension(R.styleable.LineView_toY, 0.0f);
        } finally {
            styledAttributes.recycle();
        }
        init();
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mLineColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mLineColor);
        canvas.drawLine(mFromX, mFromY, mToX, mToY, mPaint);
    }

    public float getFromX() {
        return mFromX;
    }

    public void setFromX(float mFromX) {
        this.mFromX = mFromX;
    }

    public float getFromY() {
        return mFromY;
    }

    public void setFromY(float mFromY) {
        this.mFromY = mFromY;
    }

    public float getToX() {
        return mToX;
    }

    public void setToX(float mToX) {
        this.mToX = mToX;
    }

    public float getToY() {
        return mToY;
    }

    public void setToY(float mToY) {
        this.mToY = mToY;
    }
}
