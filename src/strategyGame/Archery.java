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

    public void createArcher(Player player, int positionX, int positionY) {
        Archer archer = new Archer(color, positionX, positionY);
        player.addUnit(archer);
        Game.battlefield.setUnit(archer, archer.position[0], archer.position[1]);
    }
}
