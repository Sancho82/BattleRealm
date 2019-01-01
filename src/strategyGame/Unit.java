package strategyGame;

public abstract class Unit {

    protected String color;
    protected String name;
    protected char prefix;
    protected int MAX_HP;
    protected int hp;
    protected int cost;
    protected boolean isSelected = false;
    protected boolean isAvailable = false;
    protected boolean isAlive = true;

    public Unit(String color) {
        this.color = color;
    }

    //region Getters

    public String getName() {
        return name;
    }

    public char getPrefix() {
        return prefix;
    }

    public String getColor() {
        return color;
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

    public boolean getIsSelected() {
        return isSelected;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public boolean getIsAlive() {
        return isAlive;
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

    public void setAvailable() {
        isAvailable = true;
    }

    public void setUnAvailable() {
        isAvailable = true;
    }

    public void kill() {
        isAlive = false;
    }

    //endregion

    public String toString() {
        return "Team: " + color + "\n" +
               "Unit: " + name + "\n" +
               "Hp: " + hp;
    }
}
