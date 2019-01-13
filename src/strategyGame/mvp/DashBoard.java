package strategyGame.mvp;

import strategyGame.units.Soldier;
import strategyGame.units.Unit;

public class DashBoard implements MainContract.Presenter {

    private Game game;
    private MainContract.View view;

    public DashBoard(MainContract.View view) {
        game = new Game();
        this.view = view;
    }

    //region Getters

    public Game getGame() {
        return game;
    }

    @Override
    public void showActivePlayerStats() {
        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        view.setPlayerBoard(player);
    }

    //endregion

    @Override
    public void clickField(Position position) {
        Unit unit = game.getMatrix()[position.getX()][position.getY()];
        if (unit != null) {
            if (unit.getIsAvailable()) {
                if (!unit.getIsSelected()) {
                    if (game.getSelectedPosition() != null) {
                        Unit previous = game.getMatrix()[game.getSelectedPosition().getX()][game.getSelectedPosition().getY()];
                        game.deSelectUnit(previous);

                    }

                    game.setSelectedPosition(position);
                    game.selectUnit(unit);
                    view.setUnitBoard(unit);

                } else {
                    game.deSelectUnit(unit);
                    game.setSelectedPosition(null);
                    view.setUnitBoardDefault();
                }


            } else {
                //TODO
            }
        } else {
            if (game.getSelectedPosition() != null) {
                Unit unitToMove = game.getMatrix()[game.getSelectedPosition().getX()][game.getSelectedPosition().getY()];
            }
        }
        view.showSelectedUnit();
        view.visualDisplayer();
    }
}
