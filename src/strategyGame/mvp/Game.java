package strategyGame.mvp;

import java.util.Random;

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
        startingPlayerSelector();
        playerStatDisplayer();

        while (!gameOver()) {
            if (redPlayer.getPlaying()) {
                redPlayer.play();
            }

            if (bluePlayer.getPlaying()) {
                bluePlayer.play();
            }
        }


    }

    public static void startingPlayerSelector() {
        Random random = new Random();
        int draw = random.nextInt(2);

        if (draw == 0) {
            redPlayer.play();

        } else {
            bluePlayer.play();
        }
    }

    public static void playerStatDisplayer() {
        if (redPlayer.getPlaying()) {
            battlefield.getPlayerBoard().setText(redPlayer.toString());
        }

        if (bluePlayer.getPlaying()) {
            battlefield.getPlayerBoard().setText(bluePlayer.toString());
        }
    }

    public static boolean gameOver() {
        return redPlayer.getHeadQuarters().getHp() == 0 || bluePlayer.getHeadQuarters().getHp() == 0;
    }
}
