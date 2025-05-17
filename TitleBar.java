package classes;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {
    public TitleBar() {
        this.setPreferredSize(new Dimension(500, 80));
        this.setBackground(new Color(50,60,200));
        JLabel titleText = new JLabel("To-Do List");
        titleText.setPreferredSize(new Dimension(400, 70));
        titleText.setFont(new Font("Serif", Font.BOLD, 30));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setForeground(Color.WHITE);
        this.add(titleText);
    }
}