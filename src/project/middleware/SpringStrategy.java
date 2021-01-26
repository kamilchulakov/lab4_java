package project.middleware;

import project.bulding.LocationException;

import java.util.List;
import project.character.Character;

public final class SpringStrategy implements Strategy {
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            try {
                character.springAction();
            } catch (LocationException differentHouseException) {
                character.dream();
            }
        }
    }
}
