package strategyGame.mvp;

import strategyGame.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private String color;
    private int gold;
    private List<Unit> unitList;

    public Player(String color) {
        this.name = "Opponent";
        this.color = color;
        gold = 1450;
        unitList = new ArrayList<>();
    }

    //region Getters

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getGold() {
        return gold;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    //endregion


    //region Setters

    public void setName(String name) {
        this.name = name;
    }

    public void addToUnitList(Unit unit) {
        unitList.add(unit);
    }

    public void removeFromUnitList(Unit unit) {
        unitList.remove(unit);
    }

    public void increaseGold() {
        gold += 50;
    }

    public void deCreaseGold(int cost) {
        gold -= cost;
    }

    //endregion

    public String toString() {
        return "<html><font color=white><Strong>Name:&nbsp</Strong></font>" + name + "<br>" +
                "<font color=white><Strong>Color:&nbsp</Strong></font>" + color + "<br>" +
                "<font color=white><Strong>Gold:&nbsp</Strong></font>" + gold + "<br>" +
                "</html>";
    }
}
