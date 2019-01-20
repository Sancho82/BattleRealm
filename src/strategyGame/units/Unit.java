package strategyGame.units;

import javax.swing.*;

public abstract class Unit {

    protected String color;
    protected String name;
    protected String prefix;
    protected Icon icon;
    protected int MAX_HP;
    protected int hp;
    protected int cost;
    protected boolean isSelected;
    protected boolean isAvailable;
    protected boolean canMove;
    protected boolean canAttack;
    protected boolean canCreate;

    public Unit(String color) {
        this.color = color;
        isSelected = false;
        isAvailable = false;
    }

    //region Getters

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPrefix() {
        return prefix;
    }

    public Icon getIcon() {
        return icon;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getHp() {
        return hp;
    }

    public int getCost() {
        return cost;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public boolean getCanCreate() {
        return canCreate;
    }

    //endregion


    //region Setters

    public void heal() {
        if (MAX_HP - hp > 0 && MAX_HP - hp < 10) {
            hp = MAX_HP;

        } else if (MAX_HP - hp > 0) {
            hp += 10;
        }
    }

    public void setAvailable() {
        isAvailable = true;
    }

    public void setUnAvailable() {
        isAvailable = false;
    }

    public void select() {
        isSelected = true;
    }

    public void deselect() {
        isSelected = false;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void removeIcon() {
        icon = null;
    }

    //endregion

    public String toString() {
        return "<html><font color=white><Strong>Team:&nbsp</Strong></font>" + color + "<br>" +
                "<font color=white><Strong>Name:&nbsp</Strong></font>" + name + "<br>" +
                "<font color=white><Strong>Hp:&nbsp</Strong></font>" + hp +
                "</html>";
    }
}
