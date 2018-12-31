package strategyGame;

public class Unit {

    protected String name;
    protected int hp;
    protected int cost;
    protected boolean isInPlay = true;

    //region Getters

    public String getName() {
        return name;
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

    public void kill() {
        isInPlay = false;
    }

    //endregion

}
