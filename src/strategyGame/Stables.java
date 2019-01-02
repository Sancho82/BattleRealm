package strategyGame;

public class Stables extends Unit{

    public Stables (String color, int x, int y) {
        super(color, x, y);
        name = "Stables";
        prefix = "ST";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
    }
}
