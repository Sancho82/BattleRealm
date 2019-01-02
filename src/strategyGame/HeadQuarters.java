package strategyGame;

import java.security.PublicKey;

public class HeadQuarters extends Unit{

    public HeadQuarters(String color, int x, int y) {
        super(color, x, y);
        name = "Headquarters";
        prefix = "HQ";
        MAX_HP = 300;
        hp = MAX_HP;
        cost = 200;
    }

    public void createWarrior(Player player, int positionX, int positionY) {
        Warrior warrior = new Warrior(color, positionX, positionY);
        player.addUnit(warrior);
        Game.battlefield.setUnit(warrior, warrior.position[0], warrior.position[1]);
    }

    public void createStartingUnits() {
        if (color.equals("Red")) {
            createWarrior(Game.redPlayer, 0, 1);
            createWarrior(Game.redPlayer, 1, 0);
            createWarrior(Game.redPlayer, 1, 1);

        } else if (color.equals("Blue")) {
            createWarrior(Game.bluePlayer, 8, 9);
            createWarrior(Game.bluePlayer, 9, 8);
            createWarrior(Game.bluePlayer, 8, 8);
        }
    }
}
