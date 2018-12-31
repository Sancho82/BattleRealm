package strategyGame;

public class Cell {

    private boolean isOccupied = false;
    private Unit unit = null;

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void changeOccupancy() {
        if (!this.isOccupied) {
            isOccupied = true;
        } else {
            isOccupied = false;
        }
    }
}
