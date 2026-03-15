package edu.narxoz.RPG;

import edu.narxoz.RPG.decorator.Attack;
import edu.narxoz.RPG.decorator.BasicAttack;
import edu.narxoz.RPG.decorator.CriticalAttackDecorator;
import edu.narxoz.RPG.decorator.FireAttackDecorator;
import edu.narxoz.RPG.decorator.PoisonAttackDecorator;
import edu.narxoz.RPG.enemy.Enemy;
import edu.narxoz.RPG.facade.DungeonFacade;
import edu.narxoz.RPg.hero.Hero;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero("Knight", 100);
        Enemy enemy = new Enemy("Skeleton King", 120);

        Attack basicAttack = new BasicAttack();
        Attack fireAttack = new FireAttackDecorator(new BasicAttack());
        Attack criticalAttack = new CriticalAttackDecorator(new BasicAttack());
        Attack comboAttack = new PoisonAttackDecorator(
                new FireAttackDecorator(
                        new CriticalAttackDecorator(
                                new BasicAttack()
                        )
                )
        );

        System.out.println("=== DECORATOR DEMO ===");
        basicAttack.execute(hero.getName(), enemy.getName());
        System.out.println();

        fireAttack.execute(hero.getName(), enemy.getName());
        System.out.println();

        criticalAttack.execute(hero.getName(), enemy.getName());
        System.out.println();

        comboAttack.execute(hero.getName(), enemy.getName());
        System.out.println();

        System.out.println("=== FACADE DEMO ===");
        DungeonFacade dungeonFacade = new DungeonFacade();
        dungeonFacade.runDungeon(hero, enemy, comboAttack);
    }
}