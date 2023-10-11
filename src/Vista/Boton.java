package Vista;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    private int x;
    private int y;

    public Boton(int x, int y) {
        this.x = x;
        this.y = y;
        this.setBackground(Color.BLACK);
        this.setAction();
        this.setFocusable(true);
        this.setMargin(new Insets(2, 2, 2, 2));
        this.setFont(new Font("Arial Unicode MS", Font.PLAIN, 30));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.RED);
    }

    public void setAction(){
        this.setActionCommand(x + "," + y);
    }

}
