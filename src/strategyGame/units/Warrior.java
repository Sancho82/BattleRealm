package strategyGame.units;

import javax.swing.*;

public class Warrior extends Soldier {

    public Warrior(String color, Icon icon) {
        super(color, icon);
        name = "Warrior";
        prefix = "Wr";
        MAX_HP = 34 + (int)(Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        STEPRANGE = 2;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 19 + (int)(Math.random() * 10 + 1);

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Warrior_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../pictures/icons/Warrior_Blue.png")); }
    }
}
