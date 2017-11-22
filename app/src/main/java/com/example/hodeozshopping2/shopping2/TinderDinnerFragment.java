package com.example.hodeozshopping2.shopping2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import link.fls.swipestack.SwipeStack;


public class TinderDinnerFragment extends Fragment {

    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItemsP;
    private View btnCancel;
    private View btnLove;
    private int currentPosition;
    private int e1, e2, e3, e4, e5, e6, e7, e8;

    Button myButton;


    private ArrayList<Integer> equipage = new ArrayList<>();
    private ArrayList<String> nom_equipage = new ArrayList<>();
    private final List EXTRA_NOM = new LinkedList();


    public TinderDinnerFragment() {
        // Required empty public constructor
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //btnCancel = getActivity().findViewById(R.id.cancel);
        //btnLove = getActivity().findViewById(R.id.bateau);
        //myButton = (Button) getActivity().findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToLeft();
            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToRight();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tinder_dinner, container, false);



        Intent mIntent = getActivity().getIntent();
        e1 = mIntent.getIntExtra("e1", e1);
        e2 = mIntent.getIntExtra("e2", e2);
        e3 = mIntent.getIntExtra("e3", e3);
        e4 = mIntent.getIntExtra("e4", e4);
        e5 = mIntent.getIntExtra("e5", e5);
        e6 = mIntent.getIntExtra("e6", e6);
        e7 = mIntent.getIntExtra("e7", e7);
        e8 = mIntent.getIntExtra("e8", e8);


        cardStack = (SwipeStack) v.findViewById(R.id.container);



        //setCardStackAdapterPirate();
        currentPosition = 0;

        //Handling swipe event of Cards stack
        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

                Toast.makeText(getActivity().getApplicationContext(), cardItemsP.get(currentPosition).getName() + " va niker sa mère ",
                        Toast.LENGTH_SHORT).show();
                currentPosition = position + 1;
                cardStack.swipeTopViewToLeft();

            }

            @Override
            public void onViewSwipedToRight(int position) {

                Toast.makeText(getActivity().getApplicationContext(), cardItemsP.get(currentPosition).getName() + " fait parti de l'équipage ",
                        Toast.LENGTH_SHORT).show();

                equipage.add(cardItemsP.get(currentPosition).getDrawableId());
                nom_equipage.add(cardItemsP.get(currentPosition).getName());

                currentPosition = position + 1;
                cardStack.swipeTopViewToRight();

                e1--;

                if (e1 == 0 /*&& e2 == 0 && e3 == 0 && e4 == 0 && e5 == 0 && e6 == 0 && e7 == 0 && e8 == 0*/) {
                    goToNextActivity();
                }
                /*else if (e1 == 0 && e2 != 0) {
                    goToNextActivityBis();
                }
                else if (e1 == 0 && e2 == 0 && e3 != 0) {
                    goToNextActivityTer();
                }*/

            }

            @Override
            public void onStackEmpty() {
            }
        });

        return v;
    }


   /* private void goToNextActivityTer() {

        Fragment fragment;
        fragment = new Shopping3ThirdFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("m3", m);
        bundle.putStringArrayList("my list name2", nom_equipage);
        bundle.putIntegerArrayList("my list2", equipage);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.fragment_shop3, fragment);
        fragmentTransaction.add(R.id.fragment_shop3, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    private void goToNextActivityBis() {

        Fragment fragment;
        fragment = new Shopping3SecondFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("n2", n);
        bundle.putInt("m2", m);
        bundle.putStringArrayList("my list name3", nom_equipage);
        bundle.putIntegerArrayList("my list3", equipage);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.fragment_shop3, fragment);
        fragmentTransaction.add(R.id.fragment_shop3, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }*/


    private void goToNextActivity() {

        Intent intent2 = new Intent(getActivity(), ListeCoursesActivity.class);
        //intent2.putExtra("my list name",nom_equipage);
        //intent2.putExtra("my list", equipage);

        startActivity(intent2);
    }



    private void setCardStackAdapterPirate() {
        cardItemsP = new ArrayList<>();

        //13 pirates

        cardItemsP.add(new CardItem(R.drawable.a, "Arlong", "Nez Pointu"));
        //cardItems.add(new CardItem(R.drawable.f, "Daddy Materson", "Barbu"));
        cardItemsP.add(new CardItem(R.drawable.g, "Don Krieg", "Défoncé"));
        //cardItems.add(new CardItem(R.drawable.e, "Coby", "L'enfant"));
        //cardItems.add(new CardItem(R.drawable.c, "Smoker", "La fumée"));
        //cardItems.add(new CardItem(R.drawable.d, "Carmen", "Cheveux Rouge"));
        cardItemsP.add(new CardItem(R.drawable.b, "Baggy", "Le Clown"));
        //cardItems.add(new CardItem(R.drawable.i, "Mihawk", "Le Samourai"));
        //cardItems.add(new CardItem(R.drawable.h, "Erik", "Beau Gosse"));
        //cardItems.add(new CardItem(R.drawable.j, "Kaya", "La Blonde"));
        cardItemsP.add(new CardItem(R.drawable.k, "Kuro", "En costar"));
        cardItemsP.add(new CardItem(R.drawable.l, "Luffy", "Le Capitaine"));
        //cardItems.add(new CardItem(R.drawable.m, "Morgane", "Sans Main"));
        cardItemsP.add(new CardItem(R.drawable.n, "Nami", "La Bonnasse"));
        //cardItems.add(new CardItem(R.drawable.o, "Nojiko", "L'Inconnue"));
        cardItemsP.add(new CardItem(R.drawable.p, "Ace", "L'Incontournable"));
        cardItemsP.add(new CardItem(R.drawable.q, "Zorro", "Sans Pitié"));
        cardItemsP.add(new CardItem(R.drawable.r, "Sanji", "Le Cuisto"));
        cardItemsP.add(new CardItem(R.drawable.s, "Shanks", "L'Eternel"));
        //cardItems.add(new CardItem(R.drawable.t, "Tashigi", "L'inconnue 2"));
        cardItemsP.add(new CardItem(R.drawable.u, "Chopper", "Le Mignon"));
        cardItemsP.add(new CardItem(R.drawable.v, "Usop", "Le peureux"));
        cardItemsP.add(new CardItem(R.drawable.w, "Yasopp", "Le père"));
        //cardItems.add(new CardItem(R.drawable.x, "Zeff", "Le Chef Etoilé"));

        cardsAdapter = new CardsAdapter(getActivity(), cardItemsP);
        cardStack.setAdapter(cardsAdapter);
    }

}
