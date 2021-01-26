package project.bulding;

public class Thing {
    private String name;
    private ThingType thingType;

    public Thing(String name1, ThingType thingType1) {
        name = name1;
        thingType = thingType1;
    }

    public ThingType getThingType() {
        return thingType;
    }

    public void setThingType(ThingType thingType) {
        this.thingType = thingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
