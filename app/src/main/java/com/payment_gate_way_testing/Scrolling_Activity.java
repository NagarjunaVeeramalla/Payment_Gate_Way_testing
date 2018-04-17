package com.payment_gate_way_testing;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by Nagarjuna on 2/17/2018.
 */

public class Scrolling_Activity extends AppCompatActivity {

    TextSwitcher simpleTextSwitcher;
    TextView One_Way;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_scroll_view);



        One_Way=findViewById(R.id.one_way);
        simpleTextSwitcher=(TextSwitcher)findViewById(R.id. simpleTextSwitcher);
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                TextView t = new TextView(Scrolling_Activity.this);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                t.setTextSize(25);
                return t;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        simpleTextSwitcher.setInAnimation(in);
        simpleTextSwitcher.setOutAnimation(out);

        simpleTextSwitcher.setText("Round Trip");
        One_Way.setText("One Way");

        simpleTextSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (One_Way.getText().toString().equals("One Way")){
                  One_Way.setText("Round Trip");
                   simpleTextSwitcher.setText("One Way");
               }else {
                   One_Way.setText("One Way");
                   simpleTextSwitcher.setText("Round Trip");
               }
            }
        });

        One_Way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (One_Way.getText().toString().equals("One Way")){
                    One_Way.setText("Round Trip");
                    simpleTextSwitcher.setText("One Way");
                }else {
                    One_Way.setText("One Way");
                    simpleTextSwitcher.setText("Round Trip");
                }
            }
        });





    }
}
