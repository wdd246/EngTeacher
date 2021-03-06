import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


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


            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = null;
                conn = DriverManager.getConnection("jdbc:mysql://localhost/angielski","root", "");
                System.out.println("Database is connected !");

                Statement stmt = conn.createStatement() ;
                String query = "INSERT INTO slowa (Angielskie_Slowko, Polskie_Slowko)" + "VALUES (?,?)";

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, enWordTextField.getText());
                preparedStmt.setString (2, plWordTextField.getText());
                preparedStmt.execute();


                conn.close();

            }
            catch(Exception ex)
            {
                System.out.println("Error: "+ex);
            }


            dispose();




        }

    }


}
