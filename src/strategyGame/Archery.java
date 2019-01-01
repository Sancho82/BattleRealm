package strategyGame;

public class Archery extends Unit{

    public Archery (String color) {
        super(color);
        name = "Archery";
        prefix = '¤';
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 150;
    }
}
