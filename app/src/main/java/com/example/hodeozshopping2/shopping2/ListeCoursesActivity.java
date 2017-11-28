package com.example.hodeozshopping2.shopping2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class ListeCoursesActivity extends AppCompatActivity {

    private View v;
    Button buttonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_courses);

        v = findViewById(R.id.viewContainer);

        // Prepare the View for the animation
        v.setVisibility(View.GONE);
        v.setAlpha(0.0f);

        buttonView = findViewById(R.id.buttonView);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scaleView(v, 0f, 1f);
            }
        });

        v = findViewById(R.id.viewContainer);
        scaleView(v, 0f, 1f);

    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                1f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}
