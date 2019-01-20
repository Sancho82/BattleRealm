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
        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
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

        } else if (game.getSelectedPosition() != null) {
            Unit selectedUnit = game.getMatrix()[game.getSelectedPosition().getX()][game.getSelectedPosition().getY()];
            if (selectedUnit.getCanMove()) {
                if (((Soldier) (selectedUnit)).getSteppesLeft() > 0) {
                    int distX = Math.abs(position.getX() - game.getSelectedPosition().getX());
                    int distY = Math.abs(position.getY() - game.getSelectedPosition().getY());
                    int stepcost = differenceDecider(distX, distY);

                    if ((((Soldier) (selectedUnit)).getSteppesLeft() >= stepcost)) {

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

            } else if (optionSelected > 2) {
                int distX = Math.abs(position.getX() - game.getSelectedPosition().getX());
                int distY = Math.abs(position.getY() - game.getSelectedPosition().getY());
                int plannedCreateDistance = differenceDecider(distX, distY);

                if (plannedCreateDistance <= ((Building) (selectedUnit)).getCreateRange()) {
                    addUnit(position);
                    view.visualDisplayer();
                    view.setPlayerBoard(player);
                    view.removeHighLight(game.getSelectedPosition(), 3);
                    view.highLightRange(game.getSelectedPosition(), ((Building) (selectedUnit)).getCreateRange(), view.getColors().getOcean());

                } else {
                    view.setTipBoard("You need to deploy unit closer.");
                }


            } else {
                view.setTipBoard("This unit cannot move.");
            }
        }

        view.consoleDisplayer();
    }

    public void addUnit(Position position) {

        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        Unit unit = game.createUnit(optionSelected, player);

        if (player.getGold() > unit.getCost()) {
            game.getMatrix()[position.getX()][position.getY()] = unit;
            game.getMatrix()[position.getX()][position.getY()].setAvailable();
            player.getUnitList().add(game.getMatrix()[position.getX()][position.getY()]);
            player.deCreaseGold(game.getMatrix()[position.getX()][position.getY()].getCost());

        } else {
            view.setTipBoard("You don't have enough gold.");
        }
    }

    public void moveUnit(Position from, Position to) {
        Unit unit = game.getMatrix()[from.getX()][from.getY()];

        int distX = Math.abs(to.getX() - from.getX());
        int distY = Math.abs(to.getY() - from.getY());
        int stepcost = differenceDecider(distX, distY);
        ((Soldier) (unit)).reduceSteppes(stepcost);

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
        if (optionSelected == 2) {
            game.nextPlayer();
            view.setPlayerBoard(game.getPlayerList().get(game.getCurrentPlayerIndex()));
            view.setTipBoardDefault();
            view.setUnitBoardDefault();
            setOptionSelected(-1);
            if (game.getSelectedPosition() != null) {
                game.setSelectedPosition(null);
            }
            view.showSelectedUnit();


        } else if (game.getSelectedPosition() != null) {
            int x = game.getSelectedPosition().getX();
            int y = game.getSelectedPosition().getY();
            Unit unit = game.getMatrix()[x][y];

            view.removeHighLight(game.getSelectedPosition(), 3);

            if (optionSelected == -1) {
                view.optionButtonsDefaultColorSetter();

            } else if (optionSelected == 0) {
                if (unit.getCanAttack()) {
                    view.optionButtonsHighlighter(optionSelected);
                    view.highLightRange(game.getSelectedPosition(), ((Soldier) (unit)).getAttackRange(), view.getColors().getAlarm());
                    view.setTipBoardDefault();

                } else {
                    view.setTipBoard("Buildings have no attack-range.");
                    setOptionSelected(-1);
                }

            } else if (optionSelected == 1) {
                if (unit.getCanMove()) {
                    view.optionButtonsHighlighter(optionSelected);
                    view.highLightRange(game.getSelectedPosition(), ((Soldier) (unit)).getSteppesLeft(), view.getColors().getRoast());
                    view.setTipBoardDefault();

                } else {
                    view.setTipBoard("Buildings have no move-range.");
                    setOptionSelected(-1);
                }

            } else if (optionSelected == 3 || optionSelected == 6 || optionSelected == 7 || optionSelected == 8) {
                if (unit.getCanCreate()) {
                    if (unit instanceof Castle) {
                        view.optionButtonsHighlighter(optionSelected);
                        view.highLightRange(game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getOcean());
                        view.setTipBoardDefault();

                    } else {
                        view.setTipBoard("Building cannot create Warriors.");
                        setOptionSelected(-1);
                        view.optionButtonsDefaultColorSetter();
                    }

                } else {
                    view.setTipBoard("This unit cannot create units.");
                    view.optionButtonsDefaultColorSetter();
                    setOptionSelected(-1);
                }

            } else if (optionSelected == 4) {
                if (unit.getCanCreate()) {
                    if (unit instanceof Archery) {
                        view.optionButtonsHighlighter(optionSelected);
                        view.highLightRange(game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getOcean());
                        view.setTipBoardDefault();

                    } else {
                        view.setTipBoard("This unit cannot create Archers.");
                        setOptionSelected(-1);
                        view.optionButtonsDefaultColorSetter();
                    }

                } else {
                    view.setTipBoard("This unit cannot create units.");
                    setOptionSelected(-1);
                    view.optionButtonsDefaultColorSetter();
                }

            } else if (optionSelected == 5) {
                if (unit.getCanCreate()) {
                    if (unit instanceof Stables) {
                        view.optionButtonsHighlighter(optionSelected);
                        view.highLightRange(game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getOcean());
                        view.setTipBoardDefault();

                    } else {
                        view.setTipBoard("This unit cannot create Paladins.");
                        setOptionSelected(-1);
                        view.optionButtonsDefaultColorSetter();
                    }

                } else {
                    view.setTipBoard("This unit cannot create units.");
                    setOptionSelected(-1);
                    view.optionButtonsDefaultColorSetter();
                }

            } else {
                view.setTipBoard("No unit selected.");
            }
        }
    }
}