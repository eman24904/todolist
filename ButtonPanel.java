package classes;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JButton {
    public ButtonPanel(String text) {
        super(text);
        this.setPreferredSize(new Dimension(140, 40));
        this.setBackground(Color.PINK);
        this.setForeground(Color.white);
        this.setFocusPainted(false);
        this.setFont(new Font("Serif", Font.BOLD, 14));
    }
}