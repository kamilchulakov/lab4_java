package project.bulding;

import java.util.ArrayList;
import java.util.Arrays;

public class Furniture {
    private ArrayList<Thing> things;
    private String name;

    public Furniture(String name) {
        this.name = name;
        things = new ArrayList<>();
        if (name.equals("стол")) {
            things.add(new Thing("печенье"));
            things.add(new Thing("кружка чая"));
        }

    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
