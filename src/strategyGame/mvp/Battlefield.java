package strategyGame.mvp;

import strategyGame.colors.Colors;
import strategyGame.units.Soldier;
import strategyGame.units.Unit;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battlefield extends JFrame implements ActionListener{

    private final int size = 10;
    public JButton[][] buttons;

    private Unit[][] matrix;
    private JLabel unitBoard;
    private JLabel playerBoard;
    private JLabel tipBoard;

    private Colors colors;

    private JButton attack;
    private JButton move;
    private JButton endTurn;
    private JButton createWarrior;
    private JButton createArcher;
    private JButton createPaladin;
    private JButton createMediCamp;
    private JButton createArchery;
    private JButton createStables;

    private int k;
    private int l;
    private int i;
    private int j;

    public Battlefield() {
        colors = new Colors();

        setTitle("Battlefield");
        setBounds(0,0, 1165, 820);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel field = new JPanel();
        field.setLayout(null);
        field.setBackground(colors.getDrape());
        field.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        add(field);

        tipBoard = new JLabel();
        tipBoard.setBounds(775, 65, 305, 60);
        tipBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tipBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        tipBoard.setHorizontalAlignment(SwingConstants.LEFT);
        tipBoard.setVerticalAlignment(SwingConstants.TOP);
        tipBoard.setText("Tips");
        tipBoard.setForeground(Color.white);
        tipBoard.setOpaque(true);
        tipBoard.setBackground(colors.getFog());
        field.add(tipBoard);

        playerBoard = new JLabel();
        playerBoard.setBounds(775, 130, 305, 60);
        playerBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        playerBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        playerBoard.setHorizontalAlignment(SwingConstants.LEFT);
        playerBoard.setVerticalAlignment(SwingConstants.TOP);
        playerBoard.setText("Player Information");
        playerBoard.setForeground(Color.white);
        playerBoard.setOpaque(true);
        playerBoard.setBackground(colors.getFog());
        field.add(playerBoard);

        unitBoard = new JLabel();
        unitBoard.setBounds(775, 520, 305, 125);
        unitBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        unitBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        unitBoard.setHorizontalAlignment(SwingConstants.LEFT);
        unitBoard.setVerticalAlignment(SwingConstants.TOP);
        unitBoard.setText("Unit Information");
        unitBoard.setForeground(Color.white);
        unitBoard.setOpaque(true);
        unitBoard.setBackground(colors.getFog());
        field.add(unitBoard);

        matrix = new Unit[size][size];
        buttons = new JButton[size][size];

        ButtonGroup gameBoard = new ButtonGroup();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(65 + i * 65, 65 + j * 65, 60, 60);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setBackground(colors.getGrass());
                // button.getInsets(new Insets(0, 0, 0, 0));
                button.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttons[i][j] = button;

                button.setActionCommand(i + " " + j);
                button.addActionListener(this);
                gameBoard.add(button);
                field.add(button);
            }
        }

        ButtonGroup options = new ButtonGroup();

        attack = new JButton();
        attack.setBounds(775, 195, 305, 60);
        attack.setFont(new Font("Verdana", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attack");
        attack.setBackground(colors.getAlarm());
        options.add(attack);
        field.add(attack);

        move = new JButton();
        move.setBounds(775, 260, 305, 60);
        move.setFont(new Font("Verdana", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Move");
        move.setBackground(colors.getRoast());
        options.add(move);
        field.add(move);

        endTurn = new JButton();
        endTurn.setBounds(775, 650, 305, 60);
        endTurn.setFont(new Font("Verdana", Font.BOLD, 25));
        endTurn.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        endTurn.setText("End Turn");
        endTurn.setBackground(colors.getSolar());
        options.add(endTurn);
        field.add(endTurn);

        createWarrior = new JButton();
        createWarrior.setBounds(775, 325, 150, 60);
        createWarrior.setFont(new Font("Verdana", Font.BOLD, 15));
        createWarrior.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createWarrior.setText("Create Warrior");
        createWarrior.setBackground(colors.getTrepp());
        options.add(createWarrior);
        field.add(createWarrior);

        createArcher = new JButton();
        createArcher.setBounds(775, 390, 150, 60);
        createArcher.setFont(new Font("Verdana", Font.BOLD, 15));
        createArcher.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArcher.setText("Create Archer");
        createArcher.setBackground(colors.getTrepp());
        options.add(createArcher);
        field.add(createArcher);

        createPaladin = new JButton();
        createPaladin.setBounds(775, 455, 150, 60);
        createPaladin.setFont(new Font("Verdana", Font.BOLD, 15));
        createPaladin.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createPaladin.setText("Create Paladin");
        createPaladin.setBackground(colors.getTrepp());
        options.add(createPaladin);
        field.add(createPaladin);

        createMediCamp = new JButton();
        createMediCamp.setBounds(930, 325, 150, 60);
        createMediCamp.setFont(new Font("Verdana", Font.BOLD, 15));
        createMediCamp.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createMediCamp.setText("Create Medicamp");
        createMediCamp.setBackground(colors.getTrepp());
        options.add(createMediCamp);
        field.add(createMediCamp);

        createArchery = new JButton();
        createArchery.setBounds(930, 390, 150, 60);
        createArchery.setFont(new Font("Verdana", Font.BOLD, 15));
        createArchery.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArchery.setText("Create Archery");
        createArchery.setBackground(colors.getTrepp());
        options.add(createArchery);
        field.add(createArchery);

        createStables = new JButton();
        createStables.setBounds(930, 455, 150, 60);
        createStables.setFont(new Font("Verdana", Font.BOLD, 15));
        createStables.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createStables.setText("Create Stables");
        createStables.setBackground(colors.getTrepp());
        options.add(createStables);
        field.add(createStables);

        k = -1;
        l = -1;

    }

    //region Getters

    public JButton[][] getButtons() {
        return buttons;
    }

    public Unit[][] getMatrix() {
        return this.matrix;
    }

    public Unit getUnit(int i, int j) {
        return matrix[i][j];
    }

    public JLabel getUnitBoard() {
        return unitBoard;
    }

    public JLabel getPlayerBoard() {
        return playerBoard;
    }

    public JLabel getTipBoard() {
        return tipBoard;
    }

    public Colors getColors() {
        return colors;
    }

    public JButton getAttack() {
        return attack;
    }

    public JButton getMove() {
        return move;
    }

    public JButton getEndTurn() {
        return endTurn;
    }

    public JButton getCreateWarrior() {
        return createWarrior;
    }

    public JButton getCreateArcher() {
        return createArcher;
    }

    public JButton getCreatePaladin() {
        return createPaladin;
    }

    public JButton getCreateMediCamp() {
        return createMediCamp;
    }

    public JButton getCreateArchery() {
        return createArchery;
    }

    public JButton getCreateStables() {
        return createStables;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
    }

    public int getL() {
        return l;
    }

    //endregion

    //region Setters

    public void setUnit(Unit unit, int i, int j) {
        matrix[i][j] = unit;
    }

    public void setUnitBoard(String text) {
        unitBoard.setText(text);
    }

    public void setPlayerBoard(String text) {
        playerBoard.setText(text);
    }

    public void setTipBoard(String text) {
        tipBoard.setText(text);
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void setL(int l) {
        this.l = l;
    }

    //endregion

    public void consoleDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != null) {
                    System.out.print(matrix[i][j].getPrefix() + " ");
                } else {
                    System.out.print(" X ");
                }
            }
        }
    }

    public void visualDisplayer() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.getUnit(j, i) != null) {
                    buttons[i][j].setText(this.getUnit(j, i).getPrefix());

                } else {
                    buttons[i][j].setText("");
                }
            }
        }
    }

    public void tipBoardResetter() {
        if (!tipBoard.getText().equals("Tips")) {
            tipBoard.setText("Tips");
        }
    }

    public void unitBoardResetter() {
        if (!unitBoard.getText().equals("Unit Information")) {
            unitBoard.setText("Unit Information");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        String[] coords = event.split(" ");
        i = Integer.parseInt(coords[0]);
        j = Integer.parseInt(coords[1]);

        if (matrix[j][i] != null && matrix[j][i].getIsAvailable()) {
            if (!matrix[j][i].getIsSelected()) {
                if (k == -1) {
                    buttons[i][j].setBackground(Color.orange);
                    matrix[j][i].select();
                    unitBoard.setText(matrix[j][i].toString());
                    k = i;
                    l = j;

                } else {
                    buttons[k][l].setBackground(colors.getGrass());
                    matrix[l][k].deselect();
                    buttons[i][j].setBackground(Color.orange);
                    matrix[j][i].select();
                    unitBoard.setText(matrix[j][i].toString());
                    tipBoardResetter();
                    k = i;
                    l = j;
                }

            } else {
                buttons[i][j].setBackground(colors.getGrass());
                matrix[j][i].deselect();
                unitBoardResetter();
                tipBoardResetter();
                k = -1;
                l = -1;
            }

        } else if (k != -1 && matrix[l][k].getIsSelected() && matrix[l][k] instanceof Soldier) {
            if (((Soldier)(matrix[l][k])).getSteppesLeft() > 0) {
                if (Math.abs(l - j) < 2 && Math.abs(k - i) < 2) {
                    buttons[k][l].setBackground(colors.getGrass());
                    matrix[j][i] = matrix[l][k];
                    ((Soldier)(matrix[j][i])).step();
                    buttons[i][j].setBackground(Color.orange);
                    unitBoard.setText(matrix[j][i].toString());
                    tipBoardResetter();
                    matrix[l][k] = null;
                    visualDisplayer();
                    System.out.println();
                    consoleDisplayer();
                    k = i;
                    l = j;

                } else {
                    tipBoard.setText("Destination is too far.");
                }

            } else {
                tipBoard.setText("Soldier can't step any more.");
            }
        }
    }
}