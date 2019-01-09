package strategyGame.units;

import strategyGame.interfaces.Factory;
import strategyGame.mvp.Game;
import strategyGame.mvp.Player;

import javax.swing.*;

public class Castle extends Unit implements Factory {

    public Castle(String color, int x, int y) {
        super(color, x, y);
        name = "Castle";
        prefix = "C";
        icon = new ImageIcon(getClass().getResource("../icons/Castle_Sq.png"));
        MAX_HP = 300;
        hp = MAX_HP;
        cost = 200;

    }

    public void createMobileUnit(Player player, int positionX, int positionY) {
        Warrior warrior = new Warrior(color, positionX, positionY);
        player.addUnit(warrior);
        Game.battlefield.setUnit(warrior, warrior.position[0], warrior.position[1]);
    }

    public void createStartingUnits() {
        if (color.equals("Red")) {
            createMobileUnit(Game.redPlayer, 0, 1);
            createMobileUnit(Game.redPlayer, 1, 0);
            createMobileUnit(Game.redPlayer, 1, 1);

        } else if (color.equals("Blue")) {
            createMobileUnit(Game.bluePlayer, 8, 9);
            createMobileUnit(Game.bluePlayer, 9, 8);
            createMobileUnit(Game.bluePlayer, 8, 8);
        }
    }
}
