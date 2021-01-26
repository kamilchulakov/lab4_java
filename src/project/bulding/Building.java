package project.bulding;

public abstract class Building {
    private Street street;
    private Room[] rooms;

    public Building(Street street) {
        setStreet(street);
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String toString() {
        return "Здание";
    }
}
