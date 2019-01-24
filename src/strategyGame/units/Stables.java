package strategyGame.units;

import javax.swing.*;

public class Stables extends Building {

    public Stables (String color) {
        super(color);
        name = "Stables";
        prefix = "ST";
        icon = new ImageIcon(getClass().getResource("../icons/Stables_Grey.png"));
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;
    }
}
