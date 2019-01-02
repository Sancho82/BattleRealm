package strategyGame;

public class Game {

    private static Player redPlayer = new Player("Red");
    private static Player bluePlayer = new Player("Blue");
    private static Battlefield battlefield = new Battlefield();

    public static void main(String[] args) {

        battlefield.setVisible(true);
        redPlayer.createStartingUnits(battlefield);
        bluePlayer.createStartingUnits(battlefield);
        battlefield.consoleDisplayer();
        battlefield.visualDisplayer();

    }
}
