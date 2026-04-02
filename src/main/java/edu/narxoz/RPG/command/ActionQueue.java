package edu.narxoz.RPG.command;

import java.util.ArrayList;
import java.util.List;

public class ActionQueue {
    private List<ActionCommand> queue;

    public ActionQueue() {
        queue = new ArrayList<ActionCommand>();
    }

    public void enqueue(ActionCommand command) {
        queue.add(command);
        System.out.println(command.getName() + " added to queue.");
    }

    public void undoLast() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Nothing to undo.");
            return;
        }

        ActionCommand removed = queue.remove(queue.size() - 1);
        System.out.println(removed.getName() + " removed from queue before execution.");
    }

    public void executeAll() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Nothing to execute.");
            return;
        }

        System.out.println("Executing all queued commands...");

        for (int i = 0; i < queue.size(); i++) {
            queue.get(i).execute();
        }

        queue.clear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}