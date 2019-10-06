package strategyGame.units;


import javax.swing.*;

public class Soldier extends Unit {

    protected int STEPRANGE;
    protected int steppesLeft;
    protected int attackRange;
    protected int damage;
    protected boolean hasAttacked;

    public Soldier(String color, Icon icon) {
        super(color, icon);
        canMove = true;
        canAttack = true;
        hasAttacked = false;
    }

    //region Getters

    public int getSTEPRANGE() {
        return STEPRANGE;
    }

    public int getSteppesLeft() {
        return steppesLeft;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getDamage() {
        return damage;
    }

    public boolean getHasAttacked() {
        return hasAttacked;
    }

    //endregion

    //region Setters

    public void reduceSteppes(int number) {
        if (steppesLeft >= number) {
            steppesLeft -= number;
        }
    }

    public void useAttack() {
        hasAttacked = true;
    }

    public void freshStart() {
        steppesLeft = STEPRANGE;
        hasAttacked = false;
    }
    //endregion

    public String toString() {
        return "<html><font color=white><Strong>Team:&nbsp</Strong></font>" + color + "<br>" +
                "<font color=white><Strong>Name:&nbsp</Strong></font>" + name + "<br>" +
                "<font color=white><Strong>Hp:&nbsp</Strong></font>" + hp + "<br>" +
                "<font color=white><Strong>Damage:&nbsp</Strong></font>" + damage + "<br>" +
                "<font color=white><Strong>Attack Range:&nbsp</Strong></font>" + attackRange + "<br>" +
                "<font color=white><Strong>Steppes Left:&nbsp</Strong></font>" + steppesLeft +
                "</html>";
    }
}
