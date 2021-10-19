import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class IA_closeProgram implements Serializable
{
    
     

    public IA_closeProgram() throws Exception
    {



    }

    public void close(HashMap<Integer, IA_User> hashToSerialize) throws IOException
    {

    FileOutputStream fileout = new FileOutputStream("IA_userINFO.ser");
    ObjectOutputStream objectOut = new ObjectOutputStream(fileout);

        System.out.println(hashToSerialize.toString());
        
        objectOut.writeObject(hashToSerialize);
        fileout.close();
        objectOut.close();
        
    }

} 