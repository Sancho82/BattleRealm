package strategyGame;

public class MediCamp extends Unit{

    MediCamp(String color) {
        super(color);
        name = "MediCamp";
        prefix = '+';
        MAX_HP = 80;
        hp = MAX_HP;
        cost = 150;
    }
}
