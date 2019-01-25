package strategyGame.units;

import javax.swing.*;

public class Archery extends Building {

    public Archery (String color) {
        super(color);
        name = "Archery";
        prefix = "AR";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 150;
        canMove = false;
        canAttack = false;
        canCreate = true;

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../icons/Archery_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../icons/Archery_Blue.png")); }
    }
}
