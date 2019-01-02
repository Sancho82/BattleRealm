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

    //region Creators

    public void createHeadQuarters(Battlefield battlefield, int positionX, int positionY) {
        HeadQuarters headQuarters = new HeadQuarters(this.color, positionX, positionY);
        unitList.add(headQuarters);
        battlefield.setUnit(headQuarters, headQuarters.position[0], headQuarters.position[1]);
    }

    public void createWarrior(Battlefield battlefield, int positionX, int positionY) {
        Warrior warrior = new Warrior(this.color, positionX, positionY);
        unitList.add(warrior);
        battlefield.setUnit(warrior, warrior.position[0], warrior.position[1]);
    }

    public void createStartingUnits(Battlefield battlefield) {
        if (color.equals("Red")) {
            createHeadQuarters(battlefield, 0, 0);
            createWarrior(battlefield, 0, 1);
            createWarrior(battlefield, 1, 0);
            createWarrior(battlefield, 1, 1);

        } else if (color.equals("Blue")) {
            createHeadQuarters(battlefield, 9, 9);
            createWarrior(battlefield, 8, 9);
            createWarrior(battlefield, 9, 8);
            createWarrior(battlefield, 8, 8);
        }
    }
    //endregion

    public void regenerate(){
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
        regenerate();

    }
}
