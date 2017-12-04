package com.example.hodeozshopping2.shopping2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {

    ImageView imageViewDinner,
              imageViewDrink,
              imageViewStarter,
              imageViewBreakfast,
              imageViewDessert,
              imageViewMenu,
              imageViewPersons,
              imageViewBudget,
              imageViewOptions,
              imageViewValider,
              imageViewInfo;

    EditText editTextDinner,
             editTextDrink,
             editTextStarter,
             editTextBreakfast,
             editTextDessert,
             editTextMenu,
             editTextPersons,
             editTextBudget;

    int e1, e2, e3, e4, e5, e6, e7, e8;

    boolean infoBoolean;

    //private ArrayList<Integer> equipage = new ArrayList<>();
    //private ArrayList<String> nom_equipage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        e1 = e2 = e3 = e4 = e5 = e6 = e7 = e8 = 0;

        infoBoolean = false;

        imageViewDinner = findViewById(R.id.imageViewDinner);
        imageViewDrink = findViewById(R.id.imageViewDrink);
        imageViewStarter = findViewById(R.id.imageViewStarter);
        imageViewBreakfast = findViewById(R.id.imageViewBreakfast);
        imageViewDessert = findViewById(R.id.imageViewDessert);
        imageViewMenu = findViewById(R.id.imageViewMenuNonGrise);
        imageViewPersons = findViewById(R.id.imageViewNumberPersons);
        imageViewBudget = findViewById(R.id.imageViewBudget);
        imageViewOptions = findViewById(R.id.imageViewParametres);
        imageViewValider = findViewById(R.id.imageViewValider);
        imageViewInfo = findViewById(R.id.imageViewInfo);

        editTextDinner = findViewById(R.id.editTextDinner);
        editTextDrink = findViewById(R.id.editTextDrink);
        editTextStarter = findViewById(R.id.editTextStarter);
        editTextBreakfast = findViewById(R.id.editTextBreakfast);
        editTextDessert = findViewById(R.id.editTextDessert);
        editTextMenu = findViewById(R.id.editTextMenu);
        editTextPersons = findViewById(R.id.editTextNumberPersons);
        editTextBudget = findViewById(R.id.editTextBudget);


        imageViewDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextDinner.getText().toString().length() == 0) {
                    e1 = 0;
                }
                else {
                    String value1 = editTextDinner.getText().toString();
                    e1 = Integer.parseInt(value1);
                }
                e1++;
                editTextDinner.setText(Integer.toString(e1));
            }
        });
        imageViewDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextDrink.getText().toString().length() == 0) {
                    e2 = 0;
                }
                else {
                    String value2 = editTextDrink.getText().toString();
                    e2 = Integer.parseInt(value2);
                }
                e2++;
                editTextDrink.setText(Integer.toString(e2));
            }
        });
        imageViewStarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextStarter.getText().toString().length() == 0) {
                    e3 = 0;
                }
                else {
                    String value3 = editTextStarter.getText().toString();
                    e3 = Integer.parseInt(value3);
                }
                e3++;
                editTextStarter.setText(Integer.toString(e3));
            }
        });
        imageViewBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextBreakfast.getText().toString().length() == 0) {
                    e4 = 0;
                }
                else {
                    String value4 = editTextBreakfast.getText().toString();
                    e4 = Integer.parseInt(value4);
                }
                e4++;
                editTextBreakfast.setText(Integer.toString(e4));
            }
        });
        imageViewDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextDessert.getText().toString().length() == 0) {
                    e5 = 0;
                }
                else {
                    String value5 = editTextDessert.getText().toString();
                    e5 = Integer.parseInt(value5);
                }
                e5++;
                editTextDessert.setText(Integer.toString(e5));
            }
        });
        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextMenu.getText().toString().length() == 0) {
                    e6 = 0;
                }
                else {
                    String value6 = editTextMenu.getText().toString();
                    e6 = Integer.parseInt(value6);
                }
                e6++;
                editTextMenu.setText(Integer.toString(e6));
            }
        });
        imageViewPersons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextPersons.getText().toString().length() == 0) {
                    e7 = 0;
                }
                else {
                    String value7 = editTextPersons.getText().toString();
                    e7 = Integer.parseInt(value7);
                }
                e7++;
                editTextPersons.setText(Integer.toString(e7));
            }
        });
        /*imageViewBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editTextBudget.getText().toString().length() == 0) {
                    e8 = 0;
                }
                else {
                    String value8 = editTextBudget.getText().toString();
                    e8 = Integer.parseInt(value8);
                }
                e8++;
                editTextBudget.setText(Integer.toString(e8));
            }
        });*/
        imageViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                OptionsFragment optionsFragment = new OptionsFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.container, optionsFragment)
                        .addToBackStack("")
                        .commit();
            }
        });

        imageViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                if (infoBoolean) {
                    fm.popBackStackImmediate();
                }
                else {
                    InfoFragment infoFragment = new InfoFragment();
                    ft.add(R.id.container, infoFragment)
                            .addToBackStack("")
                            .commit();
                }
                infoBoolean = !infoBoolean;
            }
        });

        imageViewValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                goToNextActivity();
            }
        });
    }

    private void goToNextActivity() {

        Intent intent = new Intent(ShoppingActivity.this, TinderActivity.class);
        intent.putExtra("e1", e1);
        intent.putExtra("e2", e2);
        intent.putExtra("e3", e3);
        intent.putExtra("e4", e4);
        intent.putExtra("e5", e5);
        intent.putExtra("e6", e6);
        intent.putExtra("e7", e7);
        intent.putExtra("e8", e8);
        //intent.putExtra("my list name", nom_equipage);
        //intent.putExtra("my list", equipage);

        startActivity(intent);
    }
}