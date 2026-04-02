package edu.narxoz.RPG.chain;

import edu.narxoz.RPG.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {

    @Override
    protected int applyDefense(int damage, ArenaFighter fighter) {
        int reducedDamage = damage - fighter.getArmor();

        if (reducedDamage < 0) {
            reducedDamage = 0;
        }

        System.out.println(fighter.getName() + "'s armor reduced damage by " +
                (damage - reducedDamage) + ".");

        return reducedDamage;
    }
}