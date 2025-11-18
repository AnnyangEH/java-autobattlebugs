package auttobattlebugs;

public class BuffAbility implements Ability {
    private final int addAtk;
    private final int addHp;

    public BuffAbility(int atk, int hp) {
        this.addAtk = atk;
        this.addHp = hp;
    }

    @Override
    public void activate(Bug self, Team ally, Team enemy) {
        ally.buffAll(addAtk, addHp);
    }
}
