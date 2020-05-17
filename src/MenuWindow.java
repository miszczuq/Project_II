import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow;

public class MenuWindow extends JFrame {
    Color backgroundColor = new Color(255, 209, 26);
    //private GameWindow gameWindow;

    public MenuWindow(){
        setLayout(null);
        getContentPane().setBackground(backgroundColor);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));
        buttons.setBackground(backgroundColor);

        ClickableLabel exit = new ClickableLabel("Exit",backgroundColor);
        ClickableLabel newGame = new ClickableLabel("New Game",backgroundColor);
        ClickableLabel highScores = new ClickableLabel("High Scores",backgroundColor);
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Object[] level = {"easy","medium","hard"};
                String s = (String)JOptionPane.showInputDialog(MenuWindow.this, "Difficult: ","Choice difficult",JOptionPane.QUESTION_MESSAGE,null,level,level[0]);

                //DIFFICULTY LEVEL
                if(s != null && s.length() > 0) {
                    switch (s) {
                        case "easy":
                            System.out.println("easy");
                            /*MenuWindow.this.gameWindow =*/ new GameWindow(2);
                            break;
                        case "medium":
                            System.out.println("medium");
                            /*MenuWindow.this.gameWindow = */new GameWindow(3);
                            break;
                        case "hard":
                            System.out.println("hard");
                            /*MenuWindow.this.gameWindow =*/ new GameWindow(4);
                            break;
                    }
                    dispose();
                }
            }
        });

        highScores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ScoreWindow();
                dispose();
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        buttons.add(newGame);
        buttons.add(highScores);
        buttons.add(exit);
        buttons.setBounds(100,100,300,250);
        add(buttons);

        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
