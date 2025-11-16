package auttobattlebugs;

public class Bug {
    private final String name;
    private int damage;
    private int health;

    public Bug(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void buff(int dmg, int hp) {
        damage += dmg;
        health += hp;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
