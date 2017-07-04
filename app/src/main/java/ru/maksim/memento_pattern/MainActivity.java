package ru.maksim.memento_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.rectangle1).setOnTouchListener(new OnDragListener());
        findViewById(R.id.rectangle2).setOnTouchListener(new OnDragListener());
    }
}
