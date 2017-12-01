package com.example.hodeozshopping2.shopping2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TongueFragment extends Fragment {

    private LinearLayout linearTongue;
    private Boolean tongueBoolean;
    private TextView textFleche;

    public TongueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tongue, container, false);

        tongueBoolean = true;

        linearTongue = v.findViewById(R.id.linear);

        textFleche = v.findViewById(R.id.textFleche);
        textFleche.setText(">");



        linearTongue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tongueBoolean) {
                    linearTongue.animate().translationX(0f);
                    textFleche.setText("<");
                    tongueBoolean = false;
                }
                else {
                    linearTongue.animate().translationX(-0.9f * linearTongue.getWidth());
                    textFleche.setText(">");
                    tongueBoolean = true;
                }

            }
        });

        return v;
    }

}
