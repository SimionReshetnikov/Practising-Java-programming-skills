package model;

public class Mage extends Character {

    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    @Override
    public String getClassType() {
        return "model.Mage";
    }

    @Override
    public void validate() {
        if (mana < 50) {
            throw new IllegalStateException("model.Mage has too little mana!");
        }

        System.out.println("model.Mage validated. Mana: " + mana);
    }

    @Override
    public void equip() {
        System.out.println(name + " equip staff and robe.");
    }
}
