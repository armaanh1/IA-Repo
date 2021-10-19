import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;

public class IA_User_Logger implements Serializable{
    
    private IA_User user;
    private Boolean authenticated;
    private Boolean isConnected;
    private String ipExternal;
    private InetAddress localhost;

    FileWriter fw = new FileWriter("IA_User_Login.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);

    public IA_User_Logger(IA_User IAU) throws Exception
    {
        user = IAU;
        authenticated = user.authentication();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        // checks for internet connection
        try 
        {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            isConnected = true;
        } 
        catch (MalformedURLException e) 
        {
            isConnected = false;             
        } 
        catch (IOException e) 
        {
            isConnected = false;             
        }
        catch(Exception e)
        {
            isConnected = false;
        }

        // checks external ip
        if(isConnected)
        {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            ipExternal = in.readLine();
        } 

        // writing logs if authentication passes
        if(authenticated)
        {
            // id authentication passes and connected to the internet
            if(isConnected)
            {
                bw.write("  Date: " + formatter.format(date) + "\n");
                bw.write("  User: " + user.getFirstName() + " " + user.getLastName() + "\n");
                bw.write("  User ID: " + user.getUserID());
                bw.write("  System User: " + System.getProperty("user.name") + "\n");
                bw.write("  About System: \n");
                bw.write("      OS: " + System.getProperty("os.name") + "\n");
                bw.write("      Version: " + System.getProperty("os.version") + "\n");
                bw.write("      Architecture: " + System.getProperty("os.arch") + "\n");
                bw.write("      IP Address: \n");
                bw.write("          Internal: " + (localhost.getHostAddress()) + "\n");
                bw.write("          External: " + ipExternal + "\n");
                bw.flush();
            }
            // id authentication passes and not connected to the internet
            else
            {
                bw.write("  Date: " + formatter.format(date) + "\n");
                bw.write("  User: " + user.getFirstName() + " " + user.getLastName() + "\n");
                bw.write("  User ID: " + user.getUserID());
                bw.write("  System User: " + System.getProperty("user.name") + "\n");
                bw.write("  About System: \n");
                bw.write("      OS: " + System.getProperty("os.name") + "\n");
                bw.write("      Version: " + System.getProperty("os.version") + "\n");
                bw.write("      Architecture: " + System.getProperty("os.arch") + "\n");
                bw.flush();
            }
        }
        
        // writing logs if authentication fails
        else
        {
            // id authentication fails and connected to the internet
            if(isConnected)
            {
                bw.write("AUTHENTICATION FAILED: DEVICE SIGNATURE DOES NO MATCH THAT OF USER \n");
                bw.write("  Date: " + formatter.format(date) + "\n");
                bw.write("  User: " + user.getFirstName() + " " + user.getLastName() + "\n");
                bw.write("  User ID: " + user.getUserID());
                bw.write("  System User: " + System.getProperty("user.name") + "\n");
                bw.write("  About System: \n");
                bw.write("      OS: " + System.getProperty("os.name") + "\n");
                bw.write("      Version: " + System.getProperty("os.version") + "\n");
                bw.write("      Architecture: " + System.getProperty("os.arch") + "\n");
                bw.write("      IP Address: \n");
                bw.write("          Internal: " + (localhost.getHostAddress()) + "\n");
                bw.write("          External: " + ipExternal + "\n");
                bw.flush();
            }
            // id authentication fails and not connected to the internet
            else 
            {
                bw.write("AUTHENTICATION FAILED: DEVICE SIGNATURE DOES NO MATCH THAT OF USER \n");
                bw.write("  Date: " + formatter.format(date) + "\n");
                bw.write("  User: " + user.getFirstName() + " " + user.getLastName() + "\n");
                bw.write("  User ID: " + user.getUserID());
                bw.write("  System User: " + System.getProperty("user.name") + "\n");
                bw.write("  About System: \n");
                bw.write("      OS: " + System.getProperty("os.name") + "\n");
                bw.write("      Version: " + System.getProperty("os.version") + "\n");
                bw.write("      Architecture: " + System.getProperty("os.arch") + "\n");
                bw.flush();
            }
        }

        bw.flush();
        bw.close();
    }

}
