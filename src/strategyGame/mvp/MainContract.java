package strategyGame.mvp;

import strategyGame.units.Soldier;
import strategyGame.units.Unit;

public interface MainContract {

    interface View {
        void visualDisplayer();
        void consoleDisplayer();
        void showSelectedUnit();
        void highLightStepRange(Position position, Soldier soldier);
        void removeHighLight(Position position, Soldier soldier);

        void setUnitBoard(Unit unit);
        void setUnitBoardDefault();
        void setPlayerBoard(Player player);
        void setPlayerBoardDefault();
        void setTipBoard(String text);
        void setTipBoardDefault();


    }

    interface Presenter {
        void clickField(Position position);
        Game getGame();
        void showActivePlayerStats();
    }

}
