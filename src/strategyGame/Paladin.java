package strategyGame;

public class Paladin extends Unit implements Attacker, Mobile {

    private static int STEPRANGE = 3;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Paladin(String color, int x, int y) {
        super(color, x, y);
        name = "Paladin";
        prefix = "Pu";
        MAX_HP = 65 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 90;
        attackRange = 1;
        damage = 35 + (int)(Math.random() * 10 + 1);;
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
    public void Attack(Unit otherUnit) {
        otherUnit.takeDamage(this.damage);
    }

    @Override
    public void step() {
        steppesLeft--;
    }

    public void freshStart() {
        steppesLeft = STEPRANGE;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Steppes left: " + steppesLeft + " \n" +
                "Attack range: " + attackRange + " \n" +
                "Damage: " + damage;
    }
}
