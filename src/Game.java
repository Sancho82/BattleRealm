import java.awt.*;

public class Game {
    public static void main(String[] args) {

        Battlefield battlefield = new Battlefield();
        battlefield.setVisible(true);

        Table table = new Table();
        table.matrixLoader();
        table.matrixDisplayer();
    }
}
