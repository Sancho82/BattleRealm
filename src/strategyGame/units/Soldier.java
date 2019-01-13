package strategyGame.units;


public class Soldier extends Unit {

    protected static int STEPRANGE;
    protected int steppesLeft;
    protected int attackRange;
    protected int damage;

    public Soldier(String color) {
        super(color);
        canMove = true;
        canAttack = true;
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

    //endregion

    //region Setters

    public void reduceSteppes(int number) {
        if (steppesLeft >= number) {
            steppesLeft -= number;
        }
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
