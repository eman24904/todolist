package classes;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private JButton addTask;
    private JButton clear;

    public Footer() {
        this.setPreferredSize(new Dimension(200, 65));
        this.setBackground(Color.WHITE);

        addTask = new JButton("Add Task");
        clear = new JButton("Clear Completed");

        addTask.setFont(new Font("Serif", Font.BOLD, 20));
        clear.setFont(new Font("Serif", Font.BOLD, 20));

        addTask.setBackground(new Color(50,60,200));
        clear.setBackground(new Color(50,60,200));
        addTask.setForeground(Color.WHITE);
        clear.setForeground(Color.WHITE);


        this.add(addTask);
        this.add(Box.createHorizontalStrut(20));
        this.add(clear);
    }

    public JButton getNewTask() {

        return addTask;
    }

    public JButton getClear() {

        return clear;
    }
}