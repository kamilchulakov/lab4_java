package project.database;

import project.bulding.LivingBuilding;
import project.bulding.Location;
import project.bulding.Building;
import project.bulding.Street;
import project.character.Character;
import project.character.Mumrik;
import project.character.Troll;

import java.util.ArrayList;

public class Database {
    private ArrayList<Character> characters;
    private ArrayList<Building> buildings;
    private ArrayList<Street> streets;
    private ArrayList<Location> locations;

    public Database() {
        addBasicLocations();
        addBasicStreets();
        addBasicCharacters();
        addBasicBuildings();
    }

    public ArrayList<Character> getCharacters() {
        if (characters == null) throw new NoCharactersError();
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void addBasicLocations() {
        locations = new ArrayList<>();
        locations.add(Location.MOMMIE_DOL);
        locations.add(Location.LAKE);
    }

    public void addBasicStreets() {
        streets = new ArrayList<>();
        StreetsFabric streetsFabric = new StreetsFabric();
        for (Location location: locations) streets.addAll(streetsFabric.getStreetsForLocation(location, 3));
    }

    public void addBasicBuildings() {
        buildings = new ArrayList<>();
        BuildingsFabric buildingsFabric = new BuildingsFabric();
        buildings.addAll(buildingsFabric.getLivingBuildings(streets.get(0), characters.size()));
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).setHomeBuilding((LivingBuilding) buildings.get(i));
        }
    }

    public void addBasicCharacters() {
        characters = new ArrayList<>();
        Troll troll = new Troll("Муми-тролль");
        Troll troll1 = new Troll("Фрекен снорк");
        Mumrik mumrik = new Mumrik("Снусмумрик");
        troll.addFriend(troll1);
        troll.addFriend(mumrik);
        troll1.addFriend(troll);
        mumrik.addFriend(troll);
        characters.add(troll);
        characters.add(troll1);
        characters.add(mumrik);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public ArrayList<Street> getStreets() {
        return streets;
    }

    public void setStreets(ArrayList<Street> streets) {
        this.streets = streets;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location>  locations) {
        this.locations = locations;
    }
}
