package strategyGame;

public class Archer extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 1;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Archer(String color) {
        super(color);
        name = "Archer";
        prefix = 'A';
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
