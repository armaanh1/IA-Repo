import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;


public class IA_User implements Serializable{
    
    /*

    USER ATTRIBUTES:

    First Name & Last Name : MANDATORY
    Middle Name : OPTIONAL
    Username : MANDATORY
    Password : MANDATORY
    Position : MANDATORY
    Birthday : MANDATORY
        Birthday is broken up into 3 pieces: (Shown Below)
            Birth Month : MANDATORY
            Birth Day : MANDATORY
            Birth Year : MANDATORY
    SSN : MANDATORY
    Address : MANDATORY

    */

    public static HashMap<Integer, IA_User> Users = new HashMap<>();


    private String userAddress;
    private String fullName;
    private String firstName;
    private String lastName;
    private String middleName;
    private String userPassword;
    private String userPosition;
    private String compositeBirthday;
    private String addressStreetAndHouseNumber;
    private String addressCity;
    private String addressState;
    private String addressZipCode;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private int socialSecurityNumber;
    private String macaddress;
    private int userIDNumber;
    private int maxID = 999999;
    private int minID = 111111;
    private Boolean hasInternetConnection = true;

    FileWriter fw = new FileWriter("IA_User.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    // constructor with no middle name
    public IA_User (String addressStrHouNum, String addressCityName, String addressSt, String addressZip, String fName, String lName, String uPass, String uPosition, int bMonth, int bDay, int bYear, int ssn) throws Exception
    {

        try 
        {
            URL url = new URL("https://geeksforgeeks.org/");
            URLConnection connection = url.openConnection();
            connection.connect();
        } 
        catch (Exception e) {
            hasInternetConnection = false;
        }

        this.addressStreetAndHouseNumber = addressStrHouNum;
        this.addressCity = addressCityName;
        this.addressState = addressSt;
        this.addressZipCode = addressZip;
        this.userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
        this.firstName = fName;
        this.lastName = lName;
        this.middleName = null;
        this.userPassword = uPass;
        this.userPosition = uPosition;
        this.birthMonth = bMonth;
        this.birthDay = bDay;
        this.birthYear = bYear;
        this.socialSecurityNumber = ssn;
        this.fullName = fName+lastName;
        this.compositeBirthday = birthMonth + "/" + birthDay + "/" + birthYear;
        
        userIDNumber = (int)Math.floor(Math.random()*(maxID-minID+1)+minID);
        while(Users.containsKey(userIDNumber))
        {
            userIDNumber = (int)Math.floor(Math.random()*(maxID-minID+1)+minID);
        }

        System.out.println(userIDNumber);

        if(hasInternetConnection)
        {
            InetAddress localhost = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(localhost);
            byte[] mac = network.getHardwareAddress();
    
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) 
            {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            macaddress = sb.toString();
        }
        else
        {
            macaddress = null;
        }


        Users.put(userIDNumber, this);
        System.out.println(Users.toString());

    }

    // construcotr with middle name
    public IA_User (String addressStrHouNum, String addressCityName, String addressSt, String addressZip, String fName, String lName, String mName, String uPass, String uPosition, int bMonth, int bDay, int bYear, int ssn) throws Exception
    {

        try 
        {
            URL url = new URL("https://geeksforgeeks.org/");
            URLConnection connection = url.openConnection();
            connection.connect();
        } 
        catch (Exception e) {
            hasInternetConnection = false;
        }

        this.addressStreetAndHouseNumber = addressStrHouNum;
        this.addressCity = addressCityName;
        this.addressState = addressSt;
        this.addressZipCode = addressZip;
        this.userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
        this.firstName = fName;
        this.lastName = lName;
        this.middleName = mName;
        this.userPassword = uPass;
        this.userPosition = uPosition;
        this.birthMonth = bMonth;
        this.birthDay = bDay;
        this.birthYear = bYear;
        this.socialSecurityNumber = ssn;
        this.fullName = fName+lastName;
        this.compositeBirthday = birthMonth + "/" + birthDay + "/" + birthYear;


        if(hasInternetConnection)
        {
            InetAddress localhost = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(localhost);
            byte[] mac = network.getHardwareAddress();
    
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) 
            {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            macaddress = sb.toString();
        }
        else
        {
            macaddress = null;
        }

        userIDNumber = (int)Math.floor(Math.random()*(maxID-minID+1)+minID);
        while(Users.containsKey(userIDNumber))
        {
            userIDNumber = (int)Math.floor(Math.random()*(maxID-minID+1)+minID);
        }

        Users.put(userIDNumber, this);
        System.out.println(Users.toString());
        
    }

    // Accessor Method Start

    public String getUserAddress()
    {
        return userAddress;
    }

    public String getFirstName()
    {
        fullName = firstName + lastName;
        return firstName;
    }

    public String getLastName()
    {
        fullName = firstName + lastName;
        return lastName;
    }

    public String getFullName()
    {
        return fullName;
    }

    //returns middle name (if middleName = null) returns ""
    public String getMiddleName()
    {
        if(middleName != null)
        {
            return middleName;
        }
        else
        {
            return null;
        }
    }
    
    //returns userName
    public int getUserID()
    {
        return userIDNumber;
    }
    
     //returns userPasword
    public String getUserPassword()
    {
        return userPassword;
    }
    
    //returns composite birthday
    public String getBirthDate()
    {
        return compositeBirthday;
    }
    
    // returns userPosition
    public String getUserPosition()
    {
        return userPosition;
    }

    // gest SSN
    public int getsocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // Mutator Method Start

    public void changeUserAddress(String newUserAdress)
    {
        userAddress =  newUserAdress;
    }

    public void chageFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    public void changeLastName(String newLastName)
    {
        lastName = newLastName;
    }

    public void changeMiddleName(String newMiddleName)
    {
        if(middleName != null)
        {
            middleName = newMiddleName;
        }
        else if(middleName == null)
        {
            middleName = null;
        }
    }

    public void changeUserStreetAndHouseNumber(String sthounumb)
    {
        addressStreetAndHouseNumber = sthounumb;
        userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
    }

    public void changeUserCity(String city)
    {
        addressCity = city;
        userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
    }   

    public void changeUserState(String state)
    {
        addressState = state;
        userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
    }   

    public void changeUserZipCode(String zip)
    {
        addressZipCode = zip;
        userAddress = addressStreetAndHouseNumber + ", " + addressCity + ", " + addressState + " " + addressZipCode;
    }
    
    public void changeUserPassword(String newUserPassword)
    {
        userPassword = newUserPassword;
    }
    
    public void changeBirthDate(int newMonth, int newDate, int newYear)
    {
        compositeBirthday = newMonth + "/" + newDate + "/" + newYear;
    }
    
    public void changeUserPosition(String newUserPosition)
    {
        userPosition = newUserPosition;
    }

    public void writeUser(IA_User iau) throws IOException
    {

        if(iau.getMiddleName() == null)
        {
            bw.write("USER CREATED: \n");
            bw.write("  Date: " + formatter.format(date) + "\n");
            if(hasInternetConnection)
            {

                bw.write("  MAC Address: " + macaddress + "\n");
            
            }
            else
            {

                bw.write("  Mac Address: Not connected to the internet, unable to get mac-address\n");

            }
            bw.write("  About User: \n");
            bw.write("      Address: " + userAddress + "\n");
            bw.write("      First Name: " + firstName + "\n");

            if (this.middleName == null)
            {

                bw.write("      Middle Name: " + "" + "\n");
            
            }

            bw.write("      Last Name: " + lastName + "\n");
            bw.write("      User ID: " + userIDNumber + "\n");
            bw.write("      User Password: " + userPassword + "\n");
            bw.write("      Birth Month: " + birthMonth + "\n"); 
            bw.write("      Birth Day: " + birthDay + "\n"); 
            bw.write("      Birth Year: " + birthYear + "\n"); 
            bw.write("      User SSN: " + socialSecurityNumber + "\n");
            bw.flush();

            bw.flush();
            bw.close();
        }

        else
        {

            bw.write("USER CREATED: \n");
            bw.write("  Date: " + formatter.format(date) + "\n");
            if(hasInternetConnection)
            {

                bw.write("  MAC Address: " + macaddress + "\n");

            }

            else
            {

                bw.write("  Mac Address: Not connected to the internet, unable to get mac-address \n");
            
            }

            bw.write("  About User: \n");
            bw.write("      Address: " + userAddress + "\n");
            bw.write("      First Name: " + firstName + "\n");

            if (this.middleName != null)
            {

                bw.write("      Middle Name: " + middleName + "\n");
            
            }

            bw.write("      Last Name: " + lastName + "\n");
            bw.write("      User ID: " + userIDNumber + "\n");
            bw.write("      User Password: " + userPassword + "\n");
            bw.write("      Birth Month: " + birthMonth + "\n"); 
            bw.write("      Birth Day: " + birthDay + "\n"); 
            bw.write("      Birth Year: " + birthYear + "\n"); 
            bw.write("      User SSN: " + socialSecurityNumber + "\n");
            bw.flush();

            bw.flush();
            bw.close();     

        }

    }

    // boolean method to return authentication of login
    public boolean authentication() throws Exception
    {
        // gets current mac address
        InetAddress localhost = InetAddress.getLocalHost();
        NetworkInterface network = NetworkInterface.getByInetAddress(localhost);
		byte[] mac = network.getHardwareAddress();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) 
        {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        String validationMac = sb.toString();

        //compares against stored mac address
        if(validationMac == macaddress)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean checkPassword(IA_User check, String pass)
    {

        String checkPass = check.getUserPassword();

        if(pass == checkPass)
        {
            return true;
        }

        else
        {
            return false;
        }
    }


    // the two methods below are used to serialize and deserialize the hash map
    public static HashMap<Integer, IA_User> getUserList()
    {
        return Users;
    }

    public static void changeHash(HashMap<Integer, IA_User> hashMapToUpdateUsers)
    {
        Users = hashMapToUpdateUsers;
    }


}