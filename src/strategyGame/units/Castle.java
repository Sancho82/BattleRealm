package strategyGame.units;

import strategyGame.mvp.Main;

import javax.swing.*;

public class Castle extends Building {

    public Castle(String color) {
        super(color);
        name = "Castle";
        prefix = "CT";
        icon = new ImageIcon(getClass().getResource("../icons/Castle_Sq.png"));
        MAX_HP = 300;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;
    }
}
