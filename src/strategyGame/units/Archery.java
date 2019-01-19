package strategyGame.units;

public class Archery extends Building {

    public Archery (String color) {
        super(color);
        name = "Archery";
        prefix = "AR";
        MAX_HP = 100;
        hp = MAX_HP;
        cost = 150;
        canMove = false;
        canAttack = false;
    }
}
