package auttobattlebugs;

public interface Ability {
    void activate(Bug self, Team ally, Team enemy);

    Ability NONE = (self, ally, enemy) -> {};
}
