package recruiters;

import model.Character;
import model.Warrior;

public class WarriorRecruited extends CharacterRecruiter {

    @Override
    protected Character createCharacter(String name) {
        return new Warrior(name, 100, 15);
    }
}
