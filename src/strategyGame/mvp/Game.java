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
    private Player redPlayer;
    private Player bluePlayer;

    public Game() {
        size = 10;
        matrix = new Unit[size][size];
        playerList = new ArrayList<>();
        redPlayer = new Player("Red");
        bluePlayer = new Player("Blue");
        playerList.add(redPlayer);
        playerList.add(bluePlayer);
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

    public Player getRedPlayer() {
        return redPlayer;
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    //endregion

    //region Creators

    public void createCastle(Position position, Player player) {
        Castle castle = new Castle(player.getColor());
        matrix[position.getX()][position.getY()] = castle;
        player.getUnitList().add(castle);
        player.deCreaseGold(castle.getCost());
    }

    public void createArchery(Position position, Player player) {
        Archery archery = new Archery(player.getColor());
        matrix[position.getX()][position.getY()] = archery;
        player.getUnitList().add(archery);
        player.deCreaseGold(archery.getCost());
    }

    public void createStables(Position position, Player player) {
        Stables stables = new Stables(player.getColor());
        matrix[position.getX()][position.getY()] = stables;
        player.getUnitList().add(stables);
        player.deCreaseGold(stables.getCost());
    }

    public void createMedicamp(Position position, Player player) {
        MediCamp mediCamp = new MediCamp(player.getColor());
        matrix[position.getX()][position.getY()] = mediCamp;
        player.getUnitList().add(mediCamp);
        player.deCreaseGold(mediCamp.getCost());
    }

    public void createWarrior(Position position, Player player) {
        Warrior warrior = new Warrior(player.getColor());
        matrix[position.getX()][position.getY()] = warrior;
        player.getUnitList().add(warrior);
        player.deCreaseGold(warrior.getCost());
    }

    public void createArcher(Position position, Player player) {
        Archer archer = new Archer(player.getColor());
        matrix[position.getX()][position.getY()] = archer;
        player.getUnitList().add(archer);
        player.deCreaseGold(archer.getCost());
    }

    public void createPaladin(Position position, Player player) {
        Paladin paladin = new Paladin(player.getColor());
        matrix[position.getX()][position.getY()] = paladin;
        player.getUnitList().add(paladin);
        player.deCreaseGold(paladin.getCost());
    }

    public void createStartingUnits() {
        createCastle(new Position(0, 0), redPlayer);
        createWarrior(new Position(0, 1), redPlayer);
        createWarrior(new Position(1, 0), redPlayer);
        createWarrior(new Position(1, 1), redPlayer);

        createCastle(new Position(9, 9), bluePlayer);
        createWarrior(new Position(8, 9), bluePlayer);
        createWarrior(new Position(9, 8), bluePlayer);
        createWarrior(new Position(8, 8), bluePlayer);
    }

    //endregion

    public void setSelectedPosition(Position position) {
        selectedPosition = position;
    }

    public void nextPlayer(int index) {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    }

    public void activatePlayer(Player player) {
        player.increaseGold();
        for (int i = 0; i < player.getUnitList().size(); i++) {
            Unit unit = player.getUnitList().get(i);
            unit.setAvailable();
        }
    }

    public void deActivatePlayer(Player player) {
        for (int i = 0; i < player.getUnitList().size(); i++) {
            Unit unit = player.getUnitList().get(i);
            unit.setUnAvailable();
        }
    }

    public void selectUnit(Unit unit) {
        unit.select();
    }

    public void deSelectUnit(Unit unit) {
        unit.deselect();
    }

    public void moveUnit(Position from, Position to) {
        Unit unit = matrix[from.getX()][from.getY()];
        Unit target = matrix[to.getX()][to.getY()];

        target = unit;
        unit = null;

    }
}
