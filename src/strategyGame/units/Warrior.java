package strategyGame.units;

import javax.swing.*;

public class Warrior extends Soldier {

    public Warrior(String color) {
        super(color);
        name = "Warrior";
        prefix = "Wr";
        icon = new ImageIcon(getClass().getResource("../icons/Warrior_Rnd.png"));
        MAX_HP = 35 + (int)(Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        STEPRANGE = 7;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 15 + (int)(Math.random() * 10 + 1);
    }
}
