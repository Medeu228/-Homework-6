package edu.narxoz.RPG.command;

import edu.narxoz.RPG.arena.ArenaFighter;
import edu.narxoz.RPG.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {
    private ArenaFighter fighter;
    private ArenaOpponent opponent;
    private int damageDone;

    public AttackCommand(ArenaFighter fighter, ArenaOpponent opponent) {
        this.fighter = fighter;
        this.opponent = opponent;
        this.damageDone = 0;
    }

    @Override
    public void execute() {
        if (!fighter.isAlive()) {
            System.out.println(fighter.getName() + " cannot attack because is defeated.");
            return;
        }

        if (!opponent.isAlive()) {
            System.out.println(opponent.getName() + " is already defeated.");
            return;
        }

        damageDone = fighter.getAttackDamage();
        opponent.takeDamage(damageDone);

        System.out.println(fighter.getName() + " attacks " + opponent.getName() +
                " for " + damageDone + " damage.");
    }

    @Override
    public void undo() {
        if (damageDone > 0) {
            opponent.setHp(opponent.getHp() + damageDone);
            System.out.println("Undo: restored " + damageDone + " HP to " + opponent.getName() + ".");
            damageDone = 0;
        }
    }

    @Override
    public String getName() {
        return "AttackCommand";
    }
}