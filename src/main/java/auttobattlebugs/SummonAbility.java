package auttobattlebugs;

public class SummonAbility implements Ability {
    private final BugType type;

    public SummonAbility(BugType type) {
        this.type = type;
    }

    @Override
    public void activate(Bug self, Team ally, Team enemy) {
        ally.addToFront(BugFactory.create(type));
    }
}