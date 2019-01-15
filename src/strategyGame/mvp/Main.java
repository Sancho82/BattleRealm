package strategyGame.mvp;

public class Main {

    public static void main(String[] args) {

        Displayer displayer = new Displayer();
        displayer.setVisible(true);

        System.out.println("\n" + displayer.getBattlePanel().getComponents()[100]);

    }
}