package project.database;

import project.bulding.Location;
import project.bulding.Street;

import java.util.ArrayList;

public class StreetsFabric {
    public ArrayList<Street> getStreetsForLocation(Location location, int numberOfStreets){
        ArrayList<Street> streets = new ArrayList<>();
        for (int i = 1; i<numberOfStreets + 1; i++) {
            String name = String.format("%s-ая улица", i);
            Street street = new Street(location, name);
            streets.add(street);
        }return streets;
    }
}
