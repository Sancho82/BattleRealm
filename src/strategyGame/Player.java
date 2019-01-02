package strategyGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String color;
    private int gold;
    private boolean isPlaying;
    private List<Unit> unitList;
    private HeadQuarters headQuarters;

    public Player(String color) {
        this.color = color;
        gold = 100;
        isPlaying = false;
        unitList = new ArrayList<>();
        createHeadQuarters();
    }

    //region Getters

    public String getColor() {
        return color;
    }

    public int getGold() {
        return gold;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public HeadQuarters getHeadQuarters() {
        return headQuarters;
    }

    //endregion

    //region Creators

    public void createHeadQuarters() {
        if (color.equals("Red")) {
            headQuarters = new HeadQuarters(color, 0, 0);
            unitList.add(headQuarters);
            Game.battlefield.setUnit(headQuarters, headQuarters.position[0], headQuarters.position[1]);

        } else if (color.equals("Blue")) {
            headQuarters = new HeadQuarters(color, 9, 9);
            unitList.add(headQuarters);
            Game.battlefield.setUnit(headQuarters, headQuarters.position[0], headQuarters.position[1]);
        }
    }

    //endregion

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public void openUnits() {
        for (int i = 0; i < unitList.size(); i++) {
            unitList.get(i).setAvailable();
        }
    }

    public void closeUnits() {
        for(int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof MediCamp) {
                ((MediCamp) unitList.get(i)).healAll(this);
                unitList.get(i).setUnAvailable();

            } else {
                unitList.get(i).setUnAvailable();
            }
        }
    }

    public void beginTurn() {
        isPlaying = true;
        gold += 50;
    }

    public void  endTurn() {

    }
}
