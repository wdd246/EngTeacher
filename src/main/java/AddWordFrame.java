import javax.swing.*;
import java.awt.*;

public class AddWordFrame extends JFrame {
    private JTextField enWordTextField,plWordTextField;

    public AddWordFrame(Rectangle parentFrameBounds){
        super("Dodaj słowo...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(parentFrameBounds);
        setLayout(new GridBagLayout());
        setVisible(true);

        enWordTextField = new JTextField(20);
        add(enWordTextField);



    }
}
