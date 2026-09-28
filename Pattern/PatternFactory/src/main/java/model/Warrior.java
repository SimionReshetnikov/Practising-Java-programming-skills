package model;

public class Warrior extends Character {

    private int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    @Override
    public String getClassType() {
        return "model.Warrior";
    }

    @Override
    public void validate() {
        if (strength < 10) {
            throw new IllegalStateException("model.Warrior too weak!");
        }

        System.out.println("model.Warrior validated. Strength: " + strength);
    }

    @Override
    public void equip() {
        System.out.println(name + " equips sword and shield.");
    }
}
