package strategyGame.units;

import javax.swing.*;

public class Warrior extends Soldier {

    public Warrior(String color) {
        super(color);
        name = "Warrior";
        prefix = "Wr";
        icon = new ImageIcon(getClass().getResource("../icons/Warrior_Grey.png"));
        MAX_HP = 34 + (int)(Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        STEPRANGE = 5;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 19 + (int)(Math.random() * 10 + 1);
    }
}
