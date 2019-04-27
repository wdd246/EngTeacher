import javax.swing.*;
import java.awt.*;

public class AddWordFrame extends JFrame {
    public AddWordFrame(Rectangle parentFrameBounds){
        super("Dodaj słowo...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(parentFrameBounds);
        setLayout(new FlowLayout());
        setVisible(true);

    }
}
