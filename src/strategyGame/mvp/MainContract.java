package strategyGame.mvp;

import strategyGame.colors.Colors;
import strategyGame.units.Unit;

import javax.swing.*;
import java.awt.*;


public interface MainContract {

    interface View {
        void visualDisplayer();
        void consoleDisplayer();
        void illustrationDisplayer(Unit unit);

        void optionButtonsLoader();
        void optionButtonsHighlighter(int selection);
        void optionButtonsDefaultColorSetter();

        void highLightRange(Unit[][] matrix, Position position, int range, Color color1, Color color2);
        void showSelectedUnit(Unit[][] matrix);

        public MainContract.Presenter getDashBoard();
        public JPanel getBattlePanel();
        public JButton[][] getButtons();
        public JLabel getUnitBoard();
        public JLabel getPlayerBoard();
        public JLabel getTipBoard();
        Colors getColors();

        void setUnitBoard(Unit unit);
        void setUnitBoardDefault();
        void setPlayerBoard(Player player);
        void setPlayerBoardDefault();
        void setTipBoard(String text);
        void setTipBoardDefault();
        void setDescriptionBoard(String text);
        void setDescriptionBoardDeafault();
        void setIllustrationBoardDefault();

        void toolTipSetter();

        void startBattle();
        void finalMessage(String playername);

    }

    interface Presenter {
        void clickField(Position position);
        void optionsHandler();
        void startGame(String player1, String player2);
        void addUnit(Position position);
        void moveUnit(Position from, Position to);
        int differenceDecider(int a, int b);
        boolean isWithinRange(Position position, int range);
        Game getGame();
        int getOptionSelected();
        void setOptionSelected(int b);
        void showActivePlayerStats();
    }
}
