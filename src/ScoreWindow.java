import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreWindow extends JFrame {
    public ScoreWindow(){
        setLayout(new BorderLayout());

        JList<String> list = new JList<>(ScoreFileManager.getScoreList());
        add(new JScrollPane(list),BorderLayout.CENTER);

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jp,BorderLayout.PAGE_END);

        JButton back = new JButton("back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWindow();
                ScoreWindow.this.dispose();
            }
        });
        jp.add(back);


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
