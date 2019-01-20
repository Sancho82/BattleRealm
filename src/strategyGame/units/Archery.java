package strategyGame.units;

import javax.swing.*;

public class Archery extends Building {

    public Archery (String color) {
        super(color);
        name = "Archery";
        prefix = "AR";
        icon = new ImageIcon(getClass().getResource("../icons/Archery1_Sq.png"));
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 150;
        canMove = false;
        canAttack = false;
    }
}
