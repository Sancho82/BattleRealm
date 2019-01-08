package strategyGame.mvp;

import strategyGame.units.HeadQuarters;
import strategyGame.units.MediCamp;
import strategyGame.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String color;
    private int gold;
    private boolean isPlaying;
    private List<Unit> unitList;
    private HeadQuarters headQuarters;

    public Player(String color) {
        this.color = color;
        gold = 50;
        isPlaying = false;
        unitList = new ArrayList<>();
        createHeadQuarters();
    }

    //region Getters

    public String getColor() {
        return color;
    }

    public int getGold() {
        return gold;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public HeadQuarters getHeadQuarters() {
        return headQuarters;
    }

    //endregion

    //region Creators

    public void createHeadQuarters() {
        if (color.equals("Red")) {
            headQuarters = new HeadQuarters(color, 0, 0);
            unitList.add(headQuarters);
            Game.battlefield.setUnit(headQuarters, headQuarters.getPosition()[0], headQuarters.getPosition()[1]);

        } else if (color.equals("Blue")) {
            headQuarters = new HeadQuarters(color, 9, 9);
            unitList.add(headQuarters);
            Game.battlefield.setUnit(headQuarters, headQuarters.getPosition()[0], headQuarters.getPosition()[1]);
        }
    }

    //endregion

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public void openUnits() {
        for (int i = 0; i < unitList.size(); i++) {
            unitList.get(i).setAvailable();
        }
    }

    public void closeUnits() {
        for(int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof MediCamp) {
                ((MediCamp) unitList.get(i)).heal(this);
                unitList.get(i).setUnAvailable();

            } else {
                unitList.get(i).setUnAvailable();
            }
        }
    }

    public void play() {
        isPlaying = true;
        openUnits();
        gold += 50;

        /*Unit[][] matrix = Game.battlefield.getMatrix();
        // JButton[][] buttons = Game.battlefield.getButtons();

        JLabel unitBoard = Game.battlefield.getUnitBoard();
        JLabel playerBoard = Game.battlefield.getPlayerBoard();
        JLabel tipBoard = Game.battlefield.getTipBoard();

        Colors colors = Game.battlefield.getColors();

        JButton attack = Game.battlefield.getAttack();
        JButton move = Game.battlefield.getMove();
        JButton endTurn = Game.battlefield.getEndTurn();
        JButton createWarrior = Game.battlefield.getCreateWarrior();
        JButton createArcher = Game.battlefield.getCreateArcher();
        JButton createPaladin = Game.battlefield.getCreatePaladin();
        JButton createMediCamp = Game.battlefield.getCreateMediCamp();
        JButton createArchery = Game.battlefield.getCreateArchery();
        JButton createStables = Game.battlefield.getCreateStables();

        int myI = Game.battlefield.getI();
        int myJ = Game.battlefield.getJ();
        int myK = Game.battlefield.getK();
        int myL = Game.battlefield.getL();

        if (matrix[myJ][myI] != null && !matrix[myJ][myI].getIsSelected() && myK == -1) {
            Game.battlefield.buttons[myI][myJ].setBackground(Color.orange);
            matrix[myJ][myI].select();
            unitBoard.setText(matrix[myJ][myI].toString());
            myK = myI;
            myL = myJ;
            Game.battlefield.setK(myI);
            Game.battlefield.setL(myJ);


        } else if (matrix[myJ][myI] != null && !matrix[myJ][myI].getIsSelected() && myK != -1) {
            Game.battlefield.buttons[myK][myL].setBackground(colors.getGrass());
            matrix[myL][myK].deselect();
            Game.battlefield.buttons[myI][myJ].setBackground(Color.orange);
            matrix[myJ][myI].select();
            unitBoard.setText(matrix[myJ][myI].toString());
            myK = myI;
            myL = myJ;
            Game.battlefield.setK(myI);
            Game.battlefield.setL(myJ);

        } else if (matrix[myJ][myI] != null && matrix[myJ][myI].getIsSelected()) {
            Game.battlefield.buttons[myI][myJ].setBackground(colors.getGrass());
            matrix[myJ][myI].deselect();
            unitBoard.setText("Unit Information");
            myK = -1;
            myL = -1;
            Game.battlefield.setK(-1);
            Game.battlefield.setL(-1);

        } else if (matrix[myJ][myI] == null && matrix[myL][myK].isSelected) {
            Game.battlefield.buttons[myK][myL].setBackground(colors.getGrass());
            Game.battlefield.buttons[myK][myL].setText("");
            matrix[myJ][myI] = matrix[myL][myK];
            Game.battlefield.buttons[myI][myJ].setBackground(Color.orange);
            matrix[myL][myK] = null;
            Game.battlefield.visualDisplayer();
            System.out.println();
            Game.battlefield.consoleDisplayer();
            myK = myI;
            myL = myJ;
            Game.battlefield.setK(myI);
            Game.battlefield.setL(myJ);

        }*/
    }

    public void  endTurn() {

    }

    public String toString() {
        return "<html><font color=white><Strong>Player:&nbsp</Strong></font>" + color + "<br>" +
                "<font color=white><Strong>Gold:&nbsp</Strong></font>" + gold + "<br>" +
                "</html>";
    }
}
