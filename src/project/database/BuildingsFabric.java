package project.database;

import project.bulding.*;

import java.util.ArrayList;

public class BuildingsFabric {
    public ArrayList<LivingBuilding> getLivingBuildings(Street street, int numberOfBuildings) {
        ArrayList<LivingBuilding> livingBuildings = new ArrayList<>();
        RoomFabric roomFabric = new RoomFabric();
        for (int i =0; i<numberOfBuildings; i++) {
            LivingBuilding livingBuilding = new House(street);
            if ((int) (Math.random() * 2) == 1) livingBuilding = new Cottage(street);

            livingBuilding.setRooms(roomFabric.getBasicRooms(livingBuilding));

            livingBuildings.add(livingBuilding);
        }
        return livingBuildings;
    }
}
