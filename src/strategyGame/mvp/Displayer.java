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

    private JPanel battlePanel;

    private final int size;
    private JButton[][] buttons;
    private JButton[] optionButtons;

    private JLabel unitBoard;
    private JLabel playerBoard;
    private JLabel tipBoard;

    private JPanel introPanel;
    private JPanel exitPanel;

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
        setBounds(0,0, 1800, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        battlePanel = new JPanel();
        battlePanel.setLayout(null);
        battlePanel.setBackground(colors.getDrape());
        battlePanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(150 + i * 75, 100 + j * 75, 70, 70);
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
        attack.setBounds(1050, 250, 305, 70);
        attack.setFont(new Font("Verdana", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attackrange");
        battlePanel.add(attack);
        attack.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 0 ? -1 : 0);
            dashBoard.optionsHandler();
        });

        move = new JButton();
        move.setBounds(1050, 325, 305, 70);
        move.setFont(new Font("Verdana", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Moverange");
        battlePanel.add(move);
        move.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 1 ? -1 : 1);
            dashBoard.optionsHandler();
        });

        endTurn = new JButton();
        endTurn.setBounds(1050, 775, 305, 70);
        endTurn.setFont(new Font("Verdana", Font.BOLD, 25));
        endTurn.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        endTurn.setText("End Turn");
        battlePanel.add(endTurn);
        endTurn.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 2 ? -1 : 2);
            dashBoard.optionsHandler();
        });

        createWarrior = new JButton();
        createWarrior.setBounds(1050, 400, 150, 70);
        createWarrior.setFont(new Font("Verdana", Font.BOLD, 15));
        createWarrior.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createWarrior.setText("Create Warrior");
        battlePanel.add(createWarrior);
        createWarrior.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 3 ? -1 : 3);
            dashBoard.optionsHandler();
        });

        createArcher = new JButton();
        createArcher.setBounds(1050, 475, 150, 70);
        createArcher.setFont(new Font("Verdana", Font.BOLD, 15));
        createArcher.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArcher.setText("Create Archer");
        battlePanel.add(createArcher);
        createArcher.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 4 ? -1 : 4);
            dashBoard.optionsHandler();
        });


        createPaladin = new JButton();
        createPaladin.setBounds(1050, 550, 150, 70);
        createPaladin.setFont(new Font("Verdana", Font.BOLD, 15));
        createPaladin.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createPaladin.setText("Create Paladin");
        battlePanel.add(createPaladin);
        createPaladin.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 5 ? -1 : 5);
            dashBoard.optionsHandler();
        });

        createMediCamp = new JButton();
        createMediCamp.setBounds(1205, 400, 150, 70);
        createMediCamp.setFont(new Font("Verdana", Font.BOLD, 15));
        createMediCamp.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createMediCamp.setText("Create Medicamp");
        battlePanel.add(createMediCamp);
        createMediCamp.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 6 ? -1 : 6);
            dashBoard.optionsHandler();
        });

        createArchery = new JButton();
        createArchery.setBounds(1205, 475, 150, 70);
        createArchery.setFont(new Font("Verdana", Font.BOLD, 15));
        createArchery.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArchery.setText("Create Archery");
        battlePanel.add(createArchery);
        createArchery.addActionListener(e -> {
            dashBoard.setOptionSelected(dashBoard.getOptionSelected() == 7 ? -1 : 7);
            dashBoard.optionsHandler();
        });

        createStables = new JButton();
        createStables.setBounds(1205, 550, 150, 70);
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
        tipBoard.setBounds(1050, 100, 305, 70);
        tipBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tipBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        tipBoard.setHorizontalAlignment(SwingConstants.LEFT);
        tipBoard.setVerticalAlignment(SwingConstants.TOP);
        tipBoard.setForeground(Color.white);
        tipBoard.setOpaque(true);
        tipBoard.setBackground(colors.getOcean());
        battlePanel.add(tipBoard);

        playerBoard = new JLabel();
        playerBoard.setBounds(1050, 175, 305, 70);
        playerBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        playerBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        playerBoard.setHorizontalAlignment(SwingConstants.LEFT);
        playerBoard.setVerticalAlignment(SwingConstants.TOP);
        playerBoard.setForeground(Color.white);
        playerBoard.setOpaque(true);
        playerBoard.setBackground(colors.getOcean());
        battlePanel.add(playerBoard);

        unitBoard = new JLabel();
        unitBoard.setBounds(1050, 625, 305, 145);
        unitBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        unitBoard.setFont(new Font("Verdana", Font.BOLD, 15));
        unitBoard.setHorizontalAlignment(SwingConstants.LEFT);
        unitBoard.setVerticalAlignment(SwingConstants.TOP);
        unitBoard.setForeground(Color.white);
        unitBoard.setOpaque(true);
        unitBoard.setBackground(colors.getOcean());
        battlePanel.add(unitBoard);

        setTipBoardDefault();
        dashBoard.showActivePlayerStats();
        setUnitBoardDefault();

        JLabel introLabel = new JLabel();
        introLabel.setBounds(0, 0, 1800, 1000);
        introLabel.setOpaque(true);
        introLabel.setIcon(new ImageIcon(getClass().getResource("../wallpapers/Background_Intro.png")));

        introPanel = new JPanel();
        introPanel.setLayout(null);
        introPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        JTextField player1 = new JTextField();
        player1.setBounds(500, 370, 200, 30);
        player1.setFont(new Font("Verdana", Font.BOLD, 15));
        player1.setBackground(colors.getAlarm());
        player1.setForeground(Color.white);

        JTextField player2 = new JTextField();
        player2.setBounds(1000, 370, 200, 30);
        player2.setFont(new Font("Verdana", Font.BOLD, 15));
        player2.setBackground(colors.getOcean());
        player2.setForeground(Color.white);

        JButton startButton = new JButton("Start");
        startButton.setBounds(800, 860, 100, 50);
        startButton.setFont(new Font("Verdana", Font.BOLD, 17));
        startButton.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        startButton.setForeground(Color.white);
        startButton.setBackground(colors.getFog());

        introPanel.add(introLabel);
        introPanel.add(player1);
        introPanel.add(player2);
        introPanel.add(startButton);
        add(introPanel);
        repaint();

        startButton.addActionListener(e -> {
            dashBoard.startGame(player1.getText(), player2.getText());
        });

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
    public void startBattle() {
        remove(introPanel);
        add(battlePanel);
        consoleDisplayer();
        visualDisplayer();
        repaint();
    }

    @Override
    public void visualDisplayer() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dashBoard.getGame().getMatrix()[i][j] != null) {
                    buttons[j][i].setIcon(dashBoard.getGame().getMatrix()[i][j].getIcon());
                    if (dashBoard.getGame().getMatrix()[i][j].getColor().equals("Red")) {
                        buttons[j][i].setBackground(colors.getPeach());

                    } else if (dashBoard.getGame().getMatrix()[i][j].getColor().equals("Blue")) {
                        buttons[j][i].setBackground(colors.getFog());
                    }

                } else {
                    buttons[j][i].setIcon(null);
                    buttons[j][i].setBackground(colors.getGrass());
                }
            }
        }
    }

    @Override
    public void toolTipSetter() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Unit unit = dashBoard.getGame().getMatrix()[i][j];
                if (unit != null) {
                    if (unit.getHp() == unit.getMAX_HP()) {
                        if (unit instanceof Soldier) buttons[j][i].setToolTipText("Uninjured");
                        else buttons[j][i].setToolTipText("Undamaged");

                    } else if (unit.getHp() < unit.getMAX_HP() && unit.getHp() >= unit.getMAX_HP() * 0.5) {
                        if (unit instanceof Soldier) buttons[j][i].setToolTipText("Injured");
                        else buttons[j][i].setToolTipText("Damaged");

                    } else {
                       buttons[j][i].setToolTipText("Weak");
                    }
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
                createWarrior.setBackground(colors.getLife());
                break;

            case 4:
                createArcher.setBackground(colors.getLife());
                break;

            case 5:
                createPaladin.setBackground(colors.getLife());
                break;

            case 6:
                createMediCamp.setBackground(colors.getLife());
                break;

            case 7:
                createArchery.setBackground(colors.getLife());
                break;

            case 8:
                createStables.setBackground(colors.getLife());
                break;
        }

        System.out.println("\n" + dashBoard.getOptionSelected());
    }

    @Override
    public void optionButtonsDefaultColorSetter() {
        attack.setBackground(colors.getGold());
        move.setBackground(colors.getGold());
        endTurn.setBackground(colors.getGold());
        createWarrior.setBackground(colors.getTrepp());
        createArcher.setBackground(colors.getTrepp());
        createPaladin.setBackground(colors.getTrepp());
        createMediCamp.setBackground(colors.getTrepp());
        createArchery.setBackground(colors.getTrepp());
        createStables.setBackground(colors.getTrepp());

    }

    @Override
    public void showSelectedUnit(Unit[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[j][i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
                Unit unit = matrix[i][j];
                if (unit != null) {
                    if (unit.getIsSelected()) {
                        buttons[j][i].setBackground(Color.orange);

                    } else if (unit.getColor().equals("Red")){
                        buttons[j][i].setBackground(colors.getPeach());

                    } else if (unit.getColor().equals("Blue")) {
                        buttons[j][i].setBackground(colors.getFog());

                    }

                } else {
                    buttons[j][i].setBackground(colors.getGrass());
                }
            }
        }
    }

    @Override
    public void highLightRange(Unit[][] matrix, Position position, int range, Color color1, Color color2) {
        int x = position.getX();
        int y = position.getY();
        for (int i = x - range; i <= x + range; i++) {
            for (int j = y - range; j <= y + range; j++) {
                if (i > -1 && j > -1 && i < 10 && j < 10) {
                    Unit unit = matrix[i][j];
                    Player player = dashBoard.getGame().getPlayerList().get(dashBoard.getGame().getCurrentPlayerIndex());
                    if (unit == null) {
                        buttons[j][i].setBackground(color2);
                        buttons[j][i].setBorder(BorderFactory.createSoftBevelBorder(0, color2, color2));

                    } else if (!unit.getColor().equals(player.getColor())) {
                        buttons[j][i].setBackground(color1);
                    }
                }
            }
        }
    }

    @Override
    public void finalMessage(String winnerName) {
        String message = "Congratulations " + winnerName + ", \r\nyou won the game!";

        exitPanel = new JPanel();
        exitPanel.setLayout(null);
        exitPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        JLabel exitMessageLabel = new JLabel();
        exitMessageLabel.setBounds(600, 150, 700, 50);
        exitMessageLabel.setFont(new Font("Verdana", Font.ITALIC, 30));
        exitMessageLabel.setForeground(Color.black);
        exitMessageLabel.setText(message);

        JLabel exitlabel = new JLabel();
        exitlabel.setBounds(0, 0, 1800, 1000);
        exitlabel.setOpaque(true);
        exitlabel.setIcon(new ImageIcon(getClass().getResource("../wallpapers/Background_Victory.png")));

        JButton okButton = new JButton("Ok");
        okButton.setBounds(800, 860, 100, 50);
        okButton.setFont(new Font("Verdana", Font.BOLD, 17));
        okButton.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        okButton.setForeground(Color.white);
        okButton.setBackground(colors.getFog());

        exitPanel.add(exitMessageLabel);
        exitPanel.add(exitlabel);
        exitPanel.add(okButton);
        remove(battlePanel);
        repaint();
        add(exitPanel);

        new Thread(() -> {
            try {
                    Thread.sleep(5000);
                    System.exit(0);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }).start();

        okButton.addActionListener(e -> {

        });
        //System.exit(0);
    }
}