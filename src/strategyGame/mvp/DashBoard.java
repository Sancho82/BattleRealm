package strategyGame.mvp;

import strategyGame.units.*;

public class DashBoard implements MainContract.Presenter {

    private Game game;
    private MainContract.View view;

    private int optionSelected;

    public DashBoard(MainContract.View view) {
        game = new Game();
        this.view = view;

        optionSelected = -1;
    }

    //region Getters

    public Game getGame() {
        return game;
    }

    public int getOptionSelected() {
        return optionSelected;
    }

    @Override
    public void showActivePlayerStats() {
        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        view.setPlayerBoard(player);
    }

    //endregion

    //region Setters

    public void setOptionSelected(int o) {
        optionSelected = o;
    }

    //endregion


    @Override
    public void clickField(Position position) {
        view.setTipBoardDefault();
        Unit unit = game.getMatrix()[position.getX()][position.getY()];
        if (unit != null) {
            if (unit.getIsAvailable()) {
                setOptionSelected(-1);
                view.optionButtonsDefaultColorSetter();
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
                
                view.showSelectedUnit();

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
                            view.showSelectedUnit();
                            view.visualDisplayer();
                            optionsHandler();

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

    public void optionsHandler() {
        if (game.getSelectedPosition() != null) {
            int x = game.getSelectedPosition().getX();
            int y = game.getSelectedPosition().getY();
            Unit unit = game.getMatrix()[x][y];

            view.removeHighLight(game.getSelectedPosition(), 3);

            if (optionSelected == -1) {
                view.optionButtonsDefaultColorSetter();

            } else if (optionSelected == 0 && unit.getCanAttack()) {
                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getSelectedPosition(), ((Soldier)(unit)).getAttackRange(), view.getColors().getAlarm());

            } else if (optionSelected == 1 && unit.getCanMove()) {
                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getSelectedPosition(), ((Soldier)(unit)).getSteppesLeft(), view.getColors().getRoast());

            } else if (optionSelected > 1 && optionSelected < 9 && !unit.getCanMove()) {
                if (optionSelected == 3 || optionSelected == 6 || optionSelected == 7 || optionSelected == 8) {
                    view.optionButtonsHighlighter(optionSelected);
                    if (unit instanceof Castle) {
                        view.highLightRange(game.getSelectedPosition(), ((Building)(unit)).getCreateRange(), view.getColors().getOcean());
                        view.setTipBoardDefault();

                    } else {
                        view.setTipBoard("Building cannot create this type of unit.");
                    }

                } else {
                    view.optionButtonsDefaultColorSetter();
                    view.setTipBoard("Castle cannot create this unit.");
                }

            } else if (optionSelected < 9 && optionSelected > 1 && unit.getCanMove()) {
                view.setTipBoard("This unit cannot create new units.");

            } else if (optionSelected == 0 && !unit.getCanAttack()) {
                view.setTipBoard("This unit cannot attack.");

            } else if (optionSelected == 1 && !unit.getCanMove()) {
                view.setTipBoard("This unit cannot move.");
        }

        } else {
            view.setTipBoard("No unit selected.");
        }

    }
}
