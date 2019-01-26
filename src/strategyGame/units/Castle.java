package strategyGame.units;

import strategyGame.mvp.Main;

import javax.swing.*;

public class Castle extends Building {

    public Castle(String color) {
        super(color);
        name = "Castle";
        prefix = "CT";
        MAX_HP = 150;
        hp = MAX_HP;
        cost = 200;
        canMove = false;
        canAttack = false;
        canCreate = true;

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../icons/Castle_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../icons/Castle_Blue.png")); }
    }
}
