package project.character;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import project.bulding.*;

public abstract class Character {
    private String name;
    private ArrayList<Character> friends = new ArrayList<>();
    private int happiness = 0;
    private Location location;
    private String sex = "male";
    private LivingBuilding homeBuilding;
    private Building currentBuilding;
    private boolean inHouse = true;

    protected Character(String name) {
        this(Location.MOMMIE_DOL, name);
    }

    protected Character() {
        this(Location.MOMMIE_DOL,"Character");
    }

    protected Character(Location location, String name) {
        setName(name);
        setLocation(location);
    }

    public ArrayList<Character> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Character> friends) {
        this.friends = friends;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public LivingBuilding getHomeBuilding() {
        return homeBuilding;
    }

    public void setHomeBuilding(LivingBuilding homeBuilding) {
        this.homeBuilding = homeBuilding;
        setCurrentBuilding(homeBuilding);
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }

    public void setCurrentBuilding(Building currentBuilding) {
        this.currentBuilding = currentBuilding;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFriend(Character character) {
        this.friends.add(character);
    }

    public Character getFriend(int position) {
        return friends.get(position);
    }

    public void visitRandomFriend() {
        Character character = getRandomFriend();
        System.out.printf("%s решил встретиться с %s.%n", getName(), character.getName());
        if (!character.getCurrentBuilding().equals(getCurrentBuilding())) {
            visitBuilding(character.getCurrentBuilding());
        }
        else System.out.println("Но для встречи с другом никуда не пришлось идти!");
    }

    public void visitBuilding(Building building) {
        if (inHouse) goInOut();
        goToStreet(building.getStreet());
        setCurrentBuilding(building);
        goInOut();
        if ((int) (Math.random() * 5) > 3) exploreCurrentBuilding();
    }

    public void goToStreet(Street street) {
        System.out.printf("%s решил прогуляться до %s.%n", getName(), street.toString());
    }

    public void exploreCurrentBuilding() {
        System.out.printf("%s решил исследовать текущее здание.%n", getName());
        Room[] rooms = getCurrentBuilding().getRooms();
        for (Room room: rooms) {
            ArrayList<Furniture> furnitures = room.getFurnitures();
            for (Furniture furniture: furnitures) {
                System.out.printf("%s обнаружил %s.%n",getName(), furniture);
                if (furniture.getName().equals("унитаз")) makePoo();
                ArrayList<Thing> things = furniture.getThings();
                if (things.size() > 0) {
                    for (Thing thing: things) {
                        System.out.printf("%s нашёл на %s %s.%n", getName(), furniture, thing.getName());
                        if (thing.getThingType().equals(ThingType.DRINK)) {
                            // лучше бы Thing,type использовал!!
                            System.out.printf("%s выпил %s.%n", getName(), thing.getName());
                            things.remove(thing);
                        }
                        else if (thing.getThingType().equals(ThingType.FOOD)) {
                            System.out.printf("%s съел %s.%n", getName(), thing.getName());
                            things.remove(thing);
                        }
                        else if (thing.getThingType().equals(ThingType.TOY)) {
                            System.out.printf("%s поиграл с %s.%n", getName(), thing.getName());
                        }
                    }
                }
            }
        }
    }

    public void goInOut() {
        if (inHouse) {
            System.out.print(getName() + " вышел из ");
            inHouse = false;
        }
        else {
            System.out.print(getName() + " зашёл в ");
            inHouse = true;
        }
        System.out.println(getCurrentBuilding() + ".");
    }

    public Character getRandomFriend() {
        Random random = new Random();
        return friends.get(random.nextInt(friends.size()));
    }

    public void setLocation(Location location) {
        this.location = location;
        //System.out.printf("Место нахождения %s изменилось на %s!%n", getName(), getLocation());
    }

    public Location getLocation() {
        return location;
    }

    public void setSex(String sex1) {
        sex = sex1;
    }

    public String getSex() {
        return sex;
    }

    private void makePoo() {
        System.out.println(getName() + " использовал унитаз по назначению.");
    }

    public int getHappiness() {
        return happiness;
    }

    public void modHappiness(int happy) {
        int before = getHappiness();
        happiness += happy;
        if (happiness > before) System.out.printf("У %s улучшилось настроение!%n", getName());
        else if (happiness < before) System.out.printf("У %s ухудшилось настроение!%n", getName());
    }

    public void dream() {
        if (getSex().equals("female")) System.out.println(getName() + " мечтательно задумалась на долгое время.");
        else System.out.println(getName() + " мечтательно задумался на долгое время.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return happiness == character.happiness &&
                Objects.equals(name, character.name) &&
                Objects.equals(friends, character.friends) &&
                Objects.equals(sex, character.sex);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, friends, happiness, sex);
    }

    public abstract void winterAction();

    public abstract void springAction() throws LocationException;

    public abstract void summerAction();

    public abstract void autumnAction();

    public abstract void randomAction() throws LocationException;
}