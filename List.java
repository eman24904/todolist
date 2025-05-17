package classes;

import javax.swing.*;
import java.awt.*;

public class List extends JPanel {
    public List() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void updateNumbers() {
        Component[] listItems = this.getComponents();
        int count = 0;
        for (Component c : listItems) {
            if (c instanceof Task) {
                ((Task) c).changeIndex(++count);
                ((Task) c).revalidate(); // التأكد من تحديث كل مهمة
                ((Task) c).repaint();
            }
        }
        this.revalidate();
        this.repaint();
    }

    public void removeCompletedTasks() {
        Component[] items = getComponents();
        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i] instanceof Task && ((Task) items[i]).getState()) {
                this.remove(items[i]);
            }
        }
        updateNumbers();
        revalidate();
        repaint();
    }
}