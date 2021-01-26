package project.bulding;

public class Cottage extends LivingBuilding{
    public Cottage(Street street) {
        super(street);
    }

    @Override
    public String toString() {
        return "Коттедж";
    }
}
