package project.bulding;

public class House extends LivingBuilding{
    public House(Street street) {
        super(street);
    }

    @Override
    public String toString() {
        return "Дом";
    }
}
