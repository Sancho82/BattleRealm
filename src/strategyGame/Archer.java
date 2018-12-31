package strategyGame;

public class Archer extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 1;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Archer() {
        name = "Archer";
        hp = 25 + (int)(Math.random() * 5 + 1);
        cost = 70;
        attackRange = 4;
        damage = 35 + (int)(Math.random() * 5 + 1);
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
