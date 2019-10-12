package strategyGame.units;

import strategyGame.descriptions.Descriptions;

import javax.swing.*;

public class Stables extends Building {

    public Stables(String color, Icon icon) {
        super(color, icon);
        name = "Stables";
        prefix = "ST";
        description = Descriptions.getStablesDescription();
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;
    }
}
