package strategyGame;

import java.security.PublicKey;

public class HeadQuarters extends Unit{

    public HeadQuarters(String color) {
        super(color);
        name = "Headquarters";
        prefix = 'H';
        MAX_HP = 300;
        hp = MAX_HP;
        cost = 200;
    }
}
