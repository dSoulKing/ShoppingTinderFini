package com.example.hodeozshopping2.shopping2;


public class CardItem {

    private int drawableId;
    private String name;
    private String location;
    private int difficulteId;

    public CardItem(int drawableId, String name, String location, int difficulteId) {
        this.drawableId = drawableId;
        this.name = name;
        this.location = location;
        this.difficulteId = difficulteId;
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

    public int getDifficulteId() {
        return difficulteId;
    }

    public void setDifficulteId(int difficulteId) {
        this.difficulteId = difficulteId;
    }
}
