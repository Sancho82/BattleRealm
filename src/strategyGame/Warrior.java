package strategyGame;

public class Warrior extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 2;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Warrior() {
        name = "Warrior";
        hp = 35 + (int)(Math.random() * 10 + 1);
        cost = 40;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 15 + (int)(Math.random() * 10 + 1);
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

    @Override
    public void Attack(Unit otherUnit) {
        otherUnit.takeDamage(this.damage);
    }

    @Override
    public void step() {

    }
}
