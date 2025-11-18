package auttobattlebugs;

public class Bug {
    private final String name;
    private int damage;
    private int health;
    private final Trigger trigger;
    private final Ability ability;

    public Bug(String name, int damage, int health,
        Trigger trigger, Ability ability) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.trigger = trigger;
        this.ability = ability;
    }

    public Bug(String name, int damage, int health) {
        this(name, damage, health, Trigger.NONE, Ability.NONE);
    }

    public boolean hasTrigger(Trigger t) {
        return trigger == t;
    }

    public Ability getAbility() {
        return ability;
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
