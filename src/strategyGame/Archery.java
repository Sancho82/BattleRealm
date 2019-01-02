package strategyGame;

public class Archery extends Unit{

    public Archery (String color, int x, int y) {
        super(color, x, y);
        name = "Archery";
        prefix = "AR";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 150;
    }
}
