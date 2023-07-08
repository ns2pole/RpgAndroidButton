package com.example.takumi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.myButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "ボタンがクリックされました", Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout layout = findViewById(R.id.layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(layout.getChildCount() == 0) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.leftMargin = (int)event.getX();
                        layoutParams.topMargin = (int)event.getY();

                        Button button = new Button(MainActivity.this);
                        button.setText("コントローラー");
                        button.setLayoutParams(layoutParams);

                        layout.addView(button);
                    }
                    return true;
                }
                return false;
            }

//            @Override
//            public boolean performClick() {
//                return super.performCkick();
//            }

        });


    }

}