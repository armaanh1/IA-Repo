import java.util.HashMap;

public class IA_SystemAdministrator
{

    public static HashMap<String, IA_SystemAdministrator> SystemAdministrators = new HashMap<>();

    private String systemAdminUserName;
    private String systemAdminPassword;

    public IA_SystemAdministrator(String pass)
    {

        systemAdminPassword = pass;
        systemAdminUserName = "admin";

        SystemAdministrators.put(systemAdminUserName, this);

    }


    public String getUserName()
    {

        return this.systemAdminUserName;
    
    }

    public String getPassword()
    {

        return this.systemAdminPassword;

    }

    public void changeUserName(String newUName)
    {

        this.systemAdminUserName = newUName;
    
    }

    public void changeUserPassword(String newUPass)
    {

        this.systemAdminPassword = newUPass;
    
    }

}
