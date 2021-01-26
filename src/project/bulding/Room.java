package project.bulding;

import java.util.ArrayList;

public class Room {
    private ArrayList<Furniture> furnitures;
    private Building building;
    private String name;

    public Room(Building building, String name) {
        furnitures = new ArrayList<>();
        this.building = building;
        this.name = name;
        setFurnitureByName();
    }

    public void setFurnitureByName() {
        if (name.equals("спальня")) {
            furnitures.add(new Furniture("кровать"));
            furnitures.add(new Furniture("ковёр"));
        }
        else if (name.equals("ванная")) {
            furnitures.add(new Furniture("ванна"));
            furnitures.add(new Furniture("раковина"));
            furnitures.add(new Furniture("унитаз"));
        }
        else if (name.equals("кухня")) {
            furnitures.add(new Furniture("раковина"));
            furnitures.add(new Furniture("шкаф"));
            furnitures.add(new Furniture("стол"));
            furnitures.add(new Furniture("стул"));
        }

    }

    public ArrayList<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(ArrayList<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
