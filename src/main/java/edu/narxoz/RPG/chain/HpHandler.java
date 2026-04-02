package edu.narxoz.RPG.chain;

import edu.narxoz.RPG.arena.ArenaFighter;

public class HpHandler extends DefenseHandler {

    @Override
    protected int applyDefense(int damage, ArenaFighter fighter) {
        fighter.takeDamage(damage);

        System.out.println(fighter.getName() + " takes " + damage + " damage. HP now: "
                + fighter.getHp() + "/" + fighter.getMaxHp());

        return 0;
    }
}