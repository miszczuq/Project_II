import javax.swing.*;
import java.awt.event.ActionEvent;

public class Action extends AbstractAction {
    GameWindow gameWindow;
    public Action( GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.gameStatusChange();
    }
}
