package strategyGame.units;

public class Building extends Unit {

    private final int createRange;

    public Building(String color) {
        super(color);
        createRange = 2;
    }

    public int getCreateRange() {
        return createRange;
    }
}
