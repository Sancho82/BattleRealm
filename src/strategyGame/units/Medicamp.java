package strategyGame.units;

import strategyGame.descriptions.Descriptions;
import strategyGame.mvp.Player;
import strategyGame.interfaces.Healer;

import javax.swing.*;

public class Medicamp extends Building implements Healer {

    public Medicamp(String color, Icon icon) {
        super(color, icon);
        name = "Medicamp";
        prefix = "MC";
        description = Descriptions.getMedicampDescription();
        MAX_HP = 50;
        hp = MAX_HP;
        cost = 100;
        canMove = false;
        canAttack = false;
        canCreate = false;
        createRange = 0;
    }

    public void healAll(Player player) {
        for (int i = 0; i < player.getUnitList().size(); i++) {
            player.getUnitList().get(i).heal();
        }
    }
}
