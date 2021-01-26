package project.bulding;

public class Street {;
    private Location location;
    private String name;

    public Street(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String toString() {
        return String.format("%s, %s", name, location);
    }
}
