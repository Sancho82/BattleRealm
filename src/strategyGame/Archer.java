package strategyGame;

public class Archer extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 1;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Archer(String color, int x, int y) {
        super(color, x, y);
        name = "Archer";
        prefix = "Au";
        MAX_HP = 25 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 70;
        attackRange = 4;
        damage = 35 + (int)(Math.random() * 5 + 1);
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
