public class Unit {

    private String name;
    private int hp;
    private int cost;
    private boolean isInPlay = true;

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

    public void kill() {
        isInPlay = false;
    }

    //endregion

}
