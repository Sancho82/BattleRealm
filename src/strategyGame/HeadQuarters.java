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
}
