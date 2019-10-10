package strategyGame.units;

import javax.swing.*;

public class Stables extends Building {

    public Stables(String color, Icon icon) {
        super(color, icon);
        name = "Stables";
        prefix = "ST";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;
    }
}
