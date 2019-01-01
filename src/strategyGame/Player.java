package strategyGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String color;
    private int gold;
    private boolean isPlaying;
    private List<Unit> unitList;

    public Player(String color) {
        this.color = color;
        gold = 100;
        isPlaying = false;
        unitList = new ArrayList<>();
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

    //endregion

    public void healAll(){
        int mediCampCounter = 0;
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof MediCamp) {
                mediCampCounter++;
            }
        }
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i).isAlive == true) {
                unitList.get(i).heal();
            }
        }
    }

    public void openUnits() {
        for(int i = 0; i < unitList.size(); i++) {
            unitList.get(i).setAvailable();
        }
    }

    public void closeUnits() {
        for(int i = 0; i < unitList.size(); i++) {
            unitList.get(i).setUnAvailable();
        }
    }

    public void beginTurn() {
        isPlaying = true;
        gold += 50;
        healAll();

    }
}
