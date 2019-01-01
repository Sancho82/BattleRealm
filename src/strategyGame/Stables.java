package strategyGame;

public class Stables extends Unit{

    public Stables (String color) {
        super(color);
        name = "Stables";
        prefix = '+';
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 200;
    }
}
