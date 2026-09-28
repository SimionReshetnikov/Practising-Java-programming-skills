package model;

public abstract class Character {

    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract String getClassType();
    public abstract void validate();
    public abstract void equip();

    public void joinSquad() {
        System.out.println(name + " joined the squad.");
    }

    public void announceReady() {
        System.out.println(name + " the " + getClassType() + " is ready!");
    }
}
