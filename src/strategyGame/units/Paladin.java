package strategyGame.units;

import javax.swing.*;

public class Paladin extends Soldier {

    public Paladin(String color) {
        super(color);
        name = "Paladin";
        prefix = "Pa";
        MAX_HP = 64 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 120;
        STEPRANGE = 4;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 39 + (int)(Math.random() * 10 + 1);

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Paladin_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Paladin_Blue.png")); }
    }
}
