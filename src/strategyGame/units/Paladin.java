package strategyGame.units;

import javax.swing.*;

public class Paladin extends Soldier {

    public Paladin(String color) {
        super(color);
        name = "Paladin";
        prefix = "Pa";
        icon = new ImageIcon(getClass().getResource("../icons/Paladin_Rnd.png"));
        MAX_HP = 65 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 90;
        STEPRANGE = 3;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 35 + (int)(Math.random() * 10 + 1);
    }
}
