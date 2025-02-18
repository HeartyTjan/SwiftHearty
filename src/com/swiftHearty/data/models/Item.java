package com.swiftHearty.data.models;

public class Item {
    private int id;
    private String description;
    private int weightInGram;

    public Item(){}

    public Item(String description, int weightInGram) {
        this.description = description;
        this.weightInGram = weightInGram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeightInGram(int newWeightInGram) {
        weightInGram = newWeightInGram;
    }

    public int getWeight() {
        return weightInGram;
    }
}
