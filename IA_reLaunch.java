import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public class IA_reLaunch implements Serializable{
    
    public IA_reLaunch() throws Exception
    {

    }

    public void launch() throws Exception
    {

        FileInputStream fileIn = new FileInputStream("IA_userINFO.ser");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        @SuppressWarnings("unchecked")
        HashMap<Integer, IA_User> deSerializaHashMapUser = (HashMap<Integer, IA_User>)objectIn.readObject();

        IA_User.changeHash(deSerializaHashMapUser);

        fileIn.close();
        objectIn.close();

        FileInputStream fileInput = new FileInputStream("IA_administratorINFO.ser");
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        @SuppressWarnings("unchecked")
        HashMap<String, IA_SystemAdministrator> deSerializeHashMapAdministrator = (HashMap<String, IA_SystemAdministrator>)objectInput.readObject();
 
        IA_SystemAdministrator.updateHash(deSerializeHashMapAdministrator);

        fileInput.close();
        objectInput.close();

    }
}
