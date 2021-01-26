package project.bulding;

public class Furniture {
    private Thing[] things;
    private String name;

    public Furniture(String name) {
        this.name = name;
    }

    public Thing[] getThings() {
        return things;
    }

    public void setThings(Thing[] things) {
        this.things = things;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}