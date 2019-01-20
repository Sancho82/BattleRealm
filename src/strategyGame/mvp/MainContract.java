package strategyGame.mvp;

import strategyGame.colors.Colors;
import strategyGame.units.Unit;

import java.awt.*;


public interface MainContract {

    interface View {
        void visualDisplayer();
        void consoleDisplayer();
        void showSelectedUnit();

        void optionButtonsLoader();
        void optionButtonsHighlighter(int selection);
        void optionButtonsDefaultColorSetter();

        void highLightRange(Position position, int range, Color color);
        void removeHighLight(Position position, int range);

        Colors getColors();

        void setUnitBoard(Unit unit);
        void setUnitBoardDefault();
        void setPlayerBoard(Player player);
        void setPlayerBoardDefault();
        void setTipBoard(String text);
        void setTipBoardDefault();

    }

    interface Presenter {
        void clickField(Position position);
        void optionsHandler();
        void addUnit(Position position);
        void moveUnit(Position from, Position to);
        Game getGame();
        int getOptionSelected();
        void setOptionSelected(int b);
        void showActivePlayerStats();
    }

}
