package strategyGame.units;

public class Warrior extends Soldier {

    Warrior(String color, int x, int y) {
        super(color, x, y);
        name = "Warrior";
        prefix = "Wu";
        MAX_HP = 35 + (int)(Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        STEPRANGE = 2;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 15 + (int)(Math.random() * 10 + 1);
    }
}
