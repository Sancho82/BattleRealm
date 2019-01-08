package strategyGame.units;

import strategyGame.mvp.Game;
import strategyGame.mvp.Player;
import strategyGame.interfaces.Factory;

public class Stables extends Unit implements Factory {

    public Stables (String color, int x, int y) {
        super(color, x, y);
        name = "Stables";
        prefix = "ST";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
    }

    public void createMobileUnit(Player player, int positionX, int positionY) {
        Paladin paladin = new Paladin(color, positionX, positionY);
        player.addUnit(paladin);
        Game.battlefield.setUnit(paladin, paladin.position[0], paladin.position[1]);
    }
}