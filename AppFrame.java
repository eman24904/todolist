package classes;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private List list;
    private TitleBar title;
    private Footer footer;
    private JButton newTask;
    private JButton clear;
    private JScrollPane scrollPane;

    public AppFrame() {
        this.setTitle("To Do List Application");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.setLocationRelativeTo(null);

        title = new TitleBar();
        footer = new Footer();
        list = new List();

        scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(title, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);

        newTask = footer.getNewTask();
        clear = footer.getClear();

        newTask.addActionListener(e -> {
            Task task = new Task();
            list.add(task);
            list.updateNumbers();
            list.revalidate();
            list.repaint();
        });

        clear.addActionListener(e -> {
            list.removeCompletedTasks();
        });

        this.setVisible(true);
    }
}