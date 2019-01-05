package strategyGame;

import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Battlefield extends JFrame implements ActionListener{

    private final int size = 10;
    private JButton[][] buttons;
    private Unit[][] matrix;
    private JLabel dataBoard;
    private int k;
    private int l;

    public Battlefield() {
        setTitle("Battlefield");
        setBounds(100,100, 1100, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel field = new JPanel();
        field.setLayout(null);
        field.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        add(field);

        dataBoard = new JLabel();
        dataBoard.setBounds(750, 550, 260, 145);
        dataBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        dataBoard.setFont(new Font("Verdana", Font.ITALIC, 15));
        dataBoard.setHorizontalAlignment(SwingConstants.LEFT);
        dataBoard.setVerticalAlignment(SwingConstants.TOP);
        dataBoard.setText("Information Board");
        dataBoard.setForeground(Color.WHITE);
        dataBoard.setOpaque(true);
        dataBoard.setBackground(Color.GRAY);
        field.add(dataBoard);

        matrix = new Unit[size][size];
        buttons = new JButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(50 + i * 65, 50 + j * 65, 60, 60);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setBackground(Color.green);
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

        JButton move = new JButton();
        move.setBounds(770, 50, 210, 60);
        move.setFont(new Font("Arial", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Move");
        move.setBackground(Color.orange);
        options.add(move);
        field.add(move);

        JButton attack = new JButton();
        attack.setBounds(770, 115, 210, 60);
        attack.setFont(new Font("Arial", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attack");
        attack.setBackground(Color.orange);
        options.add(attack);
        field.add(attack);

        JButton create = new JButton();
        create.setBounds(770, 180, 210, 60);
        create.setFont(new Font("Arial", Font.BOLD, 25));
        create.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        create.setText("Create");
        create.setBackground(Color.orange);
        options.add(create);
        field.add(create);

        ButtonGroup directions = new ButtonGroup();

        JButton up = new JButton();
        up.setBounds(840, 270, 80, 70);
        up.setFont(new Font("Arial", Font.BOLD, 20));
        up.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        up.setText("UP");
        up.setBackground(Color.YELLOW);
        directions.add(up);
        field.add(up);

        JButton left = new JButton();
        left.setBounds(750, 360, 80, 70);
        left.setFont(new Font("Arial", Font.BOLD, 20));
        left.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        left.setText("LEFT");
        left.setBackground(Color.YELLOW);
        directions.add(left);
        field.add(left);

        JButton right = new JButton();
        right.setBounds(930, 360, 80, 70);
        right.setFont(new Font("Arial", Font.BOLD, 20));
        right.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        right.setText("RIGHT");
        right.setBackground(Color.YELLOW);
        directions.add(right);
        field.add(right);

        JButton down = new JButton();
        down.setBounds(840, 450, 80, 70);
        down.setFont(new Font("Arial", Font.BOLD, 20));
        down.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        down.setText("DOWN");
        down.setBackground(Color.YELLOW);
        directions.add(down);
        field.add(down);

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
                if (this.getUnit(i, j) != null) {
                    buttons[i][j].setText(this.getUnit(i, j).getPrefix());
                }
            }
        }
    }

    public Unit someOneSelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                if (matrix[i][j].getIsSelected()) {
                    return matrix[i][j];
                }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        String[] coords = event.split(" ");
        int i = Integer.parseInt(coords[0]);
        int j = Integer.parseInt(coords[1]);

        if (matrix[i][j] != null && !matrix[i][j].getIsSelected() && k == -1) {
            buttons[i][j].setBackground(Color.orange);
            matrix[i][j].select();
            dataBoard.setText(matrix[i][j].toString());
            k = i;
            l = j;

        } else if (matrix[i][j] != null && !matrix[i][j].getIsSelected() && k != -1) {
            buttons[k][l].setBackground(Color.green);
            matrix[k][l].deselect();
            buttons[i][j].setBackground(Color.orange);
            matrix[i][j].select();
            dataBoard.setText(matrix[i][j].toString());
            k = i;
            l = j;

        } else if (matrix[i][j] != null && matrix[i][j].getIsSelected()) {
            buttons[i][j].setBackground(Color.green);
            matrix[i][j].deselect();
            dataBoard.setText("Information Board");
            k = -1;
            l = -1;

        } else if (matrix[i][j] == null && k != -1) {
            buttons[k][l].setBackground(Color.green);
            matrix[k][l].deselect();
            dataBoard.setText("Information Board");
            k = -1;
            l = -1;

        }
    }
}