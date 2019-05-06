import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame implements ActionListener {

    private String pl,ang;
            JButton buttonCheck, buttonNext;
            JTextField textTranslation;
            int counter, id;
            Connection conn = null;


    public Test(Rectangle parentBounds, int counter){

        super("Test trwa...");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(new FlowLayout());
        setBounds(parentBounds);
        setVisible(true);

//        if(counter != 0) {
//            this.counter = counter - 1;
//        }else
//            dispose();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/AuQWpI0lIR?useSSL=false" ,"AuQWpI0lIR", "g581bHZRFA");
            System.out.println("Database is connected !");

            Statement stmt = conn.createStatement() ;
            String query = "SELECT ID,Angielskie_Slowko,Polskie_Slowko FROM slowa ORDER BY RAND() LIMIT 1;" ;
            //String query = "SELECT powtorka.powtorka_ID,slowa.Angielskie_Slowko,slowa.Polskie_Slowko FROM slowa,powtorka WHERE slowa.ID = powtorka.slowo_ID;" ;




            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //id = rs.getInt("powtorka_ID");
                id = rs.getInt("ID");
                ang = rs.getString("Angielskie_Slowko");
                pl = rs.getString("Polskie_Slowko");
                System.out.println(ang + " " + pl);
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
                new Test(getBounds(),counter);

                /*try
                {
                    Class.forName("com.mysql.jdbc.Driver");

                    conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/AuQWpI0lIR?useSSL=false" ,"AuQWpI0lIR", "g581bHZRFA");
                    Statement stmt = conn.createStatement() ;
                    String query = "DELETE FROM powtorka WHERE powtorka_ID =" + id ;
                    //ResultSet rs = stmt.executeQuery(query);

                    stmt.executeUpdate(query);


                    conn.close();

                }
                catch(Exception ex)
                {
                    System.out.println("Error: "+ex);
                }*/



                dispose();
            }else{

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");

                    conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/AuQWpI0lIR?useSSL=false" ,"AuQWpI0lIR", "g581bHZRFA");
                    Statement stmt = conn.createStatement() ;
                    String query = "INSERT INTO powtorka(slowo_ID) VALUES (" + id + ")";
                    //ResultSet rs = stmt.executeQuery(query);

                    stmt.executeUpdate(query);


                    conn.close();

                }
                catch(Exception ex)
                {
                    System.out.println("Error: "+ex);
                }
            }

        }

    }
}
