import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AddWordFrame extends JFrame implements ActionListener {

    private JTextField enWordTextField,plWordTextField;
            JLabel enLabel,plLabel;
            JButton buttonAccept;



    public AddWordFrame(Rectangle parentFrameBounds){
        super("Dodaj słowo...");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        boolean exist=false;
        int id;
        if(source == buttonAccept){
            new MenuFrame();


            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn2 = null;
                conn2 = DriverManager.getConnection("jdbc:mysql://remotemysql.com/AuQWpI0lIR?useSSL=false", "AuQWpI0lIR", "g581bHZRFA");
                Statement stmt2 = conn2.createStatement();
                System.out.println("Database is connected !");

                String query3 = "SELECT * FROM slowa where Angielskie_Slowko='" + enWordTextField.getText() + "' AND  Polskie_Slowko='" + plWordTextField.getText() +"'";

                ResultSet rs = stmt2.executeQuery(query3);
                while (rs.next())
                {
                    id = rs.getInt("ID");
                    if(id>0){
                        exist=true;
                    }
                }
                if(!exist) {
                    String query2 = "INSERT INTO slowa(Angielskie_Slowko, Polskie_Slowko) VALUES ('" + enWordTextField.getText() + "', '" + plWordTextField.getText() + "')";

                    //ResultSet rs = stmt.executeQuery(query);
                    System.out.println(query2);
                    stmt2.executeUpdate(query2);
                }
                conn2.close();

            }
            catch(Exception ex)
            {
                System.out.println("Error: "+ex);
            }


            dispose();




        }

    }


}
