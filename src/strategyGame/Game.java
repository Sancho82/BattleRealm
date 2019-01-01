package strategyGame;

public class Game {

    private static Player redPlayer = new Player("Red");
    private static Player bluePlayer = new Player("Blue");
    private static Battlefield battlefield = new Battlefield();

    public static void main(String[] args) {

        battlefield.setVisible(true);
        battlefield.getTable().matrixDisplayer();
    }

    public static void setPlayerStarterTeams() {
        redPlayer.getUnitList().add(new Warrior("Red"));
        redPlayer.getUnitList().add(new Warrior("Red"));
        redPlayer.getUnitList().add(new Warrior("Red"));
        redPlayer.getUnitList().add(new HeadQuarters("Red"));

        bluePlayer.getUnitList().add(new Warrior("Blue"));
        bluePlayer.getUnitList().add(new Warrior("Blue"));
        bluePlayer.getUnitList().add(new Warrior("Blue"));
        bluePlayer.getUnitList().add(new HeadQuarters("Blue"));
    }
}
