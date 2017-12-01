package com.example.hodeozshopping2.shopping2;


public class CardItem {

    private int drawableId;
    private String name;
    private String location;
    private int difficulteIdun;
    private int difficulteIddeux;
    private int difficulteIdtrois;
    private int difficulteIdquatre;
    private int difficulteIdcinq;



    public CardItem(int drawableId, String name, String location, int difficulteId,int difficulteIddeux,int difficulteIdtrois,int difficulteIdquatre,int difficulteIdcinq) {
        this.drawableId = drawableId;
        this.name = name;
        this.location = location;
        this.difficulteIdun = difficulteId;
        this.difficulteIddeux = difficulteIddeux;
        this.difficulteIdtrois = difficulteIdtrois;
        this.difficulteIdquatre = difficulteIdquatre;

    }

    public CardItem(int drawableId, String name, String location,int difficulteGrade) {
        this.drawableId = drawableId;
        this.name = name;
        this.location = location;

        //fct
        difficulteToque(difficulteGrade);

    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }




    public int getDifficulteIdun() {
        return difficulteIdun;
    }

    public void setDifficulteIdun(int difficulteIdun) {
        this.difficulteIdun = difficulteIdun;
    }

    public int getDifficulteIddeux() {
        return difficulteIddeux;
    }

    public void setDifficulteIddeux(int difficulteIddeux) {
        this.difficulteIddeux = difficulteIddeux;
    }

    public int getDifficulteIdtrois() {
        return difficulteIdtrois;
    }

    public void setDifficulteIdtrois(int difficulteIdtrois) {
        this.difficulteIdtrois = difficulteIdtrois;
    }

    public int getDifficulteIdquatre() {
        return difficulteIdquatre;
    }

    public void setDifficulteIdquatre(int difficulteIdquatre) {
        this.difficulteIdquatre = difficulteIdquatre;
    }

    public int getDifficulteIdcinq() {
        return difficulteIdcinq;
    }

    public void setDifficulteIdcinq(int difficulteIdcinq) {
        this.difficulteIdcinq = difficulteIdcinq;
    }



   public  void difficulteToque(int difficultelevel){

        switch(difficultelevel) {
            case 1:
                this.setDifficulteIdun(R.drawable.toque_pleine);
                this.setDifficulteIddeux(R.drawable.toque_vide);
                this.setDifficulteIdtrois(R.drawable.toque_vide);
                this.setDifficulteIdquatre(R.drawable.toque_vide);
                this.setDifficulteIdcinq(R.drawable.toque_vide);
                break;
            case 2:
                this.setDifficulteIdun(R.drawable.toque_pleine);
                this.setDifficulteIddeux(R.drawable.toque_pleine);
                this.setDifficulteIdtrois(R.drawable.toque_vide);
                this.setDifficulteIdquatre(R.drawable.toque_vide);
                this.setDifficulteIdcinq(R.drawable.toque_vide);
                break;
            case 3:
                this.setDifficulteIdun(R.drawable.toque_pleine);
                this.setDifficulteIddeux(R.drawable.toque_pleine);
                this.setDifficulteIdtrois(R.drawable.toque_pleine);
                this.setDifficulteIdquatre(R.drawable.toque_vide);
                this.setDifficulteIdcinq(R.drawable.toque_vide);
                break;
            case 4:
                this.setDifficulteIdun(R.drawable.toque_pleine);
                this.setDifficulteIddeux(R.drawable.toque_pleine);
                this.setDifficulteIdtrois(R.drawable.toque_pleine);
                this.setDifficulteIdquatre(R.drawable.toque_pleine);
                this.setDifficulteIdcinq(R.drawable.toque_vide);
                break;
            case 5:
                this.setDifficulteIdun(R.drawable.toque_pleine);
                this.setDifficulteIddeux(R.drawable.toque_pleine);
                this.setDifficulteIdtrois(R.drawable.toque_pleine);
                this.setDifficulteIdquatre(R.drawable.toque_pleine);
                this.setDifficulteIdcinq(R.drawable.toque_pleine);
                break;
        }
    }

}
