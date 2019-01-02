package strategyGame;

public class Game {

    public static Battlefield battlefield = new Battlefield();
    public static Player redPlayer = new Player("Red");
    public static Player bluePlayer = new Player("Blue");

    public static void main(String[] args) {

        battlefield.setVisible(true);
        redPlayer.getHeadQuarters().createStartingUnits();
        bluePlayer.getHeadQuarters().createStartingUnits();
        battlefield.visualDisplayer();
        battlefield.consoleDisplayer();

    }
}
