package strategyGame;

public class Paladin extends Unit implements Attacker, Mobile {

    private static int STEPRANGE = 3;
    private int steppesLeft;
    private int attackRange;
    private int damage;

    Paladin() {
        owner = null;
        name = "Paladin";
        prefix = 'P';
        MAX_HP = 65 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 90;
        attackRange = 1;
        damage = 35 + (int)(Math.random() * 10 + 1);;
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
