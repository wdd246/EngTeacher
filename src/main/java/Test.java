import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame implements ActionListener {

    private String pl,ang;
            JButton buttonCheck, buttonNext;
            JTextField textTranslation;
            int counter;

    public Test(Rectangle parentBounds){

        super("Test trwa...");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(new FlowLayout());
        setBounds(parentBounds);
        setVisible(true);

        /*if(counter == null)
            counter = 3;*/

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/angielski","root", "");
            System.out.println("Database is connected !");

            Statement stmt = conn.createStatement() ;
            String query = "SELECT Angielskie_Slowko,Polskie_Slowko FROM Slowa ORDER BY RAND() LIMIT 1;" ;

            ResultSet rs = stmt.executeQuery(query);


            while (rs.next())
            {
                //int id = rs.getInt("ID");
                ang = rs.getString("Angielskie_Slowko");
                pl = rs.getString("Polskie_Slowko");


                // print the results
                System.out.println(ang + pl);
            }


            conn.close();

        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
        }



        JLabel labelPlWord = new JLabel(pl);
        labelPlWord.setFont(new Font("Arial", Font.BOLD,30));
        add(labelPlWord);

        textTranslation = new JTextField(20);
        textTranslation.setFont(new Font("Arial", Font.PLAIN,20));
        add(textTranslation);


        buttonCheck = new JButton("Sprawdź");
        buttonCheck.addActionListener(this);
        add(buttonCheck);

        buttonNext = new JButton("Odłóż");
        buttonNext.addActionListener(this);
        add(buttonNext);
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonCheck){
            if(textTranslation.getText().contentEquals(ang)) {

                dispose();
            }

        }

    }
}
