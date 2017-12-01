package com.example.hodeozshopping2.shopping2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class ListeCoursesActivity extends AppCompatActivity {

    Button buttonView;
    private LinearLayout linear;

    boolean tongue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_courses);

        tongue = true;

        linear = findViewById(R.id.linear);

        //linear.setVisibility(View.GONE);
        //linear.setAlpha(0.0f);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tongue) {
                    linear.animate().translationX(0f);
                    tongue = false;
                }
                else {
                    linear.animate().translationX(-0.8f * linear.getWidth());
                    tongue = true;
                }

            }
        });

        /*buttonView = findViewById(R.id.buttonView);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //linear.setVisibility(View.VISIBLE);
                scaleView(v, 0.2f, 1f);
                //scaleView(linear, 0f, 1f);
            }
        });*/

    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                1f, 1f, // Start and end values for the Y axis scaling
                Animation.ABSOLUTE, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_PARENT, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}
