package edu.narxoz.RPG.command;

public interface ActionCommand {
    void execute();
    void undo();
    String getName();
}