import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CountryNameButton extends JLabel{
    //Color color;
    public CountryNameButton(){
    }
    public CountryNameButton(String text, int fontSize){
        super(text);
        setFont(new Font("Arial",Font.BOLD,fontSize));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setForeground(Color.RED);
                setBackground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setForeground(Color.BLACK);
                //setBackground(color);
            }

            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                Border b = BorderFactory.createLineBorder(Color.GRAY,3);
                setBorder(b);
            }

            @Override
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                setBorder(null);
            }
        });
    }

}
