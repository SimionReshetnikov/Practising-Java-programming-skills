package recruiters;
import model.Character;

public abstract class CharacterRecruiter {

    private static int recruitedCount = 0;

    //Фабричный метод
    protected abstract Character createCharacter(String name);

    //Шаблонный метод
    public final void recruit(String name) {

        Character character;
        try {
            character = createCharacter(name);
            character.validate();
        } catch (IllegalStateException ex) {
            System.out.println("Recruitment failed: " + ex.getMessage());
            return;
        }

        character.equip();
        character.joinSquad();
        character.announceReady();

        recruitedCount++;
        System.out.println("Recruited: " + character.getClassType());
        System.out.println("---");
    }

    public static int getRecruitedCount() {
        return recruitedCount;
    }

    public static CharacterRecruiter forClass(String classType) {
        return switch (classType.toLowerCase()) {
            case "warrior" -> new WarriorRecruited();
            case "mage" -> new MageRecruiter();
            case "archer" -> new ArcherRecruiter();
            default -> throw new IllegalArgumentException("Unknow class: " + classType);
        };
    }
}
