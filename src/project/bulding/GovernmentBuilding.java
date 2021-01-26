package project.bulding;

public class GovernmentBuilding extends Building{
    private String name;
    public GovernmentBuilding(Street street, String name1) {
        super(street);
        name = name1;
    }
    public String toString() {
        return "Здание правительства: " + name;
    }
}
