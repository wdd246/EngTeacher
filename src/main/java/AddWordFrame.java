import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Flow;

public class AddWordFrame extends JFrame implements ActionListener {
    private JTextField enWordTextField,plWordTextField;
            JLabel enLabel,plLabel;
            JButton buttonAccept;
    public AddWordFrame(Rectangle parentFrameBounds){
        super("Dodaj słowo...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(parentFrameBounds);
        setLayout(new FlowLayout());
        //setMaximumSize(new Dimension (100,200));
        setVisible(true);

        enLabel = new JLabel("Angielskie słówko: ");
        add(enLabel);

        enWordTextField = new JTextField(20);

        add(enWordTextField);

        plLabel = new JLabel("Tłumaczenie: ");
        add(plLabel);

        plWordTextField = new JTextField(20);
        add(plWordTextField);


        buttonAccept = new JButton("Zatwierdź");
        buttonAccept.addActionListener(this);
        add(buttonAccept);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonAccept){
            new MenuFrame();
            dispose();



            try{
                FileOutputStream file = new FileOutputStream("slowka.tmp");
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeUTF(enWordTextField.getText());
                out.close();
            }catch(Exception ex) {
                System.out.println(ex);
            }
        }

    }


}
