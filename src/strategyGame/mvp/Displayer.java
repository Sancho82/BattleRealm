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

public class Displayer extends JFrame implements ActionListener, MainContract.View {

    private MainContract.Presenter dashBoard;

    private final int size;
    public JButton[][] buttons;

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

    public Displayer() {
        dashBoard = new DashBoard(this);
        size = dashBoard.getGame().getSize();

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
        unitBoard.setForeground(Color.white);
        unitBoard.setOpaque(true);
        unitBoard.setBackground(colors.getFog());
        field.add(unitBoard);

        buttons = new JButton[size][size];

        ButtonGroup gameBoard = new ButtonGroup();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(65 + i * 65, 65 + j * 65, 60, 60);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setBackground(colors.getGrass());
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

        setTipBoardDefault();
        dashBoard.showActivePlayerStats();
        setUnitBoardDefault();

        consoleDisplayer();
        visualDisplayer();

    }

    //region Getters

    public MainContract.Presenter getDashBoard() {
        return dashBoard;
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

    //endregion

    //region Setters

    @Override
    public void setUnitBoard(Unit unit) {
        unitBoard.setText(unit.toString());
    }

    @Override
    public void setUnitBoardDefault() {
        unitBoard.setText("Unit information");
    }

    @Override
    public void setPlayerBoard(Player player) {
        playerBoard.setText(player.toString());
    }

    @Override
    public void setPlayerBoardDefault() {
        playerBoard.setText("Player Information");
    }

    @Override
    public void setTipBoard(String text) {
        tipBoard.setText(text);
    }

    @Override
    public void setTipBoardDefault() {
        tipBoard.setText("Tips");
    }

    //endregion

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] coords = e.getActionCommand().split(" ");

        int x = Integer.valueOf(coords[1]);
        int y = Integer.valueOf(coords[0]);

        dashBoard.clickField(new Position(x, y));

    }

    @Override
    public void visualDisplayer() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dashBoard.getGame().getMatrix()[i][j] != null) {
                    buttons[j][i].setIcon(dashBoard.getGame().getMatrix()[i][j].getIcon());

                } else {
                    buttons[j][i].setIcon(null);
                }
            }
        }
    }

    @Override
    public void consoleDisplayer() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (dashBoard.getGame().getMatrix()[i][j] != null) {
                    System.out.print(dashBoard.getGame().getMatrix()[i][j].getPrefix() + " ");

                } else {
                    System.out.print("X ");
                }
            }
        }
    }

    @Override
    public void showSelectedUnit() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Unit unit = dashBoard.getGame().getMatrix()[i][j];
                if (unit != null) {
                    if (unit.getIsSelected()) {
                        buttons[j][i].setBackground(Color.orange);

                    } else {
                        buttons[j][i].setBackground(colors.getGrass());
                    }
                }
            }
        }
    }

    @Override
    public void highLightStepRange(Position position, Soldier soldier) {
        int x = position.getX();
        int y = position.getY();
        int s = soldier.getSteppesLeft();
        for (int i = x - s; i <= x + s; i++) {
            for (int j = x - s; j <= x + s; j++) {
                if (i > 0 && j > 0 && i != j) {
                    buttons[j][i].setBackground(colors.getDream());
                }
            }
        }
    }

    public void removeHighLight(Position position, Soldier soldier) {
        int x = position.getX();
        int y = position.getY();
        int s = soldier.getSteppesLeft();
        for (int i = x - s; i <= x + s; i++) {
            for (int j = x - s; j <= x + s; j++) {
                if (i > 0 && j > 0 && i != j) {
                    buttons[j][i].setBackground(colors.getGrass());
                }
            }
        }
    }
}
