package strategyGame;

import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Battlefield extends JFrame implements ActionListener{

    private final int size = 10;
    private JButton[][] buttons;
    private Unit[][] matrix;
    private JLabel unitData;
    private JLabel playerData;
    private int k;
    private int l;
    private int i;
    private int j;
    private Color alarm = new Color(210, 50, 50);
    private Color roast = new Color(220, 90, 30);
    private Color trepp = new Color(150, 220, 30);
    private Color fog = new Color(120, 170, 170);
    private Color drape = new Color(250, 240, 100);
    private Color grass = new Color(90, 240, 70);


    public Battlefield() {
        setTitle("Battlefield");
        setBounds(0,0, 1165, 820);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel field = new JPanel();
        field.setLayout(null);
        field.setBackground(drape);
        field.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        add(field);

        playerData = new JLabel();
        playerData.setBounds(775, 65, 305, 60);
        playerData.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        playerData.setFont(new Font("Verdana", Font.BOLD, 15));
        playerData.setHorizontalAlignment(SwingConstants.LEFT);
        playerData.setVerticalAlignment(SwingConstants.TOP);
        playerData.setText("Player Information");
        playerData.setForeground(Color.white);
        playerData.setOpaque(true);
        playerData.setBackground(fog);
        field.add(playerData);

        unitData = new JLabel();
        unitData.setBounds(775, 585, 305, 125);
        unitData.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        unitData.setFont(new Font("Verdana", Font.BOLD, 15));
        unitData.setHorizontalAlignment(SwingConstants.LEFT);
        unitData.setVerticalAlignment(SwingConstants.TOP);
        unitData.setText("Unit Information");
        unitData.setForeground(Color.white);
        unitData.setOpaque(true);
        unitData.setBackground(fog);
        field.add(unitData);

        matrix = new Unit[size][size];
        buttons = new JButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(65 + i * 65, 65 + j * 65, 60, 60);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setBackground(grass);
                // button.getInsets(new Insets(0, 0, 0, 0));
                button.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttons[i][j] = button;
                // button.setVisible(true);

                button.setActionCommand(i + " " + j);
                button.addActionListener(this);
                field.add(button);
            }
        }

        ButtonGroup options = new ButtonGroup();

        JButton attack = new JButton();
        attack.setBounds(775, 195, 305, 60);
        attack.setFont(new Font("Verdana", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attack");
        attack.setBackground(alarm);
        options.add(attack);
        field.add(attack);

        JButton move = new JButton();
        move.setBounds(775, 260, 305, 60);
        move.setFont(new Font("Verdana", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Move");
        move.setBackground(roast);
        options.add(move);
        field.add(move);

        JButton createWarrior = new JButton();
        createWarrior.setBounds(775, 325, 150, 60);
        createWarrior.setFont(new Font("Verdana", Font.BOLD, 15));
        createWarrior.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createWarrior.setText("Create Warrior");
        createWarrior.setBackground(trepp);
        options.add(createWarrior);
        field.add(createWarrior);

        JButton createArcher = new JButton();
        createArcher.setBounds(775, 390, 150, 60);
        createArcher.setFont(new Font("Verdana", Font.BOLD, 15));
        createArcher.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArcher.setText("Create Archer");
        createArcher.setBackground(trepp);
        options.add(createArcher);
        field.add(createArcher);

        JButton createPaladin = new JButton();
        createPaladin.setBounds(775, 455, 150, 60);
        createPaladin.setFont(new Font("Verdana", Font.BOLD, 15));
        createPaladin.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createPaladin.setText("Create Paladin");
        createPaladin.setBackground(trepp);
        options.add(createPaladin);
        field.add(createPaladin);

        JButton createMedicamp = new JButton();
        createMedicamp.setBounds(930, 325, 150, 60);
        createMedicamp.setFont(new Font("Verdana", Font.BOLD, 15));
        createMedicamp.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createMedicamp.setText("Create Medicamp");
        createMedicamp.setBackground(trepp);
        options.add(createMedicamp);
        field.add(createMedicamp);

        JButton createArchery = new JButton();
        createArchery.setBounds(930, 390, 150, 60);
        createArchery.setFont(new Font("Verdana", Font.BOLD, 15));
        createArchery.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createArchery.setText("Create Archery");
        createArchery.setBackground(trepp);
        options.add(createArchery);
        field.add(createArchery);

        JButton createStables = new JButton();
        createStables.setBounds(930, 455, 150, 60);
        createStables.setFont(new Font("Verdana", Font.BOLD, 15));
        createStables.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        createStables.setText("Create Stables");
        createStables.setBackground(trepp);
        options.add(createStables);
        field.add(createStables);

        k = -1;
        l = -1;

    }

    public Unit[][] getMatrix() {
        return this.matrix;
    }

    public Unit getUnit(int i, int j) {
        return matrix[i][j];
    }

    public void setUnit(Unit unit, int i, int j) {
        matrix[i][j] = unit;
    }

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
                }
            }
        }
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        String[] coords = event.split(" ");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        i = x;
        j = y;

        if (matrix[j][i] != null && !matrix[j][i].getIsSelected() && k == -1) {
            buttons[i][j].setBackground(Color.orange);
            matrix[j][i].select();
            unitData.setText(matrix[j][i].toString());
            k = i;
            l = j;

        } else if (matrix[j][i] != null && !matrix[j][i].getIsSelected() && k != -1) {
            buttons[k][l].setBackground(grass);
            matrix[l][k].deselect();
            buttons[i][j].setBackground(Color.orange);
            matrix[j][i].select();
            unitData.setText(matrix[j][i].toString());
            k = i;
            l = j;

        } else if (matrix[j][i] != null && matrix[j][i].getIsSelected()) {
            buttons[i][j].setBackground(grass);
            matrix[j][i].deselect();
            unitData.setText("Unit Information");
            k = -1;
            l = -1;

        } else if (matrix[j][i] == null && matrix[l][k].isSelected) {
            buttons[k][l].setBackground(grass);
            buttons[k][l].setText("");
            matrix[j][i] = matrix[l][k];
            buttons[i][j].setBackground(Color.orange);
            matrix[l][k] = null;
            visualDisplayer();
            System.out.println();
            consoleDisplayer();
            k = i;
            l = j;

        }
    }
}