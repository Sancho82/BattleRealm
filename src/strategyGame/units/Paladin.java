package strategyGame.units;

import strategyGame.descriptions.Descriptions;

import javax.swing.*;

public class Paladin extends Soldier {

    public Paladin(String color, Icon icon) {
        super(color, icon);
        name = "Paladin";
        prefix = "Pa";
        description = Descriptions.getPaladinDescription();
        MAX_HP = 64 + (int) (Math.random() * 5 + 1);
        hp = MAX_HP;
        cost = 120;
        STEPRANGE = 4;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 39 + (int) (Math.random() * 10 + 1);
    }
}
