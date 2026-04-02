package edu.narxoz.RPG.command;

import edu.narxoz.RPG.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private ArenaFighter fighter;
    private int healAmount;
    private int actualHeal;

    public HealCommand(ArenaFighter fighter, int healAmount) {
        this.fighter = fighter;
        this.healAmount = healAmount;
        this.actualHeal = 0;
    }

    @Override
    public void execute() {
        if (!fighter.isAlive()) {
            System.out.println(fighter.getName() + " cannot heal because is defeated.");
            return;
        }

        int oldHp = fighter.getHp();
        fighter.heal(healAmount);
        actualHeal = fighter.getHp() - oldHp;

        System.out.println(fighter.getName() + " heals for " + actualHeal + " HP.");
    }

    @Override
    public void undo() {
        if (actualHeal > 0) {
            fighter.setHp(fighter.getHp() - actualHeal);
            System.out.println("Undo: removed " + actualHeal + " healed HP from " + fighter.getName() + ".");
            actualHeal = 0;
        }
    }

    @Override
    public String getName() {
        return "HealCommand";
    }
}