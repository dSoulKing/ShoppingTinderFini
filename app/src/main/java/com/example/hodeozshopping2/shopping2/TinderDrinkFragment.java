package com.example.hodeozshopping2.shopping2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import link.fls.swipestack.SwipeStack;


public class TinderDrinkFragment extends Fragment {


    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItemsP;
    private int currentPosition;

    private int e1Max, e2Max, e3Max, e4Max, e5Max, e6Max, e7Max, e8Max, e1, e2, e3, e4, e5, e6, e7, e8;
    int e2Counter = 0;
    Communicator comm;
    IswitchFragments iswitchFragments;

    TextView typeRepas;

    ImageView drinkButton;

    ImageView nonSwipe, ouiSwipe;
    Button filtersButton;

    /*ArrayList<Integer> equipage = new ArrayList<>();
    ArrayList<String> nom_equipage = new ArrayList<>();
    private final List EXTRA_NOM = new LinkedList();*/


    public TinderDrinkFragment() {
        // Required empty public constructor
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comm = (Communicator) getActivity();
        iswitchFragments = (IswitchFragments) getActivity();


        typeRepas = getActivity().findViewById(R.id.typeRepas);
        String drink = "Drink";
        typeRepas.setText(drink);

        drinkButton = getActivity().findViewById(R.id.imageViewDrink);

        nonSwipe = getActivity().findViewById(R.id.non);
        ouiSwipe = getActivity().findViewById(R.id.oui);
        filtersButton = getActivity().findViewById(R.id.filters);

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToDinnerFragment();
            }
        });

        nonSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToLeft();
            }
        });

        ouiSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToRight();
            }
        });

        filtersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Comming soon",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tinder_drink, container, false);

        Bundle bundle = this.getArguments();
        e1Max = bundle.getInt("e1Max", e1Max);
        e2Max = bundle.getInt("e2Max", e2Max);
        e3Max = bundle.getInt("e3Max", e3Max);
        e4Max = bundle.getInt("e4Max", e4Max);
        e5Max = bundle.getInt("e5Max", e5Max);
        e6Max = bundle.getInt("e6Max", e6Max);
        e7Max = bundle.getInt("e7Max", e7Max);
        e8Max = bundle.getInt("e8Max", e8Max);
        e1 = bundle.getInt("e1", e1);
        e2 = bundle.getInt("e2", e2);
        e3 = bundle.getInt("e3", e3);
        e4 = bundle.getInt("e4", e4);
        e5 = bundle.getInt("e5", e5);
        e6 = bundle.getInt("e6", e6);
        e7 = bundle.getInt("e7", e7);
        e8 = bundle.getInt("e8", e8);

        cardStack = v.findViewById(R.id.container);

        setCardStackAdapterPirate();
        currentPosition = 0;

        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

                /*Toast.makeText(getActivity().getApplicationContext(), cardItemsP.get(currentPosition).getName() + " va niker sa mère ",
                        Toast.LENGTH_SHORT).show();*/
                currentPosition = position + 1;
                cardStack.swipeTopViewToLeft();

            }

            @Override
            public void onViewSwipedToRight(int position) {

                /*Toast.makeText(getActivity().getApplicationContext(), cardItemsP.get(currentPosition).getName() + " fait parti de l'équipage ",
                        Toast.LENGTH_SHORT).show();*/

                //equipage.add(cardItemsP.get(currentPosition).getDrawableId());
                //nom_equipage.add(cardItemsP.get(currentPosition).getName());

                currentPosition = position + 1;
                cardStack.swipeTopViewToRight();

                e2--;
                e2Counter++;
                comm.respond2("Drink : " + e2Counter + "/" + e2Max);


                if (e1 == 0 && e2 == 0 /*&& e3 == 0 && e4 == 0 && e5 == 0 && e6 == 0 && e7 == 0 && e8 == 0*/) {
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

    private void goToDinnerFragment() {
        iswitchFragments.switchFragment(IswitchFragments.ID.FRAG1);
    }


    private void goToNextActivity() {

        Intent intent2 = new Intent(getActivity(), ListeCoursesActivity.class);
        //intent2.putExtra("my list name",nom_equipage);
        //intent2.putExtra("my list", equipage);

        startActivity(intent2);
    }


    //private void setTextLanguette() {}

    private void setCardStackAdapterPirate() {
        cardItemsP = new ArrayList<>();

        //13 pirates

        cardItemsP.add(new CardItem(R.drawable.bagel, "bagel", "15 minutes", 2));
        //cardItems.add(new CardItem(R.drawable.f, "Daddy Materson", "Barbu"));
        cardItemsP.add(new CardItem(R.drawable.boeuf_bourguignon, "Boeuf bourguignon", "40 minutes", 3));
        //cardItems.add(new CardItem(R.drawable.e, "Coby", "L'enfant"));
        //cardItems.add(new CardItem(R.drawable.c, "Smoker", "La fumée"));
        //cardItems.add(new CardItem(R.drawable.d, "Carmen", "Cheveux Rouge"));
        cardItemsP.add(new CardItem(R.drawable.cake_thon, "Cake thon", "25 minutes", 3));
        //cardItems.add(new CardItem(R.drawable.i, "Mihawk", "Le Samourai"));
        //cardItems.add(new CardItem(R.drawable.h, "Erik", "Beau Gosse"));
        //cardItems.add(new CardItem(R.drawable.j, "Kaya", "La Blonde"));
        cardItemsP.add(new CardItem(R.drawable.carbonara, "Carbonara", "15 minutes", 2));
        cardItemsP.add(new CardItem(R.drawable.chili_cone_carne, "Chili con carne", "25 minutes", 3));
        //cardItems.add(new CardItem(R.drawable.m, "Morgane", "Sans Main"));
        cardItemsP.add(new CardItem(R.drawable.hachi, "Hachi parmentier", "30 minutes", 3));
        //cardItems.add(new CardItem(R.drawable.o, "Nojiko", "L'Inconnue"));
        cardItemsP.add(new CardItem(R.drawable.mafe_poulet, "Mafe au poulet", "35 minutes", 4));
        cardItemsP.add(new CardItem(R.drawable.maki, "Maki saumon cornichon", "Sans Pitié", 3));
        cardItemsP.add(new CardItem(R.drawable.paella, "Paella", "45 minutes", 4));
        cardItemsP.add(new CardItem(R.drawable.pizza_margarita, "Pizza margarita", "30 minutes", 3));
        //cardItems.add(new CardItem(R.drawable.t, "Tashigi", "L'inconnue 2"));
        cardItemsP.add(new CardItem(R.drawable.salade_cesar, "Salade Cesar", "20 minutes", 3));
        cardItemsP.add(new CardItem(R.drawable.spaghetti_bolognaise, "Spaghetti bolognaise", "20 minutes", 2));
        cardItemsP.add(new CardItem(R.drawable.steak_frites, "Steak frites", "15 minutes", 1));
        //cardItems.add(new CardItem(R.drawable.x, "Zeff", "Le Chef Etoilé"));

        cardsAdapter = new CardsAdapter(getActivity(), cardItemsP);
        cardStack.setAdapter(cardsAdapter);
    }


}
