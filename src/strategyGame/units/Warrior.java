package strategyGame.units;

import strategyGame.descriptions.Descriptions;

import javax.swing.*;

public class Warrior extends Soldier {

    public Warrior(String color, Icon icon) {
        super(color, icon);
        name = "Warrior";
        prefix = "Wr";
        description = Descriptions.getWarriorDescription();
        MAX_HP = 34 + (int) (Math.random() * 10 + 1);
        hp = MAX_HP;
        cost = 40;
        STEPRANGE = 2;
        steppesLeft = STEPRANGE;
        attackRange = 1;
        damage = 19 + (int) (Math.random() * 10 + 1);
    }
}
