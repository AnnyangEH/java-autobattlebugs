package auttobattlebugs;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Bug> bugs = new ArrayList<>();

    public void add(Bug bug) {
        bugs.add(bug);
    }

    public void addToFront(Bug bug) {
        bugs.add(0, bug);
    }

    public Bug getFrontAlive() {
        return bugs.stream()
            .filter(Bug::isAlive)
            .findFirst()
            .orElse(null);
    }

    public void buffAll(int atk, int hp) {
        for (Bug bug : bugs) {
            bug.buff(atk, hp);
        }
    }

    public int size() {
        return bugs.size();
    }

    public List<Bug> getAll() {
        return bugs;
    }
}
