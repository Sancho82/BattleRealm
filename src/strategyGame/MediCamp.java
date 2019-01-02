package strategyGame;

public class MediCamp extends Unit{

    MediCamp(String color, int x, int y) {
        super(color, x, y);
        name = "MediCamp";
        prefix = "MC";
        MAX_HP = 80;
        hp = MAX_HP;
        cost = 150;
    }
}
