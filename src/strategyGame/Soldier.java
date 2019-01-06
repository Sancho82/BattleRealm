package strategyGame;

public class Soldier extends Unit implements Mobile, Attacker {
    protected static int STEPRANGE;
    protected int steppesLeft;
    protected int attackRange;
    protected int damage;

    Soldier(String color, int x, int y) {
        super(color, x, y);
    }

    //region Getters

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

    @Override
    public void attack(Unit otherUnit) {
        otherUnit.hp -= damage;
    }

    @Override
    public void step() {
        steppesLeft--;
    }

    public void freshStart() {
        steppesLeft = STEPRANGE;
    }

    //steppesLeft, attackRange, damage
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
