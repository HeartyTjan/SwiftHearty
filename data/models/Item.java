package data.models;

public class Item {
    private int id;
    private String description;
    private int weightInGram;
    private int counter = 0;

    public Item() {}

    public Item(String description, int weightInGram) {
        this.id = id;
        this.description = description;
        this.weightInGram = weightInGram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String generateID(){

        return String.valueOf(counter++);

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
