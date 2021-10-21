import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IA_closeProgram implements Serializable
{
    
     

    public IA_closeProgram() throws Exception
    {



    }

    public void close() throws IOException
    {

        FileOutputStream fileout = new FileOutputStream("IA_userINFO.ser");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
        
        objectOut.writeObject(IA_User.Users);
        fileout.close();
        objectOut.close();

        FileOutputStream fileOutput = new FileOutputStream("IA_administratorINFO.ser");
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        objectOutput.writeObject(IA_SystemAdministrator.SystemAdministrators);
        fileOutput.close();
        objectOutput.close();
        
    }

} 