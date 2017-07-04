package ru.maksim.memento_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LineView lineView = (LineView) findViewById(R.id.lineView);
        findViewById(R.id.rectangle1).setOnTouchListener(new OnDragListener(lineView));
        findViewById(R.id.rectangle2).setOnTouchListener(new OnDragListener(lineView));
    }
}
