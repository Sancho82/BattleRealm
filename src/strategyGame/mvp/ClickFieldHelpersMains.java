package strategyGame.mvp;

import strategyGame.units.Building;
import strategyGame.units.Soldier;
import strategyGame.units.Unit;

public class ClickFieldHelpersMains {

    // when clicked Unit is not null and is available:
    public void clUnNotNullAndAv(Position position, MainContract.View view, MainContract.Presenter dashboard, Game game) {
        Unit[][] matrix = game.getMatrix();
        int actX = position.getX();
        int actY = position.getY();
        Unit clickedUnit = matrix[actX][actY];
        dashboard.setOptionSelected(-1);
        view.optionButtonsDefaultColorSetter();
        view.illustrationDisplayer(clickedUnit);
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
            view.setIllustrationBoardDefault();
            view.setUnitBoardDefault();
        }

        view.showSelectedUnit(matrix);
    }

    // when clicked Unit not null, not available, but selected position is not null
    public void clUnNotNullNotAvButSelPosNotNull(Position position, MainContract.View view, MainContract.Presenter dashboard, Game game) {
        int actX = position.getX();
        int actY = position.getY();
        int selX = game.getSelectedPosition().getX();
        int selY = game.getSelectedPosition().getY();
        Unit[][] matrix = game.getMatrix();
        Unit clickedUnit = matrix[actX][actY];
        Unit selectedUnit = game.getMatrix()[selX][selY];
        if (game.getSelectedPosition() != null) {
            if (selectedUnit instanceof Soldier) {
                if (!((Soldier) (selectedUnit)).getHasAttacked()) {
                    if (dashboard.isWithinRange(position, ((Soldier) (selectedUnit)).getAttackRange())) {
                        game.attack((Soldier) (selectedUnit), clickedUnit);
                        ((Soldier) selectedUnit).useAttack();
                        if (!game.checkIfUnitIsAlive(clickedUnit)) {
                            game.setUnit(null, position);
                            game.removeUnitFromOwnersList(clickedUnit);
                            view.visualDisplayer();
                            if (game.isGameOver()) {
                                view.finalMessage(game.returnWinner());
                                System.out.println(game.isGameOver());

                            } else if (dashboard.getOptionSelected() == 0) {
                                view.highLightRange(matrix, game.getSelectedPosition(),
                                        ((Soldier) selectedUnit).getAttackRange(), view.getColors().getBleed(), view.getColors().getAlarm());

                            } else if (dashboard.getOptionSelected() == 1) {
                                view.highLightRange(matrix, game.getSelectedPosition(),
                                        ((Soldier) selectedUnit).getSteppesLeft(), view.getColors().getBleed(), view.getColors().getRoast());

                            }

                        }
                    } else {
                        view.setTipBoard("Target is too far.");
                    }

                } else {
                    view.setTipBoard("Unit has already attacked.");
                }
            }
        }
    }

    // when clicked Unit is null but selected positionis not null
    public void clUnNullButSelPosNotNull(Position position, MainContract.View view, MainContract.Presenter dashboard, Game game) {
        Unit[][] matrix = game.getMatrix();
        int selX = game.getSelectedPosition().getX();
        int selY = game.getSelectedPosition().getY();
        Unit selectedUnit = matrix[selX][selY];
        Player player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        if (selectedUnit.getCanMove()) {
            if (((Soldier) (selectedUnit)).getSteppesLeft() > 0) {
                if (dashboard.isWithinRange(position, ((Soldier) (selectedUnit)).getSteppesLeft())) {

                    dashboard.moveUnit(game.getSelectedPosition(), position);
                    game.setSelectedPosition(position);
                    view.setUnitBoard(selectedUnit);
                    view.showSelectedUnit(matrix);
                    view.visualDisplayer();
                    dashboard.optionsHandler();

                } else {
                    view.setTipBoard("Destination is too far.");
                }

            } else {
                view.setTipBoard("This unit is too tired.");
            }

        } else if (dashboard.getOptionSelected() > 2) {
            if (dashboard.isWithinRange(position, ((Building) (selectedUnit)).getCreateRange())) {
                dashboard.addUnit(position);
                view.visualDisplayer();
                view.setPlayerBoard(player);
                view.showSelectedUnit(matrix);
                view.highLightRange(matrix, game.getSelectedPosition(),
                        ((Building) (selectedUnit)).getCreateRange(), view.getColors().getLife(), view.getColors().getLife());

            } else {
                view.setTipBoard("You need to deploy unit closer.");
            }


        } else {
            view.setTipBoard("This unit cannot move.");
        }
    }
}
