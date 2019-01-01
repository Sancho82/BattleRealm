package strategyGame;

import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class Battlefield extends JFrame {

    private final int size = 10;
    private JButton[][] buttons;
    private Table table;

    public Battlefield() {
        setTitle("Battlefield");
        setBounds(100,100, 1100, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel field = new JPanel();
        field.setLayout(null);
        field.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        add(field);

        buttons = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(50 + i * 65, 50 + j * 65, 60, 60);
                button.setFont(new Font("Arial", Font.PLAIN, 15));
                button.setBackground(Color.green);
                // button.getInsets(new Insets(0, 0, 0, 0));
                button.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                buttons[i][j] = button;
                // button.setVisible(true);
                field.add(button);
            }
        }

        ButtonGroup options = new ButtonGroup();

        JButton select = new JButton();
        select.setBounds(770, 50, 210, 60);
        select.setFont(new Font("Arial", Font.BOLD, 25));
        select.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        select.setText("Select");
        select.setBackground(Color.orange);
        options.add(select);
        field.add(select);

        JButton move = new JButton();
        move.setBounds(770, 115, 210, 60);
        move.setFont(new Font("Arial", Font.BOLD, 25));
        move.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        move.setText("Move");
        move.setBackground(Color.orange);
        options.add(move);
        field.add(move);

        JButton attack = new JButton();
        attack.setBounds(770, 180, 210, 60);
        attack.setFont(new Font("Arial", Font.BOLD, 25));
        attack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        attack.setText("Attack");
        attack.setBackground(Color.orange);
        options.add(attack);
        field.add(attack);

        JButton create = new JButton();
        create.setBounds(770, 245, 210, 60);
        create.setFont(new Font("Arial", Font.BOLD, 25));
        create.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        create.setText("Create");
        create.setBackground(Color.orange);
        options.add(select);
        field.add(create);

        ButtonGroup directions = new ButtonGroup();

        JButton up = new JButton();
        up.setBounds(840, 330, 80, 70);
        up.setFont(new Font("Arial", Font.BOLD, 20));
        up.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        up.setText("UP");
        up.setBackground(Color.YELLOW);
        directions.add(up);
        field.add(up);

        JButton left = new JButton();
        left.setBounds(750, 420, 80, 70);
        left.setFont(new Font("Arial", Font.BOLD, 20));
        left.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        left.setText("LEFT");
        left.setBackground(Color.YELLOW);
        directions.add(left);
        field.add(left);

        JButton right = new JButton();
        right.setBounds(930, 420, 80, 70);
        right.setFont(new Font("Arial", Font.BOLD, 20));
        right.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        right.setText("RIGHT");
        right.setBackground(Color.YELLOW);
        directions.add(right);
        field.add(right);

        JButton down = new JButton();
        down.setBounds(840, 510, 80, 70);
        down.setFont(new Font("Arial", Font.BOLD, 20));
        down.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        down.setText("DOWN");
        down.setBackground(Color.YELLOW);
        directions.add(down);
        field.add(down);

        JLabel dataBoard = new JLabel();
        dataBoard.setBounds(750, 600, 260, 95);
        dataBoard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        dataBoard.setFont(new Font("Verdana", Font.ITALIC, 15));
        dataBoard.setHorizontalAlignment(SwingConstants.CENTER);
        dataBoard.setVerticalAlignment(SwingConstants.TOP);
        dataBoard.setText("Information Board");
        dataBoard.setForeground(Color.WHITE);
        dataBoard.setOpaque(true);
        dataBoard.setBackground(Color.GRAY);
        field.add(dataBoard);

        table = new Table();
        tableDrawer();
    }


        // buttons[2][2].setText("clue");
        // buttons[2][2].setBackground(Color.red);

    public Table getTable() {
        return this.table;
    }

    public void tableDrawer() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table.getUnit(i, j) != null) {
                    buttons[i][j].setText(table.getUnit(i, j).getName());
                }
            }
        }
    }
}
