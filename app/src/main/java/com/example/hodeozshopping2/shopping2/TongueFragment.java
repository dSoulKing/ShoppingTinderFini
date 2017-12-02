package com.example.hodeozshopping2.shopping2;


import android.content.Intent;
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
    TextView textFleche;
    TextView textDinner, textDrink, textStarter, textBreakfast, textDessert, textMenu;

    private int e1, e2, e3, e4, e5, e6, e7, e8;


    public TongueFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String textDinnerString = "Dinner : 0/" + e1;
        textDinner = (TextView) getActivity().findViewById(R.id.dinnerInfo);
        textDinner.setText(textDinnerString);

        String textDrinkString = "Drink : 0/" + e2;
        textDrink = (TextView) getActivity().findViewById(R.id.drinkInfo);
        textDrink.setText(textDrinkString);

        String textStarterString = "Starter : 0/" + e3;
        textStarter = (TextView) getActivity().findViewById(R.id.starterInfo);
        textStarter.setText(textStarterString);

        String textBreakfastString = "Breakfast : 0/" + e4;
        textBreakfast = (TextView) getActivity().findViewById(R.id.breakfastInfo);
        textBreakfast.setText(textBreakfastString);

        String textDessertString = "Dessert : 0/" + e5;
        textDessert = (TextView) getActivity().findViewById(R.id.dessertInfo);
        textDessert.setText(textDessertString);

        String textMenuString = "Menu : 0/" + e6;
        textMenu = (TextView) getActivity().findViewById(R.id.menuInfo);
        textMenu.setText(textMenuString);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tongue, container, false);

        Intent mIntent = getActivity().getIntent();
        e1 = mIntent.getIntExtra("e1", e1);
        e2 = mIntent.getIntExtra("e2", e2);
        e3 = mIntent.getIntExtra("e3", e3);
        e4 = mIntent.getIntExtra("e4", e4);
        e5 = mIntent.getIntExtra("e5", e5);
        e6 = mIntent.getIntExtra("e6", e6);
        e7 = mIntent.getIntExtra("e7", e7);
        e8 = mIntent.getIntExtra("e8", e8);

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


    public void changeText1 (String data){
        textDinner.setText(data);
    }
    public void changeText2 (String data){
        textDrink.setText(data);
    }
    public void changeText3 (String data){
        textStarter.setText(data);
    }
    public void changeText4 (String data){
        textBreakfast.setText(data);
    }
    public void changeText5 (String data){
        textDessert.setText(data);
    }
    public void changeText6 (String data){
        textMenu.setText(data);
    }
}
