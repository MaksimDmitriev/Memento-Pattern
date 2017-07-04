package ru.maksim.memento_pattern;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by maksim on 04.07.17.
 */

public class OnDragListener implements View.OnTouchListener {

    private static final String TAG = "OnDragListener";

    private float mInitX = 0;
    private float mInitY = 0;

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
                v.setX(v.getX() + event.getX() - mInitX);
                v.setY(v.getY() + event.getY() - mInitY);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP");
                break;
        }
        return true;
    }
}
