package edu.narxoz.RPG;

import edu.narxoz.RPG.arena.ArenaFighter;
import edu.narxoz.RPG.arena.ArenaOpponent;
import edu.narxoz.RPG.arena.TournamentResult;
import edu.narxoz.RPG.tournament.TournamentEngine;

public class Main {
    public static void main(String[] args) {

        // example fighting

        ArenaFighter fighter = new ArenaFighter(
                "Knight",
                100,
                20,
                5,
                15,
                20,
                50
        );

        ArenaOpponent opponent = new ArenaOpponent(
                "Orc",
                90,
                18
        );

        TournamentEngine engine = new TournamentEngine();
        TournamentResult result = engine.startTournament(fighter, opponent);

        System.out.println("\n===== TOURNAMENT RESULT =====");
        System.out.println(result);
    }
}