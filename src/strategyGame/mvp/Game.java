package strategyGame.mvp;

import strategyGame.pictures.IconConsts;
import strategyGame.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int size;
    private Unit[][] matrix;
    private IconConsts icons;
    private Position selectedPosition;
    private int currentPlayerIndex;

    private List<Player> playerList;

    public Game() {
        size = 10;
        matrix = new Unit[size][size];
        icons = new IconConsts();
        playerList = new ArrayList<>();
        playerList.add(new Player("Red"));
        playerList.add(new Player("Blue"));
        selectedPosition = null;
        createStartingUnits();
        currentPlayerIndex = new Random().nextInt(playerList.size());
        activatePlayer(playerList.get(currentPlayerIndex));
    }

    //region Getters

    public int getSize() {
        return size;
    }

    public Unit[][] getMatrix() {
        return matrix;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    //endregion

    //region Creators

    public Unit createUnit(int optionSelected, Player player) {

        Unit unit = null;

        switch (optionSelected) {
            case 3:
                unit = player.getColor().equals("Red") ? new Warrior(player.getColor(), icons.getRedWarrior()) : new Warrior(player.getColor(), icons.getBlueWarrior());
                break;

            case 4:
                unit = player.getColor().equals("Red") ? new Archer(player.getColor(), icons.getRedArcher()) : new Archer(player.getColor(), icons.getBlueArcher());
                break;

            case 5:
                unit = player.getColor().equals("Red") ? new Paladin(player.getColor(), icons.getRedPaladin()) : new Paladin(player.getColor(), icons.getBluePaladin());
                break;

            case 6:
                unit = player.getColor().equals("Red") ? new Medicamp(player.getColor(), icons.getRedMedicamp()) : new Medicamp(player.getColor(), icons.getBlueMedicamp());
                break;

            case 7:
                unit = player.getColor().equals("Red") ? new Archery(player.getColor(), icons.getRedArchery()) : new Archery(player.getColor(), icons.getBlueArchery());
                break;

            case 8:
                unit = player.getColor().equals("Red") ? new Stables(player.getColor(), icons.getRedStables()) : new Stables(player.getColor(), icons.getBlueStables());
                break;

            case 9:
                unit = player.getColor().equals("Red") ? new Castle(player.getColor(), icons.getRedCastle()) : new Castle(player.getColor(), icons.getBlueCastle());
        }

        return unit;
    }

    public void createStartingUnit(int type, Position position, Player player) {
        Unit unit = createUnit(type, player);
        player.getUnitList().add(unit);
        matrix[position.getX()][position.getY()] = unit;
    }

    public void createStartingUnits() {
        createStartingUnit(9, new Position(0, 0), playerList.get(0));
        createStartingUnit(3, new Position(0, 1), playerList.get(0));
        createStartingUnit(3, new Position(1, 0), playerList.get(0));
        createStartingUnit(3, new Position(1, 1), playerList.get(0));

        createStartingUnit(9, new Position(9, 9), playerList.get(1));
        createStartingUnit(3, new Position(9, 8), playerList.get(1));
        createStartingUnit(3, new Position(8, 9), playerList.get(1));
        createStartingUnit(3, new Position(8, 8), playerList.get(1));
    }

    //endregion


    //region Setters

    public void setSelectedPosition(Position position) {
        selectedPosition = position;
    }

    public void setUnit(Unit unit, Position position) {
        matrix[position.getX()][position.getY()] = unit;
    }

    public void removeUnitFromOwnersList(Unit unit) {
        Player player = playerList.get((currentPlayerIndex + 1) % playerList.size());
        if (unit.getColor().equals(player.getColor()))
            player.getUnitList().remove(unit);
    }

    //endregion


    public void nextPlayer() {
        deActivatePlayer(playerList.get(currentPlayerIndex));
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
        activatePlayer(playerList.get(currentPlayerIndex));
    }

    public void activatePlayer(Player player) {
        player.increaseGold();
        for (int i = 0; i < player.getUnitList().size(); i++) {
            Unit unit = player.getUnitList().get(i);
            unit.setAvailable();
            if (unit instanceof Soldier) {
                ((Soldier) (unit)).freshStart();

            } else if (unit instanceof Medicamp) {
                ((Medicamp) (unit)).healAll(player);
            }
        }
    }

    public void deActivatePlayer(Player player) {
        for (int i = 0; i < player.getUnitList().size(); i++) {
            player.getUnitList().get(i).deselect();
            player.getUnitList().get(i).setUnAvailable();
        }
    }

    public void selectUnit(Unit unit) {
        unit.select();
    }

    public void deSelectUnit(Unit unit) {
        unit.deselect();
    }

    public void attack(Soldier attacker, Unit target) {
        target.takeDamage(attacker.getDamage());
    }

    public boolean checkIfUnitIsAlive(Unit unit) {
        return unit.getHp() > 0;
    }

    public boolean isGameOver() {
        Player player = playerList.get((currentPlayerIndex + 1) % playerList.size());
        return (player.getUnitList().size() == 0 || !(player.getUnitList().get(0) instanceof Castle));
    }

    public String returnWinner() {
        return playerList.get(getCurrentPlayerIndex()).getName();
    }
}
