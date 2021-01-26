package project.middleware;

import project.bulding.LocationException;

import java.util.List;
import project.character.Character;

public final class SummerStrategy implements Strategy {
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            try {
                character.randomAction();
                character.summerAction();
            } catch (LocationException differentHouseException) {
                character.dream();
            }
        }
    }
}
