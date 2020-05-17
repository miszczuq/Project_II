import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame  {
    public GameWindow(int difficulty){
        final int WAOFC= JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        Font myFont = new Font("Arial",Font.BOLD,34);
        setLayout(new BorderLayout());

        //test
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("X: "+e.getX()+"  Y: "+e.getY());
            }
        });
        //test

        JPanel topBar = new JPanel();
        add(topBar,BorderLayout.PAGE_START);

        JLabel dayTimer = new JLabel("Day: 1");
        dayTimer.setFont(myFont);
        topBar.add(dayTimer);

        JLabel pointsLabel = new JLabel("Points: 0");
        pointsLabel.setFont(myFont);
        topBar.add(pointsLabel);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel mods = new JPanel();
        mods.setLayout(new GridLayout(4,1));
        for(int i = 1 ; i <= 4 ; i++){
            mods.add(new JButton(i+ "przycisk"));
        }
        contentPane.add(mods,BorderLayout.LINE_END);

        //Mapa IMAGE
        JPanel screen = new JPanel(){
            ImageIcon worldMap = new ImageIcon("worldMap.jpg");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(worldMap.getImage(),0,0,1150,800,this);
            }
        };
        screen.setLayout(null);

        JLabel map = new JLabel();
        screen.add(map);
        contentPane.add(screen, BorderLayout.CENTER);

        contentPane.getInputMap(WAOFC).put(KeyStroke.getKeyStroke("control shift Q"),"press q");
        contentPane.getActionMap().put("press q", new Action(this));

        add(contentPane,BorderLayout.CENTER);

        //Dodawane kraje
        Country polska = new Country(420421,"Polska",difficulty);
        Country rosja = new Country(9420421,"Rosja",difficulty);
        MyTimer.addVirusSpreadListener(polska);
        MyTimer.addVirusSpreadListener(rosja);

        //Przyciski krajowe
        CountryNameButton test = new CountryNameButton("Kraj",13);
        test.setBounds(70,250,80,20);
        screen.add(test);

        CountryNameButton rosjaP = new CountryNameButton("Ruskie",13);
        test.setBounds(765,270,80,20);
        screen.add(rosjaP);

        VirusSpreadListener spreadListener = new VirusSpreadListener() {
            @Override
            public void SpreadVirus() {
                dayTimer.setText("Day: "+MyTimer.getDay());
                pointsLabel.setText("Points: "+Points.getPoints());
            }
        };
        MyTimer.addVirusSpreadListener(spreadListener);

        //new MyTimer();

        setTitle("Anti Plague Inc.");
        setResizable(false);
        setSize(1250,820);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void gameStatusChange() {
        String s = (String)JOptionPane.showInputDialog(GameWindow.this, "Type your name: ","Anonymous"); //Wprowadzanie nicku
        if(s != null) {
            ScoreFileManager.addScore(s);
            new MenuWindow();
            dispose();
        }
    }
}
