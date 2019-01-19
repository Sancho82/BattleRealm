package strategyGame.mvp;

import strategyGame.colors.Colors;
import strategyGame.units.Unit;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Displayer extends JFrame implements ActionListener, MainContract.View {

    private MainContract.Presenter dashBoard;

    private JPanel battlePanel;

    private final int size;
    private JButton[][] buttons;
    private JButton[] optionButtons;

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

        buttons = new JButton[size][size];
        optionButtons = new JButton[9];

        colors = new Colors();

        setTitle("Battlefield");
        setBounds(0,0, 1165, 820);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        battlePanel = new JPanel();
        battlePanel.setLayout(null);
        battlePanel.setBackground(colors.getDrape());
        battlePanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        add(battlePanel);

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
                battlePanel.add(button);
            }
        }

        attack = new JButton();
        attack.setBounds(775, 195, 305, 60);
        attack.setFont(new Font("Verdana", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attackrange");
        battlePanel.add(attack);
        attack.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 0 ? -1 : 0);
            dashBoard.optionsHandler();
        });

        move = new JButton();
        move.setBounds(775, 260, 305, 60);
        move.setFont(new Font("Verdana", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Moverange");
        battlePanel.add(move);
        move.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 1 ? -1 : 1);
            dashBoard.optionsHandler();
        });

        endTurn = new JButton();
        endTurn.setBounds(775, 650, 305, 60);
        endTurn.setFont(new Font("Verdana", Font.BOLD, 25));
        endTurn.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        endTurn.setText("End Turn");
        battlePanel.add(endTurn);
        endTurn.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 2 ? -1 : 2);
            dashBoard.optionsHandler();
        });

        createWarrior = new JButton();
        createWarrior.setBounds(775, 325, 150, 60);
        createWarrior.setFont(new Font("Verdana", Font.BOLD, 15));
        createWarrior.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createWarrior.setText("Create Warrior");
        battlePanel.add(createWarrior);
        createWarrior.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 3 ? -1 : 3);
            dashBoard.optionsHandler();
        });

        createArcher = new JButton();
        createArcher.setBounds(775, 390, 150, 60);
        createArcher.setFont(new Font("Verdana", Font.BOLD, 15));
        createArcher.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArcher.setText("Create Archer");
        battlePanel.add(createArcher);
        createArcher.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 4 ? -1 : 4);
            dashBoard.optionsHandler();
        });


        createPaladin = new JButton();
        createPaladin.setBounds(775, 455, 150, 60);
        createPaladin.setFont(new Font("Verdana", Font.BOLD, 15));
        createPaladin.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createPaladin.setText("Create Paladin");
        battlePanel.add(createPaladin);
        createPaladin.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 5 ? -1 : 5);
            dashBoard.optionsHandler();
        });

        createMediCamp = new JButton();
        createMediCamp.setBounds(930, 325, 150, 60);
        createMediCamp.setFont(new Font("Verdana", Font.BOLD, 15));
        createMediCamp.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createMediCamp.setText("Create Medicamp");
        battlePanel.add(createMediCamp);
        createMediCamp.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 6 ? -1 : 6);
            dashBoard.optionsHandler();
        });

        createArchery = new JButton();
        createArchery.setBounds(930, 390, 150, 60);
        createArchery.setFont(new Font("Verdana", Font.BOLD, 15));
        createArchery.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArchery.setText("Create Archery");
        battlePanel.add(createArchery);
        createArchery.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 7 ? -1 : 7);
            dashBoard.optionsHandler();
        });

        createStables = new JButton();
        createStables.setBounds(930, 455, 150, 60);
        createStables.setFont(new Font("Verdana", Font.BOLD, 15));
        createStables.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createStables.setText("Create Stables");
        battlePanel.add(createStables);
        createStables.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 8 ? -1 : 8);
            dashBoard.optionsHandler();
        });

        optionButtonsLoader();
        optionButtonsDefaultColorSetter();

        tipBoard = new JLabel();
        tipBoard.setBounds(775, 65, 305, 60);
        tipBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tipBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        tipBoard.setHorizontalAlignment(SwingConstants.LEFT);
        tipBoard.setVerticalAlignment(SwingConstants.TOP);
        tipBoard.setForeground(Color.white);
        tipBoard.setOpaque(true);
        tipBoard.setBackground(colors.getFog());
        battlePanel.add(tipBoard);

        playerBoard = new JLabel();
        playerBoard.setBounds(775, 130, 305, 60);
        playerBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        playerBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        playerBoard.setHorizontalAlignment(SwingConstants.LEFT);
        playerBoard.setVerticalAlignment(SwingConstants.TOP);
        playerBoard.setForeground(Color.white);
        playerBoard.setOpaque(true);
        playerBoard.setBackground(colors.getFog());
        battlePanel.add(playerBoard);

        unitBoard = new JLabel();
        unitBoard.setBounds(775, 520, 305, 125);
        unitBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        unitBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        unitBoard.setHorizontalAlignment(SwingConstants.LEFT);
        unitBoard.setVerticalAlignment(SwingConstants.TOP);
        unitBoard.setForeground(Color.white);
        unitBoard.setOpaque(true);
        unitBoard.setBackground(colors.getFog());
        battlePanel.add(unitBoard);

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

    public JPanel getBattlePanel() {
        return battlePanel;
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
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (dashBoard.getGame().getMatrix()[i][j] != null) {
                    System.out.print(dashBoard.getGame().getMatrix()[i][j].getPrefix() + " ");

                } else {
                    System.out.print("XX ");
                }
            }
        }
    }

    @Override
    public void showSelectedUnit() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Unit unit = dashBoard.getGame().getMatrix()[i][j];
                if (unit != null && unit.getIsSelected()) {
                    buttons[j][i].setBackground(Color.orange);

                } else {
                    buttons[j][i].setBackground(colors.getGrass());
                }
            }
        }
    }

    @Override
    public void optionButtonsLoader() {
        optionButtons[0] = attack;
        optionButtons[1] = move;
        optionButtons[2] = endTurn;
        optionButtons[3] = createWarrior;
        optionButtons[4] = createArcher;
        optionButtons[5] = createPaladin;
        optionButtons[6] = createMediCamp;
        optionButtons[7] = createArchery;
        optionButtons[8] = createStables;
    }

    @Override
    public void optionButtonsHighlighter(int selection) {
        optionButtonsDefaultColorSetter();

        switch (selection) {

            case 0:
                attack.setBackground(colors.getAlarm());
                break;

            case 1:
                move.setBackground(colors.getRoast());
                break;

            case 2:
                endTurn.setBackground(colors.getPeach());
                break;

            case 3:
                createWarrior.setBackground(colors.getOcean());
                break;

            case 4:
                createArcher.setBackground(colors.getOcean());
                break;

            case 5:
                createPaladin.setBackground(colors.getOcean());
                break;

            case 6:
                createMediCamp.setBackground(colors.getOcean());
                break;

            case 7:
                createArchery.setBackground(colors.getOcean());
                break;

            case 8:
                createStables.setBackground(colors.getOcean());
                break;
        }

        System.out.println("\n" + dashBoard.getOptionSelected());
    }

    @Override
    public void optionButtonsDefaultColorSetter() {
        attack.setBackground(colors.getSolar());
        move.setBackground(colors.getSolar());
        endTurn.setBackground(colors.getSolar());
        createWarrior.setBackground(colors.getTrepp());
        createArcher.setBackground(colors.getTrepp());
        createPaladin.setBackground(colors.getTrepp());
        createMediCamp.setBackground(colors.getTrepp());
        createArchery.setBackground(colors.getTrepp());
        createStables.setBackground(colors.getTrepp());

    }

    @Override
    public void highLightRange(Position position, int range, Color color) {
        int x = position.getX();
        int y = position.getY();
        for (int i = x - range; i <= x + range; i++) {
            for (int j = y - range; j <= y + range; j++) {
                if (i > -1 && j > -1 && i < 10 && j < 10) {
                    buttons[j][i].setBackground(color);
                }
            }
        }
    }

    public void removeHighLight(Position position, int range) {
        int x = position.getX();
        int y = position.getY();
        for (int i = x - range; i <= x + range; i++) {
            for (int j = y - range; j <= y + range; j++) {
                if (i > -1 && j > -1 && i < 10 && j < 10) {
                    buttons[j][i].setBackground(Color.orange);
                    showSelectedUnit();
                }
            }
        }
    }
}