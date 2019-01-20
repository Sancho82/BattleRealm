package strategyGame.mvp;

import strategyGame.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int size;
    private Unit[][] matrix;
    private Position selectedPosition;
    private int currentPlayerIndex;

    private List<Player> playerList;

    public Game() {
        size = 10;
        matrix = new Unit[size][size];
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

    public void createCastle(Position position, Player player) {
        Castle castle = new Castle(player.getColor());
        matrix[position.getX()][position.getY()] = castle;
        player.getUnitList().add(castle);
    }

    public void createWarrior(Position position, Player player) {
        Warrior warrior = new Warrior(player.getColor());
        matrix[position.getX()][position.getY()] = warrior;
        player.getUnitList().add(warrior);
    }

    public Unit createUnit(int optionSelected, Player player) {

        Unit unit = null;

        switch (optionSelected) {
            case 3: unit = new Warrior(player.getColor());
                    break;

            case 4: unit = new Archer(player.getColor());
                    break;

            case 5: unit = new Paladin(player.getColor());
                    break;

            case 6: unit = new MediCamp(player.getColor());
                    break;

            case 7: unit = new Archery(player.getColor());
                    break;

            case 8: unit = new Stables(player.getColor());
                    break;
        }

        return unit;
    }

    public void createStartingUnits() {
        createCastle(new Position(0, 0), playerList.get(0));
        createWarrior(new Position(0, 1), playerList.get(0));
        createWarrior(new Position(1, 0), playerList.get(0));
        createWarrior(new Position(1, 1), playerList.get(0));

        createCastle(new Position(9, 9), playerList.get(1));
        createWarrior(new Position(8, 9), playerList.get(1));
        createWarrior(new Position(9, 8), playerList.get(1));
        createWarrior(new Position(8, 8), playerList.get(1));
    }

    //endregion

    public void setSelectedPosition(Position position) {
        selectedPosition = position;
    }

    public void nextPlayer() {
        deActivatePlayer(playerList.get(currentPlayerIndex));
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
        activatePlayer(playerList.get(currentPlayerIndex));
    }

    public void activatePlayer(Player player) {
        player.increaseGold();
        for (int i = 0; i < player.getUnitList().size(); i++) {
            player.getUnitList().get(i).setAvailable();
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

}
