package edu.narxoz.RPG.chain;

import edu.narxoz.RPG.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {

    @Override
    protected int applyDefense(int damage, ArenaFighter fighter) {
        if (!fighter.isDefending()) {
            System.out.println(fighter.getName() + " is not defending, block skipped.");
            return damage;
        }

        int chance = fighter.getBlockChance();
        int roll = (int) (Math.random() * 100) + 1;

        if (roll <= chance) {
            int blockedDamage = damage / 2;
            int remainingDamage = damage - blockedDamage;

            System.out.println(fighter.getName() + " blocks part of the damage. Blocked: " + blockedDamage);
            fighter.setDefending(false);
            return remainingDamage;
        }

        System.out.println(fighter.getName() + " failed to block.");
        fighter.setDefending(false);
        return damage;
    }
}