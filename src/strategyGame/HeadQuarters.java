package strategyGame;

import java.security.PublicKey;

public class HeadQuarters extends Unit{

    public HeadQuarters() {
        owner = null;
        name = "Headquarters";
        prefix = 'H';
        MAX_HP = 300;
        hp = MAX_HP;
        cost = 200;
    }
}
