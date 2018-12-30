public class Cell {

    private String name = "E";
    private boolean isOccupied = false;
    private Unit unit = null;

    public String getName() {
        return name;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Unit getUnit() {
        return unit;
    }

    public void changeOccupancy() {
        if (!this.isOccupied) {
            isOccupied = true;
        } else {
            isOccupied = false;
        }
    }
}
