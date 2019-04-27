import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    public Dimension screenSize;


    public MenuFrame(){
        super("EngTeacher 1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2, 100, 100);
        setVisible(true);
    }

}
