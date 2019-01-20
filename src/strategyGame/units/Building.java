package strategyGame.units;

public class Building extends Unit {

    protected int createRange;

    public Building(String color) {
        super(color);
        createRange = 2;
    }

    public int getCreateRange() {
        return createRange;
    }
}
