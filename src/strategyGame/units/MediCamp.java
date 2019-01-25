package strategyGame.units;

import strategyGame.mvp.Player;
import strategyGame.interfaces.Healer;

import javax.swing.*;

public class MediCamp extends Building implements Healer {

    public MediCamp(String color) {
        super(color);
        name = "MediCamp";
        prefix = "MC";
        MAX_HP = 50;
        hp = MAX_HP;
        cost = 100;
        canMove = false;
        canAttack = false;
        canCreate = false;
        createRange = 0;

        if (color.equals("Red")) { icon = new ImageIcon(getClass().getResource("../icons/Medicamp_Red.png")); }
        else if (color.equals("Blue")) { icon = new ImageIcon(getClass().getResource("../icons/Medicamp_Blue.png")); }
    }

    public void healAll(Player player){
        for (int i = 0; i < player.getUnitList().size(); i++) {
            player.getUnitList().get(i).heal();
        }
    }
}
