package edu.narxoz.RPG.chain;

import edu.narxoz.RPG.arena.ArenaFighter;

public abstract class DefenseHandler {
    protected DefenseHandler next;

    public void setNext(DefenseHandler next) {
        this.next = next;
    }

    public void handle(int damage, ArenaFighter fighter) {
        int remainingDamage = applyDefense(damage, fighter);

        if (remainingDamage > 0 && next != null) {
            next.handle(remainingDamage, fighter);
        }
    }

    protected abstract int applyDefense(int damage, ArenaFighter fighter);
}