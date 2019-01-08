package strategyGame.units;

public class Archer extends Soldier {

    Archer(String color, int x, int y) {
        super(color, x, y);
        name = "Archer";
        prefix = "Au";
        MAX_HP = 25 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 70;
        STEPRANGE = 1;
        steppesLeft = STEPRANGE;
        attackRange = 4;
        damage = 35 + (int)(Math.random() * 5 + 1);
    }
}
