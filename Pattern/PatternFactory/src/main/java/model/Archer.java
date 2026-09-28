package model;

public class Archer extends Character {

    private int agility;

    public Archer(String name, int health, int agility) {
        super(name, health);
        this.agility = agility;
    }

    @Override
    public String getClassType() {
        return "model.Archer";
    }

    @Override
    public void validate() {
        if (agility < 15) {
            throw new IllegalStateException("model.Archer to clumsy!");
        }
        System.out.println("model.Archer validated. Agility: " + agility);
    }

    @Override
    public void equip() {
        System.out.println(name + " equips bow and quiver.");
    }
}
