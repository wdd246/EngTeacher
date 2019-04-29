import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Test {
    public Test(){
        try{
            FileInputStream file = new FileInputStream("slowka.tmp");
            ObjectInputStream in = new ObjectInputStream(file);
            System.out.println((String)in.readObject());
            in.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
