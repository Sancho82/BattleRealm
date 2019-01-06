package strategyGame;

public class Paladin extends Soldier {

    Paladin(String color, int x, int y) {
        super(color, x, y);
        name = "Paladin";
        prefix = "Pu";
        MAX_HP = 65 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 90;
        STEPRANGE = 3;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 35 + (int)(Math.random() * 10 + 1);;
    }
}
