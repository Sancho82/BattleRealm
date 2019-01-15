package strategyGame.mvp;

import strategyGame.units.Soldier;
import strategyGame.units.Unit;

public class DashBoard implements MainContract.Presenter {

    private Game game;
    private MainContract.View view;

    private byte optionSelected;

    public DashBoard(MainContract.View view) {
        game = new Game();
        this.view = view;

        optionSelected = -1;
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

    //region Setters



    //endregion


    @Override
    public void clickField(Position position) {
        view.setTipBoardDefault();
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
                view.setTipBoard("You cannot select this unit.");
            }

        } else {
            if (game.getSelectedPosition() != null) {
                Unit selectedUnit = game.getMatrix()[game.getSelectedPosition().getX()][game.getSelectedPosition().getY()];
                if (selectedUnit.getCanMove()) {
                    if (((Soldier)(selectedUnit)).getSteppesLeft() > 0) {
                        int distX = Math.abs(position.getX() - game.getSelectedPosition().getX());
                        int distY = Math.abs(position.getY() - game.getSelectedPosition().getY());
                        int stepcost = differenceDecider(distX, distY);

                        if ((((Soldier)(selectedUnit)).getSteppesLeft() >= stepcost)) {

                            moveUnit(game.getSelectedPosition(), position);
                            game.setSelectedPosition(position);
                            view.setUnitBoard(selectedUnit);

                        } else {
                            view.setTipBoard("Destination is too far.");
                        }

                    } else {
                        view.setTipBoard("This unit is too tired.");
                    }

                } else {
                    view.setTipBoard("This unit cannot move.");
                }
            }

        }

        view.showSelectedUnit();
        view.visualDisplayer();
        view.consoleDisplayer();
    }

    public void moveUnit(Position from, Position to) {
        Unit unit = game.getMatrix()[from.getX()][from.getY()];

        int distX = Math.abs(to.getX() - from.getX());
        int distY = Math.abs(to.getY() - from.getY());
        int stepcost = differenceDecider(distX, distY);
        ((Soldier)(unit)).reduceSteppes(stepcost);

        game.getMatrix()[to.getX()][to.getY()] = unit;
        game.getMatrix()[from.getX()][from.getY()] = null;
    }

    public int differenceDecider(int a, int b) {
        if (a > b) {
           return a;
        }
        return b;
    }
}
