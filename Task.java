package classes;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Task extends JPanel {
    private JLabel index;
    private JTextField taskName;
    private JButton done;
    private JSpinner dateField;
    private JSpinner timeField;
    private JCheckBox reminderCheck;
    private JButton colorButton;
    private boolean checked;

    public Task() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));

        this.setBackground(Color.pink);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        checked = false;

        JPanel topRow = new JPanel(new BorderLayout(5, 0));
        topRow.setOpaque(false);
        //eman
        taskName = new JTextField();
        taskName.setPreferredSize(new Dimension(100, 50)); // Smaller text field
        topRow.add(taskName, BorderLayout.CENTER);
        // rania
        done = new JButton("Done");
        done.setPreferredSize(new Dimension(60, 20)); // Smaller button
        done.setFocusPainted(false);
        done.setBackground(new Color(0, 150, 30));
        done.setForeground(Color.WHITE);
        topRow.add(done, BorderLayout.EAST);
        // eman
        done.addActionListener(e -> {
            try {
                String taskText = taskName.getText().trim();
                Date date = (Date) dateField.getValue();
                Date time = (Date) timeField.getValue();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                if (taskText.isEmpty()) {
                    throw new Exception("Please enter a valid task name.");
                }

                if (reminderCheck.isSelected()) {
                    JOptionPane.showMessageDialog(this,
                            "⏰ Reminder set for: " + dateFormat.format(date) + " " + timeFormat.format(time));
                    Toolkit.getDefaultToolkit().beep();
                }

                changeState();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.add(topRow);
        this.add(Box.createVerticalStrut(5));

        JPanel middleRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        middleRow.setOpaque(false);

        // Date picker -eman-
        dateField = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateField, "yyyy-MM-dd");
        dateField.setEditor(dateEditor);
        dateField.setPreferredSize(new Dimension(90, 20)); // Smaller size
        middleRow.add(dateField);

        // Time picker -eman-
        timeField = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeField, "HH:mm");
        timeField.setEditor(timeEditor);
        timeField.setPreferredSize(new Dimension(60, 20)); // Smaller size
        middleRow.add(timeField);
        // -majd-
        reminderCheck = new JCheckBox("Reminder");
        reminderCheck.setBackground(Color.pink);
        middleRow.add(reminderCheck);

        this.add(middleRow);
        this.add(Box.createVerticalStrut(5));

        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomRow.setOpaque(false);

        colorButton = new JButton("Choose Color");
        colorButton.setPreferredSize(new Dimension(100, 20)); // Smaller button
        bottomRow.add(colorButton);

        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Choose Color", getBackground());
            if (chosenColor != null) {
                setBackground(chosenColor);
                taskName.setBackground(Color.white);
                reminderCheck.setBackground(chosenColor);
            }
        });

        this.add(bottomRow);
    }

    public void changeIndex(int num) {
        if (index == null) {
            index = new JLabel();
            this.add(index, 0);
        }
        index.setText("Task " + num);
        this.revalidate();
    }

    public boolean getState() {
        return checked;
    }

    public void changeState() {
        this.setBackground(Color.LIGHT_GRAY);
        taskName.setBackground(Color.LIGHT_GRAY);
        checked = true;
        revalidate();
    }
}