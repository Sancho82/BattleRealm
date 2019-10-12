package strategyGame.units;

import strategyGame.descriptions.Descriptions;

import javax.swing.*;

public class Castle extends Building {

    public Castle(String color, Icon icon) {
        super(color, icon);
        name = "Castle";
        prefix = "CT";
        description = Descriptions.getCastleDescription();
        MAX_HP = 150;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;
    }
}
