package edu.narxoz.RPG.chain;

import edu.narxoz.RPG.arena.ArenaFighter;

public class DodgeHandler extends DefenseHandler {

    @Override
    protected int applyDefense(int damage, ArenaFighter fighter) {
        int chance = fighter.getDodgeChance();
        int roll = (int) (Math.random() * 100) + 1;

        if (roll <= chance) {
            System.out.println(fighter.getName() + " dodged the attack.");
            return 0;
        }

        System.out.println(fighter.getName() + " failed to dodge.");
        return damage;
    }
}