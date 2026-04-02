package edu.narxoz.RPG.command;

import edu.narxoz.RPG.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private ArenaFighter fighter;
    private boolean previousState;

    public DefendCommand(ArenaFighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void execute() {
        if (!fighter.isAlive()) {
            System.out.println(fighter.getName() + " cannot defend because is defeated.");
            return;
        }

        previousState = fighter.isDefending();
        fighter.setDefending(true);

        System.out.println(fighter.getName() + " is now defending.");
    }

    @Override
    public void undo() {
        fighter.setDefending(previousState);
        System.out.println("Undo: " + fighter.getName() + " defending state restored.");
    }

    @Override
    public String getName() {
        return "DefendCommand";
    }
}