package edu.narxoz.RPG.arena;

public class ArenaOpponent {
    private String name;
    private int maxHp;
    private int hp;
    private int attackDamage;

    public ArenaOpponent(String name, int maxHp, int attackDamage) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > maxHp) {
            this.hp = maxHp;
        } else {
            this.hp = hp;
        }
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void takeDamage(int damage) {
        setHp(this.hp - damage);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "ArenaOpponent{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                "/" + maxHp +
                ", attackDamage=" + attackDamage +
                '}';
    }
}