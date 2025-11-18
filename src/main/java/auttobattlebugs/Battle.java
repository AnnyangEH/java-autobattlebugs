package auttobattlebugs;

public class Battle {
    private final Team a;
    private final Team b;

    public Battle(Team a, Team b) {
        this.a = a;
        this.b = b;
    }

    public Team getFirstAttacker() {
        int aVanguardStat = a.getFrontAlive().getDamage() + a.getFrontAlive().getHealth();
        int bVanguardStat = b.getFrontAlive().getDamage() + b.getFrontAlive().getHealth();

        if (aVanguardStat > bVanguardStat) return a;
        if (bVanguardStat > aVanguardStat) return b;

        return a; // 임시 동률 처리 나중에 랜덤 추가 필요
    }

    public void exchangeOnce() {
        Bug aBug = a.getFrontAlive();
        Bug bBug = b.getFrontAlive();

        int aDamage = aBug.getDamage();
        int bDamage = bBug.getDamage();

        bBug.takeDamage(aDamage);
        aBug.takeDamage(bDamage);
    }

    public void triggerFaint(Bug bug, Team ally, Team enemy) {
        if (!bug.isAlive() && bug.hasTrigger(Trigger.ON_FAINT)) {
            bug.getAbility().activate(bug, ally, enemy);
        }
    }

    public void triggerAllFaint(Team team) {
        for (Bug bug : team.getAll()) {
            if (!bug.isAlive() && bug.hasTrigger(Trigger.ON_FAINT)) {
                bug.getAbility().activate(bug, team, null);
            }
        }
    }

    public void postExchange() {
        handleFaint(a);
        handleFaint(b);
    }

    private void handleFaint(Team team) {
        Bug front = team.getFrontAlive();
        if (front != null && !front.isAlive()) {
        }
    }
}
