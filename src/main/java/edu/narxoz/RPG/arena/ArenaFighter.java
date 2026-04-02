package edu.narxoz.RPG.arena;

public class ArenaFighter {
    private String name;
    private int maxHp;
    private int hp;
    private int attackDamage;
    private int armor;
    private int healPower;

    private int dodgeChance;
    private int blockChance;
    private boolean defending;

    public ArenaFighter(String name, int maxHp, int attackDamage, int armor, int healPower, int dodgeChance, int blockChance) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackDamage = attackDamage;
        this.armor = armor;
        this.healPower = healPower;
        this.dodgeChance = dodgeChance;
        this.blockChance = blockChance;
        this.defending = false;
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

    public int getArmor() {
        return armor;
    }

    public int getHealPower() {
        return healPower;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public int getBlockChance() {
        return blockChance;
    }

    public boolean isDefending() {
        return defending;
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

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setBlockChance(int blockChance) {
        this.blockChance = blockChance;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    public void takeDamage(int damage) {
        setHp(this.hp - damage);
    }

    public void heal(int amount) {
        setHp(this.hp + amount);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "ArenaFighter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                "/" + maxHp +
                ", attackDamage=" + attackDamage +
                ", armor=" + armor +
                ", healPower=" + healPower +
                ", dodgeChance=" + dodgeChance +
                ", blockChance=" + blockChance +
                ", defending=" + defending +
                '}';
    }
}