package strategyGame.mvp;

import strategyGame.units.*;

public class DashBoard implements MainContract.Presenter {

    private Game game;
    private MainContract.View view;
    private ClickFieldHelpersMains cFHMains;

    private int optionSelected;

    public DashBoard(MainContract.View view) {
        game = new Game();
        this.view = view;

        optionSelected = -1;

        cFHMains = new ClickFieldHelpersMains();
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

        if (clickedUnit != null) {
            if (clickedUnit.getIsAvailable()) {
                cFHMains.clUnNotNullAndAv(position, view, this, game);

            } else if (game.getSelectedPosition() != null) {
                cFHMains.clUnNotNullNotAvButSelPosNotNull(position, view, this, game);

            } else {
                view.setTipBoard("You cannot select this unit.");

            }

        } else if (game.getSelectedPosition() != null) {
            cFHMains.clUnNullButSelPosNotNull(position, view, this, game);

        }

        view.toolTipSetter();
        // view.consoleDisplayer();
    }

    public void startGame(String player1, String player2) {
        game.getPlayerList().get(0).setName(player1);
        game.getPlayerList().get(1).setName(player2);

        view.setPlayerBoard(game.getPlayerList().get(game.getCurrentPlayerIndex()));
        view.startBattle();
    }

    public void addUnit(Position position) {

        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        Unit unit = game.createUnit(optionSelected, player);

        if (player.getGold() >= unit.getCost()) {
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

            view.showSelectedUnit(game.getMatrix());

            if (optionSelected == -1) {
                view.optionButtonsDefaultColorSetter();
                view.setTipBoardDefault();

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

            }

        } else {
            view.setTipBoard("No unit selected.");
        }
    }

    public void option0(Unit unit) {
        if (unit.getCanAttack()) {
            view.optionButtonsHighlighter(optionSelected);
            view.highLightRange(game.getMatrix(), game.getSelectedPosition(),
                    ((Soldier) (unit)).getAttackRange(), view.getColors().getBleed(), view.getColors().getAlarm());
            view.setTipBoardDefault();

        } else {
            view.setTipBoard("Buildings have no attack-range.");
            setOptionSelected(-1);
        }
    }

    public void option1(Unit unit) {
        if (unit.getCanMove()) {
            view.optionButtonsHighlighter(optionSelected);
            view.highLightRange(game.getMatrix(), game.getSelectedPosition(),
                    ((Soldier) (unit)).getSteppesLeft(), view.getColors().getBleed(), view.getColors().getRoast());
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
                if (optionSelected == 3) {
                    view.setTipBoard("Warriors cost 40 Gold.");

                } else if (optionSelected == 6) {
                    view.setTipBoard("Medicamp costs 100 Gold.");

                } else if (optionSelected == 7) {
                    view.setTipBoard("Archery costs 150 Gold.");

                } else if (optionSelected == 8) {
                    view.setTipBoard("Stables cost 200 Gold.");

                }

                view.optionButtonsHighlighter(optionSelected);
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(),
                        ((Building) (unit)).getCreateRange(), view.getColors().getLife(), view.getColors().getLife());

            } else {
                if (optionSelected == 3) {
                    view.setTipBoard("Building cannot create Warriors.");

                } else if (optionSelected == 6) {
                    view.setTipBoard("Building cannot create Medicamp.");

                } else if (optionSelected == 7) {
                    view.setTipBoard("Building cannot create Archery.");

                } else if (optionSelected == 8) {
                    view.setTipBoard("Building cannot create Stables.");

                }

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
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(),
                        ((Building) (unit)).getCreateRange(), view.getColors().getLife(), view.getColors().getLife());
                view.setTipBoard("Archers cost 70 Gold.");

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
                view.highLightRange(game.getMatrix(), game.getSelectedPosition(),
                        ((Building) (unit)).getCreateRange(), view.getColors().getLife(), view.getColors().getLife());
                view.setTipBoard("Paladins cost 120 Gold.");

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