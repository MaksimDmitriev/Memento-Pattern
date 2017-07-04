package ru.maksim.memento_pattern;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RectangleView extends View {

    private int mStrokeColor;
    private Paint mPaint;

    public RectangleView(Context context) {
        super(context);
        init();
    }

    public RectangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RectangleView,
                0, 0
        );
        try {
            mStrokeColor = styledAttributes.getColor(R.styleable.RectangleView_strokeColor,
                                                     0xff000000
            );
        } finally {
            styledAttributes.recycle();
        }
        init();
    }

    public RectangleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mStrokeColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
