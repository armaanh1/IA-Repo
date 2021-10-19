import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public class IA_reLaunch implements Serializable{
    
    FileInputStream fileIn = new FileInputStream("IA_userINFO.txt");
    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

    

    public IA_reLaunch() throws Exception
    {

    }

    public void launch() throws Exception
    {
        
        HashMap<Integer, IA_User> deSerializaHashMap = (HashMap<Integer, IA_User>)objectIn.readObject();

        IA_User.changeHash(deSerializaHashMap);
        System.out.println("Desiarilzed");
        System.out.println(deSerializaHashMap.toString());
        System.out.println("HashMap newly updated");
        System.out.println(IA_User.Users.toString());

        fileIn.close();
        objectIn.close();

    }
}
