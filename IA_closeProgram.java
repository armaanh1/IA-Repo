import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class IA_closeProgram implements Serializable
{
    
    private FileOutputStream fileout = new FileOutputStream("IA_userINFO.ser");
    private ObjectOutputStream objectOut = new ObjectOutputStream(fileout);

    public IA_closeProgram() throws Exception
    {



    }

    public void close(HashMap<Integer, IA_User> hashToSerialize) throws IOException
    {

        System.out.println(hashToSerialize.toString());
        
        objectOut.writeObject(hashToSerialize);
        objectOut.flush();
        objectOut.close();
        
    }

} 