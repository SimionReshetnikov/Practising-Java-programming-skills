package recruiters;

import model.Character;
import model.Mage;

public class MageRecruiter extends CharacterRecruiter {

    @Override
    public Character createCharacter(String name) {
        return new Mage(name, 70, 80);
    }
}
