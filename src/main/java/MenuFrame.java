import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {
    public Dimension screenSize;
           JButton addWordButton,startTestButton;

    public MenuFrame(){
        super("EngTeacher 1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2, 400, 200);
        setVisible(true);










        addWordButton = new JButton("Dodaj słowo");
        addWordButton.addActionListener(this);
        add(addWordButton);

        startTestButton = new JButton("Ropocznij test");
        startTestButton.addActionListener(this);
        add(startTestButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == addWordButton) {
            new AddWordFrame(getBounds());
        }else if(source == startTestButton){
            new Test(getBounds(),3);
        }
        dispose();
    }
}
