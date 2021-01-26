package project.database;

import project.bulding.Building;
import project.bulding.Room;

import java.util.ArrayList;

public class RoomFabric {
    public Room[] getBasicRooms(Building building) {
        Room[] rooms = new Room[3];

        Room room0 = new Room(building,"спальня");
        Room room1 = new Room(building, "кухня");
        Room room2 = new Room(building, "ванная");

        rooms[0] = room0;
        rooms[1] = room1;
        rooms[2] = room2;
        return rooms;
    }
}
