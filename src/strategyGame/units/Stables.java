package strategyGame.units;

import javax.swing.*;

public class Stables extends Building {

    public Stables (String color) {
        super(color);
        name = "Stables";
        prefix = "ST";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../icons/Stables_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../icons/Stables_Blue.png")); }
    }
}
