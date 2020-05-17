import javafx.event.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickableLabel extends JLabel{
    Color color;
    public ClickableLabel(){
    }
    public ClickableLabel(String text, Color color){
        super(text);
        setFont(new Font(null,Font.BOLD,40));
        this.color = color;
        setBackground(color);
        setOpaque(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        Border b = BorderFactory.createLineBorder(Color.GRAY,5);
        setBorder(b);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                ClickableLabel.this.setForeground(Color.RED);
                ClickableLabel.this.setBackground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                ClickableLabel.this.setForeground(Color.BLACK);
                ClickableLabel.this.setBackground(color);
            }
        });
    }


}
