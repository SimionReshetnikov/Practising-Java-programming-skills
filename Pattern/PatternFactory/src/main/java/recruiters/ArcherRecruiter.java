package recruiters;

import model.Archer;
import model.Character;

public class ArcherRecruiter extends CharacterRecruiter {

    @Override
    public Character createCharacter(String name) {
        return new Archer(name, 80, 20);
    }
}
