package ru.maksim.memento_pattern;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by maksim on 04.07.17.
 */

public class OnDragListener implements View.OnTouchListener {

    private static final String TAG = "OnDragListener";
    private final LineView mLineView;
    private float mInitX = 0;
    private float mInitY = 0;

    public OnDragListener(@NonNull LineView lineView) {
        mLineView = lineView;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ACTION_DOWN");
                mInitX = event.getX();
                mInitY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "ACTION_MOVE");
                float xDiff = event.getX() - mInitX;
                float yDiff = event.getY() - mInitY;
                v.setX(v.getX() + xDiff);
                v.setY(v.getY() + yDiff);
                mLineView.setFromX(mLineView.getFromX() + xDiff);
                mLineView.setFromY(mLineView.getFromY() + yDiff);
                mLineView.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP");
                break;
        }
        return true;
    }
}
