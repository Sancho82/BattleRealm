package strategyGame.units;

import javax.swing.*;

public class Building extends Unit {

    protected int createRange;

    public Building(String color, Icon icon) {
        super(color, icon);
        createRange = 2;
    }

    public int getCreateRange() {
        return createRange;
    }
}
