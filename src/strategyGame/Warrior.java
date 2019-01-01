package strategyGame;

public class Warrior extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 2;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Warrior(String color) {
        super(color);
        name = "Warrior";
        prefix = 'W';
        MAX_HP = 35 + (int)(Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 15 + (int)(Math.random() * 10 + 1);
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
                "Steppes left: " + steppesLeft + "\n" +
                "Attack range: " + attackRange + "\n" +
                "Damage: " + damage;
    }
}
