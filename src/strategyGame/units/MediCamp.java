package strategyGame.units;

import strategyGame.mvp.Player;
import strategyGame.interfaces.Healer;

public class MediCamp extends Unit implements Healer {

    MediCamp(String color, int x, int y) {
        super(color, x, y);
        name = "MediCamp";
        prefix = "MC";
        MAX_HP = 80;
        hp = MAX_HP;
        cost = 150;
    }

    public void heal(Player player){
        for (int i = 0; i < player.getUnitList().size(); i++) {
            player.getUnitList().get(i).heal();
        }
    }
}
