package strategyGame.units;

import javax.swing.*;

public class Archer extends Soldier {

    public Archer(String color, Icon icon) {
        super(color, icon);
        name = "Archer";
        prefix = "Ar";
        MAX_HP = 24 + (int)(Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 70;
        STEPRANGE = 1;
        steppesLeft = STEPRANGE;
        attackRange = 4;
        damage = 34 + (int)(Math.random() * 5 + 1);

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Archer_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Archer_Blue.png")); }
    }
}
