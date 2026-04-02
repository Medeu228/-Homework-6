package edu.narxoz.RPG.tournament;

import edu.narxoz.RPG.arena.ArenaFighter;
import edu.narxoz.RPG.arena.ArenaOpponent;
import edu.narxoz.RPG.arena.TournamentResult;
import edu.narxoz.RPG.chain.ArmorHandler;
import edu.narxoz.RPG.chain.BlockHandler;
import edu.narxoz.RPG.chain.DefenseHandler;
import edu.narxoz.RPG.chain.DodgeHandler;
import edu.narxoz.RPG.chain.HpHandler;
import edu.narxoz.RPG.command.ActionQueue;
import edu.narxoz.RPG.command.AttackCommand;
import edu.narxoz.RPG.command.DefendCommand;
import edu.narxoz.RPG.command.HealCommand;

public class TournamentEngine {

    public TournamentResult startTournament(ArenaFighter fighter, ArenaOpponent opponent) {
        int round = 1;

        while (fighter.isAlive() && opponent.isAlive()) {
            System.out.println("\n===== ROUND " + round + " =====");

            ActionQueue queue = new ActionQueue();

            if (fighter.getHp() <= fighter.getMaxHp() / 2) {
                queue.enqueue(new HealCommand(fighter, fighter.getHealPower()));
            } else {
                queue.enqueue(new AttackCommand(fighter, opponent));
            }

            queue.enqueue(new DefendCommand(fighter));

            if (round == 1) {
                queue.undoLast();
            }

            queue.executeAll();

            if (!opponent.isAlive()) {
                System.out.println(opponent.getName() + " is defeated.");
                return new TournamentResult(fighter.getName(), round, true);
            }

            System.out.println(opponent.getName() + " attacks " + fighter.getName() +
                    " for " + opponent.getAttackDamage() + " damage.");

            DefenseHandler dodge = new DodgeHandler();
            DefenseHandler block = new BlockHandler();
            DefenseHandler armor = new ArmorHandler();
            DefenseHandler hp = new HpHandler();

            dodge.setNext(block);
            block.setNext(armor);
            armor.setNext(hp);

            dodge.handle(opponent.getAttackDamage(), fighter);

            if (!fighter.isAlive()) {
                System.out.println(fighter.getName() + " is defeated.");
                return new TournamentResult(opponent.getName(), round, false);
            }

            System.out.println("Status:");
            System.out.println(fighter);
            System.out.println(opponent);

            round++;
        }

        if (fighter.isAlive()) {
            return new TournamentResult(fighter.getName(), round, true);
        } else {
            return new TournamentResult(opponent.getName(), round, false);
        }
    }
}