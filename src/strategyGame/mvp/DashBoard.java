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
        Unit[][] matrix = game.getMatrix();
        int actX = position.getX();
        int actY = position.getY();
        Unit clickedUnit = matrix[actX][actY];
        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        if (clickedUnit != null) {
            if (clickedUnit.getIsAvailable()) {
                setOptionSelected(-1);
                view.optionButtonsDefaultColorSetter();
                if (!clickedUnit.getIsSelected()) {
                    if (game.getSelectedPosition() != null) {
                        int selX = game.getSelectedPosition().getX();
                        int selY = game.getSelectedPosition().getY();
                        Unit selectedUnit = matrix[selX][selY];
                        game.deSelectUnit(selectedUnit);
                    }

                    game.setSelectedPosition(position);
                    game.selectUnit(clickedUnit);
                    view.setUnitBoard(clickedUnit);

                } else {
                    game.deSelectUnit(clickedUnit);
                    game.setSelectedPosition(null);
                    view.setUnitBoardDefault();
                }

                view.showSelectedUnit(matrix);

            } else if (game.getSelectedPosition() != null) {
                int selX = game.getSelectedPosition().getX();
                int selY = game.getSelectedPosition().getY();
                Unit selectedUnit = game.getMatrix()[selX][selY];
                if (selectedUnit instanceof Soldier) {
                    if (!((Soldier) (selectedUnit)).getHasAttacked()) {
                        if (isWithinRange(position, ((Soldier) (selectedUnit)).getAttackRange())) {
                            game.attack((Soldier) (selectedUnit), clickedUnit);
                            ((Soldier) selectedUnit).useAttack();
                            if (!game.checkIfUnitIsAlive(clickedUnit)) {
                                game.setUnit(null, position);
                                game.removeUnitFromOwnersList(clickedUnit);
                                view.visualDisplayer();
                                if (game.isGameOver()) {
                                    view.finalMessage(game.returnWinner().getName());
                                    System.out.println(game.isGameOver());

                                } else if (optionSelected == 0) {
                                   view.highLightRange(matrix, game.getSelectedPosition(), ((Soldier) selectedUnit).getAttackRange(), view.getColors().getAlarm());

                                } else if (optionSelected == 1) {
                                    view.highLightRange(matrix, game.getSelectedPosition(), ((Soldier) selectedUnit).getSteppesLeft(), view.getColors().getRoast());

                                }

                            }
                        } else {
                            view.setTipBoard("Target is too far.");
                        }

                    } else {
                        view.setTipBoard("Unit has already attacked.");
                    }

                }

            } else {
                view.setTipBoard("You cannot select this unit.");
            }

        } else if (game.getSelectedPosition() != null) {
            int selX = game.getSelectedPosition().getX();
            int selY = game.getSelectedPosition().getY();
            Unit selectedUnit = matrix[selX][selY];
            if (selectedUnit.getCanMove()) {
                if (((Soldier) (selectedUnit)).getSteppesLeft() > 0) {
                    if (isWithinRange(position, ((Soldier) (selectedUnit)).getSteppesLeft())) {

                        moveUnit(game.getSelectedPosition(), position);
                        game.setSelectedPosition(position);
                        view.setUnitBoard(selectedUnit);
                        view.showSelectedUnit(matrix);
                        view.visualDisplayer();
                        optionsHandler();

                    } else {
                        view.setTipBoard("Destination is too far.");
                    }

                } else {
                    view.setTipBoard("This unit is too tired.");
                }

            } else if (optionSelected > 2) {
                if (isWithinRange(position, ((Building) (selectedUnit)).getCreateRange())) {
                    addUnit(position);
                    view.visualDisplayer();
                    view.setPlayerBoard(player);
                    view.removeHighLight(matrix, game.getSelectedPosition(), 3);
                    view.highLightRange(matrix, game.getSelectedPosition(), ((Building) (selectedUnit)).getCreateRange(), view.getColors().getLife());

                } else {
                    view.setTipBoard("You need to deploy unit closer.");
                }


            } else {
                view.setTipBoard("This unit cannot move.");
            }
        }

        view.toolTipSetter();
        view.consoleDisplayer();
    }

    public void addUnit(Position position) {

        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        Unit unit = game.createUnit(optionSelected, player);

        if (player.getGold() > unit.getCost()) {
            unit.setAvailable();
            game.setUnit(unit, position);
            player.addToUnitList(unit);
            player.deCreaseGold(unit.getCost());

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

        game.setUnit(unit, to);
        game.setUnit(null, from);

    }

    public int differenceDecider(int a, int b) {
        return a > b ? a : b;
    }

    public boolean isWithinRange(Position position, int range) {
        int distanceX = Math.abs(position.getX() - game.getSelectedPosition().getX());
        int distanceY = Math.abs(position.getY() - game.getSelectedPosition().getY());
        int distance = differenceDecider(distanceX, distanceY);

        return range >= distance;
    }

    public void optionsHandler() {
        if (optionSelected == 2) {
            option2();

        } else if (game.getSelectedPosition() != null) {
            int x = game.getSelectedPosition().getX();
            int y = game.getSelectedPosition().getY();
            Unit unit = game.getMatrix()[x][y];

            view.removeHighLight(game.getMatrix(), game.getSelectedPosition(), 3);

            if (optionSelected == -1) {
                view.optionButtonsDefaultColorSetter();

            } else if (optionSelected == 0) {
               option0(unit);

            } else if (optionSelected == 1) {
                option1(unit);

            } else if (optionSelected == 3 || optionSelected == 6 || optionSelected == 7 || optionSelected == 8) {
                option3678(unit);

            } else if (optionSelected == 4) {
                option4(unit);

            } else if (optionSelected == 5) {
                option5(unit);

            } else {
                view.setTipBoard("No unit selected.");
            }
        }
    }

    public void option0(Unit unit) {
        if (unit.getCanAttack()) {
            view.optionButtonsHighlighter(optionSelected);
            view.highLightRange(game.getMatrix(), game.getSelectedPosition(), ((Soldier) (unit)).getAttackRange(), view.getColors().getAlarm());
            view.setTipBoardDefault();

        } else {
            view.setTipBoard("Buildings have no attack-range.");
            setOptionSelected(-1);
        }
    }

    public void option1(Unit unit) {
        if (unit.getCanMove()) {
            view.optionButtonsHighlighter(optionSelected);
            view.highLightRange(game.getMatrix(), game.getSelectedPosition(), ((Soldier) (unit)).getSteppesLeft(), view.getColors().getRoast());
            view.setTipBoardDefault();

        } else {
            view.setTipBoard("Buildings have no move-range.");
            setOptionSelected(-1);
        }
    }

    public void option2() {
        game.nextPlayer();
        view.setPlayerBoard(game.getPlayerList().get(game.getCurrentPlayerIndex()));
        view.setTipBoardDefault();
        view.setUnitBoardDefault();
        setOptionSelected(-1);
        view.optionButtonsDefaultColorSetter();
        if (game.getSelectedPosition() != null) {
            game.setSelectedPosition(null);
        }
        view.showSelectedUnit(game.getMatrix());
    }

    public void option3678(Unit unit) {
        if (unit.getCanCreate()) {
            if (unit instanceof Castle) {
                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getLife());
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
    }

    public void option4(Unit unit) {
        if (unit.getCanCreate()) {
            if (unit instanceof Archery) {
                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getLife());
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
    }

    public void option5(Unit unit) {
        if (unit.getCanCreate()) {
            if (unit instanceof Stables) {
                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(), ((Building) (unit)).getCreateRange(), view.getColors().getLife());
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

    }
}