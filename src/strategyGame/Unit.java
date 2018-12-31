package strategyGame;

public class Unit {

    protected String owner;
    protected String name;
    protected char prefix;
    protected int MAX_HP;
    protected int hp;
    protected int cost;
    protected boolean isInPlay = true;

    //region Getters

    public String getName() {
        return name;
    }

    public char getPrefix() {
        return prefix;
    }

    public String getOwner() {
        return owner;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getHp() {
        return hp;
    }

    public int getCost() {
        return cost;
    }

    public boolean getIsInPlay() {
        return isInPlay;
    }

    //endregion


    //region Setters

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void heal() {
        if (MAX_HP - hp > 0 && MAX_HP - hp < 10) {
            hp = MAX_HP;

        } else if (MAX_HP - hp > 0) {
            hp += 10;
        }
    }

    public void kill() {
        isInPlay = false;
    }

    //endregion

}
