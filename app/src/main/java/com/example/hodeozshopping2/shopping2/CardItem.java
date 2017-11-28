package com.example.hodeozshopping2.shopping2;


public class CardItem {

    private int drawableId;
    private String name;
    private String location;
    private int difficulte;

    public CardItem(int drawableId, String name, String location, int difficulte) {
        this.drawableId = drawableId;
        this.name = name;
        this.location = location;
        this.difficulte = difficulte;
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

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
