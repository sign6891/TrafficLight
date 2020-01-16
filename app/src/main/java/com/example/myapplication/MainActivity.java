package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout red, yellow, green;
    private Button button;
    private boolean startStop = false;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        button = findViewById(R.id.button);
    }

    public void onClickStart(View view) {
        if (!startStop) {
            button.setText(R.string.stop);
            startStop = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (startStop) {
                        count++;
                        switch (count) {
                            case 1:
                                red.setBackgroundColor(getResources().getColor(R.color.red));
                                yellow.setBackgroundColor(getResources().getColor(R.color.grey));
                                green.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                                red.setBackgroundColor(getResources().getColor(R.color.grey));
                                green.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                red.setBackgroundColor(getResources().getColor(R.color.grey));
                                yellow.setBackgroundColor(getResources().getColor(R.color.grey));
                                green.setBackgroundColor(getResources().getColor(R.color.green));
                                count = 0;
                                break;
                        }

                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else {
            startStop = false;
            button.setText(R.string.start);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startStop = true;
    }
}
