package strategyGame;

public class Archer extends Unit implements Attacker, Mobile{

    private static int STEPRANGE = 1;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Archer() {
        owner = null;
        name = "Archer";
        prefix = 'A';
        MAX_HP = 25 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
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
        steppesLeft--;
    }

    public void freshStart() {
        steppesLeft = STEPRANGE;
    }
}
