import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.Toolkit;

public class IA_GUI implements ActionListener, ItemListener, WindowListener, Serializable
{
    
    private JFrame frame = new JFrame();

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension d = toolkit.getScreenSize();

    private double screenWidth = d.getWidth();
    private double screenHeight = d.getHeight();

    private String[] birthMonths = {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String[] birthDays = {"DD", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] birthYears = {"YYYY", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};
    
    private JPanel loginContentPanel = new JPanel();
    private JPanel newUserContentPanel = new JPanel();

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel createNewUserFirstNameLabel;
    private JLabel createNewUserLastNameLabel;
    private JLabel createNewUserMiddleNameLabel;
    private JLabel createNewUserHasMiddleNameLabel;
    private JLabel createNewUserPasswordLabel;
    private JLabel createNewUserEmployeePositionLabel;
    private JLabel createNewUserEmployeePositionEmployeeLabel;
    private JLabel createNewUserEmployeePositionSalesAssociateLabel;
    private JLabel createNewUserEmployeePositionOnSiteTechnicianLabel;
    private JLabel createNewUserEmployeePositionHumanResourcesLabel;
    private JLabel createNewUserEmployeePositionInternLabel;
    private JLabel createNewUserEmployeePositionOffSiteTechnicianLabel;
    private JLabel createNewUserBirthDateLabel;
    private JLabel createNewUserSocialSecurityNumberLabel;
    private JLabel createNewUserAddresStreetAndHouseNumberLabel;
    private JLabel createNewUserAddressCityLabel;
    private JLabel createNewUserAddressStateLabel;
    private JLabel createNewUserAddressZipCodLabel;

    private JCheckBox createNewUserMiddleNameCheckBox;
    private JCheckBox createNewUserEmployeePositionEmployeeCheckBox;
    private JCheckBox createNewUserEmployeePositionSalesAssociateCheckBox;
    private JCheckBox createNewUserEmployeePositionOnSiteTechnicianCheckBox;
    private JCheckBox createNewUserEmployeePositionHumanResourcesCheckBox;
    private JCheckBox createNewUserEmployeePositionInternCheckBox;
    private JCheckBox createNewUserEmployeePositionOffSiteTechnicianCheckBox;

    private JComboBox<String> createNewUserBirthDayComboBox;
    private JComboBox<String> createNewUserBirthMonthComboBox;
    private JComboBox<String> createNewUserBirthYearComboBox;

    private JTextField usernameTextField;
    private JTextField createNewUserFirstNameTextField;
    private JTextField createNewUserLastNameTextField;
    private JTextField createNewUserMiddleNameTextField;
    private JTextField createNewUserPasswordTextField;
    private JTextField createNewUserSocialSecurityNumberTextField;
    private JTextField createNewUserAddresStreetAndHouseNumberTextField;
    private JTextField createNewUserAddressCityTextField;
    private JTextField createNewUserAddressStateTextField;
    private JTextField createNewUserAddressZipCodTextField;

    private JPasswordField passwordPasswordField; 

    private JButton logInButton;
    private JButton createNewUserButton;
    private JButton createNewUserCreateUserButton;
    private JButton closeGui;

    private String userIDInput;
    private String userPasswordInput;
    private String userSelctedPosition;

    private int createNewUserNumberOfPositionsChecked = 0;

    private Boolean createNewuserMiddleNameIsChecked = false;
    private Boolean createNewUserEmployeePosition_isEmployee = false;
    private Boolean createNewUserEmployeePosition_isSalesAssociate = false;
    private Boolean createNewUserEmployeePosition_isOnSiteTechnician = false;
    private Boolean createNewUserEmployeePosition_isHumanResources = false;
    private Boolean createNewUserEmployeePosition_isIntern = false;
    private Boolean createNewUserEmployeePosition_isOffSiteTechnician = false;

    public void runProgram() throws Exception
    {

        IA_Project.guiIsActive = true;

        // IA_reLaunch rl = new IA_reLaunch();
        // rl.launch();

        frame.setSize((int)screenWidth-1, (int)screenHeight-1);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.add(loginContentPanel);

        loginContentPanel.setLayout(null);

        usernameLabel = new JLabel("User ID");
        usernameLabel.setBounds(10, 20, 80, 25);
        loginContentPanel.add(usernameLabel);

        usernameTextField = new JTextField(20);
        usernameTextField.setBounds(100, 20, 175, 20);
        loginContentPanel.add(usernameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginContentPanel.add(passwordLabel);

        passwordPasswordField = new JPasswordField(20);
        passwordPasswordField.setBounds(100, 50, 175, 20);
        loginContentPanel.add(passwordPasswordField);

        logInButton = new JButton();
        logInButton.setText("Log In");
        logInButton.setBounds(55, 110, 220, 25);
        logInButton.setName("Hello");
        logInButton.addActionListener(this);
        loginContentPanel.add(logInButton);

        createNewUserButton = new JButton("New Here? Click Me!");
        createNewUserButton.setForeground(new ColorUIResource(39, 149, 161));
        createNewUserButton.setBounds(55, 140, 220, 25);
        createNewUserButton.addActionListener(this);
        loginContentPanel.add(createNewUserButton);
        
        frame.setVisible(true);

    }

    private void mainScreen()
    {
        
        System.out.println("You're logged in!");

    }

    private void newUserScreen()
    {

        loginContentPanel.setVisible(false);
        newUserContentPanel.setLayout(null);

        createNewUserFirstNameLabel = new JLabel("First Name: ");
        createNewUserFirstNameLabel.setBounds(10, 20, 100, 25);
        newUserContentPanel.add(createNewUserFirstNameLabel);

        createNewUserFirstNameTextField = new JTextField(20);
        createNewUserFirstNameTextField.setBounds(100, 20, 175, 20);
        newUserContentPanel.add(createNewUserFirstNameTextField);

        createNewUserLastNameLabel = new JLabel("Last Name: ");
        createNewUserLastNameLabel.setBounds(10, 50, 100, 25);
        newUserContentPanel.add(createNewUserLastNameLabel);

        createNewUserLastNameTextField = new JTextField(20);
        createNewUserLastNameTextField.setBounds(100, 50, 175, 20);
        newUserContentPanel.add(createNewUserLastNameTextField);

        createNewUserHasMiddleNameLabel = new JLabel("Middle Name? ");
        createNewUserHasMiddleNameLabel.setBounds(10, 80, 100, 25);
        newUserContentPanel.add(createNewUserHasMiddleNameLabel);

        createNewUserMiddleNameCheckBox = new JCheckBox();
        createNewUserMiddleNameCheckBox.setBounds(100, 80, 25, 25);
        createNewUserMiddleNameCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserMiddleNameCheckBox);

        createNewUserMiddleNameLabel = new JLabel("Middle Name ");
        createNewUserMiddleNameTextField = new JTextField(20);

        createNewUserPasswordTextField = new JTextField(20);
        createNewUserPasswordTextField.setBounds(100, 110, 175, 20);
        newUserContentPanel.add(createNewUserPasswordTextField);

        createNewUserPasswordLabel = new JLabel("Password ");
        createNewUserPasswordLabel.setBounds(10, 110, 80, 25);
        newUserContentPanel.add(createNewUserPasswordLabel);
        
        createNewUserEmployeePositionLabel = new JLabel("Position: ");
        createNewUserEmployeePositionLabel.setBounds(10, 140, 80, 25);
        newUserContentPanel.add(createNewUserEmployeePositionLabel);

        createNewUserEmployeePositionEmployeeCheckBox = new JCheckBox();
        createNewUserEmployeePositionEmployeeCheckBox.setBounds(150, 170, 25, 25);
        createNewUserEmployeePositionEmployeeCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionEmployeeCheckBox);

        createNewUserEmployeePositionEmployeeLabel = new JLabel("Employee ");
        createNewUserEmployeePositionEmployeeLabel.setBounds(40, 170, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionEmployeeLabel);

        createNewUserEmployeePositionSalesAssociateCheckBox = new JCheckBox();
        createNewUserEmployeePositionSalesAssociateCheckBox.setBounds(150, 200, 25, 25);
        createNewUserEmployeePositionSalesAssociateCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateCheckBox);

        createNewUserEmployeePositionSalesAssociateLabel = new JLabel("Sales Associate ");
        createNewUserEmployeePositionSalesAssociateLabel.setBounds(40, 200, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateLabel);

        createNewUserEmployeePositionOnSiteTechnicianCheckBox = new JCheckBox();
        createNewUserEmployeePositionOnSiteTechnicianCheckBox.setBounds(150, 230, 25, 25);
        createNewUserEmployeePositionOnSiteTechnicianCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianCheckBox);

        createNewUserEmployeePositionOnSiteTechnicianLabel = new JLabel("On Site Tech ");
        createNewUserEmployeePositionOnSiteTechnicianLabel.setBounds(40, 230, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianLabel);

        // move to right of first 3
        createNewUserEmployeePositionHumanResourcesCheckBox = new JCheckBox();
        createNewUserEmployeePositionHumanResourcesCheckBox.setBounds(320, 170, 25, 25);
        createNewUserEmployeePositionHumanResourcesCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesCheckBox);

        createNewUserEmployeePositionHumanResourcesLabel = new JLabel("Human Resources ");
        createNewUserEmployeePositionHumanResourcesLabel.setBounds(200, 170, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesLabel);

        createNewUserEmployeePositionInternCheckBox = new JCheckBox();
        createNewUserEmployeePositionInternCheckBox.setBounds(320, 200, 25, 25);
        createNewUserEmployeePositionInternCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionInternCheckBox);

        createNewUserEmployeePositionInternLabel = new JLabel("Intern ");
        createNewUserEmployeePositionInternLabel.setBounds(200, 200, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionInternLabel);

        createNewUserEmployeePositionOffSiteTechnicianCheckBox = new JCheckBox();
        createNewUserEmployeePositionOffSiteTechnicianCheckBox.setBounds(320, 230, 25, 25);
        createNewUserEmployeePositionOffSiteTechnicianCheckBox.addItemListener(this);
        newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianCheckBox);

        createNewUserEmployeePositionOffSiteTechnicianLabel = new JLabel("Off Site Tech ");
        createNewUserEmployeePositionOffSiteTechnicianLabel.setBounds(200, 230, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianLabel);

        createNewUserBirthDateLabel = new JLabel("Birthday: ");    
        createNewUserBirthDateLabel.setBounds(10, 260, 100, 25);
        newUserContentPanel.add(createNewUserBirthDateLabel);

        createNewUserBirthDayComboBox = new JComboBox<String>(birthDays);
        createNewUserBirthDayComboBox.setBounds(175, 260, 75, 25);
        newUserContentPanel.add(createNewUserBirthDayComboBox);

        createNewUserBirthMonthComboBox = new JComboBox<String>(birthMonths);
        createNewUserBirthMonthComboBox.setBounds(100, 260, 75, 25);
        newUserContentPanel.add(createNewUserBirthMonthComboBox);

        createNewUserBirthYearComboBox = new JComboBox<String>(birthYears);
        createNewUserBirthYearComboBox.setBounds(250, 260, 85, 25);
        newUserContentPanel.add(createNewUserBirthYearComboBox);

        createNewUserSocialSecurityNumberLabel = new JLabel("SSN: ");
        createNewUserSocialSecurityNumberLabel.setBounds(10, 290, 100, 25);
        newUserContentPanel.add(createNewUserSocialSecurityNumberLabel);

        createNewUserSocialSecurityNumberTextField = new JTextField(20);
        createNewUserSocialSecurityNumberTextField.setBounds(100, 290, 175, 20);
        newUserContentPanel.add(createNewUserSocialSecurityNumberTextField);

        createNewUserAddresStreetAndHouseNumberLabel = new JLabel("Address: ");    
        createNewUserAddresStreetAndHouseNumberLabel.setBounds(10, 320, 100, 25);
        newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberLabel);

        createNewUserAddresStreetAndHouseNumberTextField = new JTextField(100);
        createNewUserAddresStreetAndHouseNumberTextField.setBounds(100, 320, 175, 20);
        newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberTextField);

        createNewUserAddressCityLabel = new JLabel("City: ");    
        createNewUserAddressCityLabel.setBounds(10, 350, 100, 25);
        newUserContentPanel.add(createNewUserAddressCityLabel);

        createNewUserAddressCityTextField = new JTextField(100);
        createNewUserAddressCityTextField.setBounds(100, 350, 175, 20);
        newUserContentPanel.add(createNewUserAddressCityTextField);

        createNewUserAddressStateLabel = new JLabel("State: ");    
        createNewUserAddressStateLabel.setBounds(10, 380, 100, 25);
        newUserContentPanel.add(createNewUserAddressStateLabel);

        createNewUserAddressStateTextField = new JTextField(2);
        createNewUserAddressStateTextField.setBounds(100, 380, 175, 20);
        newUserContentPanel.add(createNewUserAddressStateTextField);

        createNewUserAddressZipCodLabel = new JLabel("Zip Code: ");    
        createNewUserAddressZipCodLabel.setBounds(10, 410, 100, 25);
        newUserContentPanel.add(createNewUserAddressZipCodLabel);

        createNewUserAddressZipCodTextField = new JTextField(5);
        createNewUserAddressZipCodTextField.setBounds(100, 410, 175, 20);
        newUserContentPanel.add(createNewUserAddressZipCodTextField);

        createNewUserCreateUserButton = new JButton("Create New User");
        createNewUserCreateUserButton.setBounds(10, 440, 220, 25);
        createNewUserCreateUserButton.addActionListener(this);
        newUserContentPanel.add(createNewUserCreateUserButton);

        closeGui = new JButton("Close Gui");
        closeGui.setBounds(10, 470, 100, 25);
        closeGui.addActionListener(this);
        newUserContentPanel.add(closeGui);

        frame.add(newUserContentPanel);
        newUserContentPanel.setVisible(true);

    }

    public void middleNameOptionStateChnaged() 
    {
        
        if(createNewuserMiddleNameIsChecked)
        {

            if((createNewUserPasswordLabel.getParent() == newUserContentPanel) && 
            (createNewUserPasswordTextField.getParent() == newUserContentPanel))
            {

                newUserContentPanel.remove(createNewUserPasswordLabel);
                newUserContentPanel.remove(createNewUserPasswordTextField);

            }

        createNewUserMiddleNameLabel.setBounds(10, 110, 100, 25);
        newUserContentPanel.add(createNewUserMiddleNameLabel);

        createNewUserMiddleNameTextField.setBounds(100, 110, 175, 20);
        newUserContentPanel.add(createNewUserMiddleNameTextField);

        createNewUserPasswordLabel.setBounds(10, 140, 80, 25);
        newUserContentPanel.add(createNewUserPasswordLabel);

        createNewUserPasswordTextField.setBounds(100, 140, 175, 20);
        newUserContentPanel.add(createNewUserPasswordTextField);   

        createNewUserEmployeePositionLabel.setBounds(10, 170, 80, 25);
        newUserContentPanel.add(createNewUserEmployeePositionLabel);

        createNewUserEmployeePositionEmployeeCheckBox.setBounds(150, 200, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionEmployeeCheckBox);

        createNewUserEmployeePositionEmployeeLabel.setBounds(40, 200, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionEmployeeLabel);

        createNewUserEmployeePositionSalesAssociateCheckBox.setBounds(150, 230, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateCheckBox);

        createNewUserEmployeePositionSalesAssociateLabel.setBounds(40, 230, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateLabel);

        createNewUserEmployeePositionOnSiteTechnicianCheckBox.setBounds(150, 260, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianCheckBox);

        createNewUserEmployeePositionOnSiteTechnicianLabel.setBounds(40, 260, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianLabel);

        createNewUserEmployeePositionHumanResourcesCheckBox.setBounds(320, 200, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesCheckBox);

        createNewUserEmployeePositionHumanResourcesLabel.setBounds(200, 200, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesLabel);

        createNewUserEmployeePositionInternCheckBox.setBounds(320, 230, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionInternCheckBox);

        createNewUserEmployeePositionInternLabel.setBounds(200, 230, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionInternLabel);

        createNewUserEmployeePositionOffSiteTechnicianCheckBox.setBounds(320, 260, 25, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianCheckBox);

        createNewUserEmployeePositionOffSiteTechnicianLabel.setBounds(200, 260, 120, 25);
        newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianLabel);

        createNewUserBirthDateLabel.setBounds(10, 290, 100, 25);
        newUserContentPanel.add(createNewUserBirthDateLabel);

        createNewUserBirthDayComboBox.setBounds(175, 290, 75, 25);
        newUserContentPanel.add(createNewUserBirthDayComboBox);

        createNewUserBirthMonthComboBox.setBounds(100, 290, 75, 25);
        newUserContentPanel.add(createNewUserBirthMonthComboBox);

        createNewUserBirthYearComboBox.setBounds(250, 290, 85, 25);
        createNewUserBirthYearComboBox.setSelectedIndex(birthYears.length-19);
        newUserContentPanel.add(createNewUserBirthYearComboBox);

        createNewUserSocialSecurityNumberLabel.setBounds(10, 320, 100, 25);
        newUserContentPanel.add(createNewUserSocialSecurityNumberLabel);

        createNewUserSocialSecurityNumberTextField.setBounds(100, 320, 175, 20);
        newUserContentPanel.add(createNewUserSocialSecurityNumberTextField);

        // start from here
        createNewUserAddresStreetAndHouseNumberLabel.setBounds(10, 350, 100, 25);
        newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberLabel);

        createNewUserAddresStreetAndHouseNumberTextField.setBounds(100, 350, 175, 20);
        newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberTextField);

        createNewUserAddressCityLabel.setBounds(10, 380, 100, 25);
        newUserContentPanel.add(createNewUserAddressCityLabel);

        createNewUserAddressCityTextField.setBounds(100, 380, 175, 20);
        newUserContentPanel.add(createNewUserAddressCityTextField);

        createNewUserAddressStateLabel.setBounds(10, 410, 100, 25);
        newUserContentPanel.add(createNewUserAddressStateLabel);

        createNewUserAddressStateTextField.setBounds(100, 410, 175, 20);
        newUserContentPanel.add(createNewUserAddressStateTextField);

        createNewUserAddressZipCodLabel.setBounds(10, 440, 100, 25);
        newUserContentPanel.add(createNewUserAddressZipCodLabel);

        createNewUserAddressZipCodTextField.setBounds(100, 440, 175, 20);
        newUserContentPanel.add(createNewUserAddressZipCodTextField);

        createNewUserCreateUserButton.setBounds(10, 470, 220, 25);
        newUserContentPanel.add(createNewUserCreateUserButton);

        }

        else
        {

            if( 
            (createNewUserMiddleNameLabel.getParent() == newUserContentPanel) &&
            (createNewUserMiddleNameTextField.getParent() == newUserContentPanel) &&
            (createNewUserPasswordLabel.getParent() == newUserContentPanel) && 
            (createNewUserPasswordTextField.getParent() == newUserContentPanel))

            {
                
                newUserContentPanel.remove(createNewUserMiddleNameLabel);
                newUserContentPanel.remove(createNewUserMiddleNameTextField);
                newUserContentPanel.remove(createNewUserPasswordLabel);
                newUserContentPanel.remove(createNewUserPasswordTextField);
                    
            }

            createNewUserPasswordLabel.setBounds(10, 110, 80, 25);
            newUserContentPanel.add(createNewUserPasswordLabel);

            // createNewUserPasswordTextField = new JTextField(20);
            createNewUserPasswordTextField.setBounds(100, 110, 175, 20);
            newUserContentPanel.add(createNewUserPasswordTextField);   

            createNewUserEmployeePositionLabel.setBounds(10, 140, 80, 25);
            newUserContentPanel.add(createNewUserEmployeePositionLabel);

            createNewUserEmployeePositionEmployeeCheckBox.setBounds(150, 170, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionEmployeeCheckBox);

            createNewUserEmployeePositionEmployeeLabel.setBounds(40, 170, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionEmployeeLabel);

            createNewUserEmployeePositionSalesAssociateCheckBox.setBounds(150, 200, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateCheckBox);

            createNewUserEmployeePositionSalesAssociateLabel.setBounds(40, 200, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionSalesAssociateLabel);

            createNewUserEmployeePositionOnSiteTechnicianCheckBox.setBounds(150, 230, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianCheckBox);

            createNewUserEmployeePositionOnSiteTechnicianLabel.setBounds(40, 230, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionOnSiteTechnicianLabel);

            createNewUserEmployeePositionHumanResourcesCheckBox.setBounds(320, 170, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesCheckBox);

            createNewUserEmployeePositionHumanResourcesLabel.setBounds(200, 170, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionHumanResourcesLabel);

            createNewUserEmployeePositionInternCheckBox.setBounds(320, 200, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionInternCheckBox);

            createNewUserEmployeePositionInternLabel.setBounds(200, 200, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionInternLabel);

            createNewUserEmployeePositionOffSiteTechnicianCheckBox.setBounds(320, 230, 25, 25);
            newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianCheckBox);

            createNewUserEmployeePositionOffSiteTechnicianLabel.setBounds(200, 230, 120, 25);
            newUserContentPanel.add(createNewUserEmployeePositionOffSiteTechnicianLabel);

            createNewUserBirthDateLabel.setBounds(10, 260, 100, 25);
            newUserContentPanel.add(createNewUserBirthDateLabel);

            createNewUserBirthDayComboBox.setBounds(175, 260, 75, 25);
            newUserContentPanel.add(createNewUserBirthDayComboBox);

            createNewUserBirthMonthComboBox.setBounds(100, 260, 75, 25);
            newUserContentPanel.add(createNewUserBirthMonthComboBox);

            createNewUserBirthYearComboBox.setBounds(250, 260, 85, 25);
            createNewUserBirthYearComboBox.setSelectedIndex(birthYears.length-19);
            newUserContentPanel.add(createNewUserBirthYearComboBox);

            createNewUserSocialSecurityNumberLabel.setBounds(10, 290, 100, 25);
            newUserContentPanel.add(createNewUserSocialSecurityNumberLabel);

            createNewUserSocialSecurityNumberTextField.setBounds(100, 290, 175, 20);
            newUserContentPanel.add(createNewUserSocialSecurityNumberTextField);

            createNewUserAddresStreetAndHouseNumberLabel.setBounds(10, 320, 100, 25);
            newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberLabel);

            createNewUserAddresStreetAndHouseNumberTextField.setBounds(100, 320, 175, 20);
            newUserContentPanel.add(createNewUserAddresStreetAndHouseNumberTextField);

            createNewUserAddressCityLabel.setBounds(10, 350, 100, 25);
            newUserContentPanel.add(createNewUserAddressCityLabel);

            createNewUserAddressCityTextField.setBounds(100, 350, 175, 20);
            newUserContentPanel.add(createNewUserAddressCityTextField);

            createNewUserAddressStateLabel.setBounds(10, 380, 100, 25);
            newUserContentPanel.add(createNewUserAddressStateLabel);

            createNewUserAddressStateTextField.setBounds(100, 380, 175, 20);
            newUserContentPanel.add(createNewUserAddressStateTextField);

            createNewUserAddressZipCodLabel.setBounds(10, 410, 100, 25);
            newUserContentPanel.add(createNewUserAddressZipCodLabel);

            createNewUserAddressZipCodTextField.setBounds(100, 410, 175, 20);
            newUserContentPanel.add(createNewUserAddressZipCodTextField);

            createNewUserCreateUserButton.setBounds(10, 440, 220, 25);
            newUserContentPanel.add(createNewUserCreateUserButton);

        }

        frame.repaint();

    }

    public void getUserSelctedPosition()
    {

        if(createNewUserNumberOfPositionsChecked > 1)
        {
            JOptionPane.showMessageDialog(newUserContentPanel,
            "Sorry, this password does not match what is stored with this account.",
            "Password Does Not Match", JOptionPane.PLAIN_MESSAGE);
        }

        else if(createNewUserNumberOfPositionsChecked == 0)
        {

            JOptionPane.showMessageDialog(newUserContentPanel,
            "Sorry, this password does not match what is stored with this account.",
            "Password Does Not Match", JOptionPane.PLAIN_MESSAGE);

        }
        else
        {
            if(createNewUserEmployeePosition_isEmployee)
            {

                userSelctedPosition = "Employee";

            }

            else if(createNewUserEmployeePosition_isSalesAssociate)
            {

                userSelctedPosition =  "Sales Associates";

            }

            else if(createNewUserEmployeePosition_isOnSiteTechnician)
            {

                userSelctedPosition =  "Onsite Technician";

            }

            else if(createNewUserEmployeePosition_isHumanResources)
            {

                userSelctedPosition =  "Human Resources";

            }

            else if(createNewUserEmployeePosition_isIntern)
            {

                userSelctedPosition =  "CEO";

            }
            
            else if(createNewUserEmployeePosition_isOffSiteTechnician)
            {

                userSelctedPosition =  "Offsite Technician";

            }

        }
    
    }


// createNewUserEmployeePosition_isEmployee = false;
// createNewUserEmployeePosition_isSalesAssociate = false;
// createNewUserEmployeePosition_isOnSiteTechnician = false;
// createNewUserEmployeePosition_isHumanResources = false;
// createNewUserEmployeePosition_isIntern = false;
// reateNewUserEmployeePosition_isOffSiteTechnician = false;

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==logInButton)
        {
          
            userIDInput = usernameTextField.getText();
            System.out.println(userIDInput);
            userPasswordInput = String.valueOf(passwordPasswordField.getPassword());
            System.out.println(userPasswordInput);
        
            try
            {
                if(IA_User.Users.containsKey(Integer.parseInt(userIDInput)))
                {
                
                

                        if(userPasswordInput.equals(IA_User.Users.get(Integer.parseInt(userIDInput)).getUserPassword()))
                        {
                            mainScreen();
                        }
                        
                        else
                        {
                            JOptionPane.showMessageDialog(loginContentPanel,
                            "Sorry, this password does not match what is stored with this account.",
                            "Password Does Not Match", JOptionPane.PLAIN_MESSAGE);
                            System.out.println("line 649");
                        }

                }

                else
                {

                    JOptionPane.showMessageDialog(loginContentPanel, 
                    "Sorry, this ID Number has not been assigned to a user. If you feel this is an error, please contact your adminstrator.",
                    "ID Does Not Exist", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("line 660");

                }

            }

            catch(Exception ex)
            {

                JOptionPane.showMessageDialog(loginContentPanel,
                "Sorry, the ID Number entered is not valid. If you feel this is an error, please contact your adminstrator.",
                "Invalid ID Number", JOptionPane.PLAIN_MESSAGE);
                System.out.println("line 672");

            }

            
        }
       
        if(e.getSource()==createNewUserButton)
        {
            System.out.println("new user button pressed");
            newUserScreen();
        }
        
        if(e.getSource()==createNewUserCreateUserButton)
        {

            
            try {

                if(createNewuserMiddleNameIsChecked)
                {

                    IA_User iau = new IA_User(createNewUserAddresStreetAndHouseNumberTextField.getText(), createNewUserAddressCityTextField.getText(), 
                    createNewUserAddressStateTextField.getText(), createNewUserAddressZipCodTextField.getText(), createNewUserFirstNameTextField.getText(), 
                    createNewUserLastNameTextField.getText(), createNewUserMiddleNameTextField.getText(), createNewUserPasswordTextField.getText(), userSelctedPosition, Integer.parseInt((String) createNewUserBirthMonthComboBox.getSelectedItem()), 
                    Integer.parseInt((String) createNewUserBirthDayComboBox.getSelectedItem()), Integer.parseInt((String) createNewUserBirthYearComboBox.getSelectedItem()), Integer.parseInt(createNewUserSocialSecurityNumberTextField.getText()));

                    JOptionPane.showMessageDialog(newUserContentPanel,iau.getUserID(),"New Employee ID", JOptionPane.PLAIN_MESSAGE);

                }

                else
                {
                
                    IA_User iau =  new IA_User(createNewUserAddresStreetAndHouseNumberTextField.getText(), createNewUserAddressCityTextField.getText(), 
                    createNewUserAddressStateTextField.getText(), createNewUserAddressZipCodTextField.getText(), createNewUserFirstNameTextField.getText(), 
                    createNewUserLastNameTextField.getText(), createNewUserPasswordTextField.getText(), userSelctedPosition, Integer.parseInt((String) createNewUserBirthMonthComboBox.getSelectedItem()), 
                    Integer.parseInt((String) createNewUserBirthDayComboBox.getSelectedItem()), Integer.parseInt((String) createNewUserBirthYearComboBox.getSelectedItem()), Integer.parseInt(createNewUserSocialSecurityNumberTextField.getText()));

                    JOptionPane.showMessageDialog(newUserContentPanel,iau.getUserID(),"New Employee ID", JOptionPane.PLAIN_MESSAGE);

                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            // private JTextField createNewUserAddresStreetAndHouseNumberTextField;
            // private JTextField createNewUserAddressCityTextField;
            // private JTextField createNewUserAddressStateTextField;
            // private JTextField createNewUserAddressZipCodTextField;

        }

        if(e.getSource() == closeGui)
        {
            IA_closeProgram cpr;
            try {
                cpr = new IA_closeProgram();
                cpr.close(IA_User.getUserList());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }


    @Override
    public void itemStateChanged(ItemEvent e) 
    {

        if(e.getSource() == createNewUserMiddleNameCheckBox)
        {

            if(!createNewuserMiddleNameIsChecked)
            {
                createNewuserMiddleNameIsChecked = true;
                middleNameOptionStateChnaged();
            }

            else
            {
                createNewuserMiddleNameIsChecked = false;
                middleNameOptionStateChnaged();
            }

        }
        
        if(e.getSource() == createNewUserEmployeePositionEmployeeCheckBox)
        {

            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }
            else
            {

                System.out.println("Employee");

                createNewUserEmployeePosition_isEmployee = true;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked++;

            }

        }
        
        if(e.getSource() == createNewUserEmployeePositionSalesAssociateCheckBox)
        {

            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }

            else
            {

                System.out.println("Sales");

                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = true;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked++;

            }

        }
        
        if(e.getSource() == createNewUserEmployeePositionOnSiteTechnicianCheckBox)
        {

            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }

            else
            {

                System.out.println("OnSite Tech");

                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = true;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked++;

            }

        }
        
        if(e.getSource() == createNewUserEmployeePositionHumanResourcesCheckBox)
        {

            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }

            else
            {

                System.out.println("hr");

                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = true;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked++;
            
            }
        }
        
        if(e.getSource() == createNewUserEmployeePositionInternCheckBox)
        {
            
            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }
            else
            {

                System.out.println("intern");

                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = true;
                createNewUserEmployeePosition_isOffSiteTechnician = false;
    
                createNewUserNumberOfPositionsChecked++;

            }

        }
        
        if(e.getSource() == createNewUserEmployeePositionOffSiteTechnicianCheckBox)
        {

            if(createNewUserNumberOfPositionsChecked > 0)
            {
             
                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = false;

                createNewUserNumberOfPositionsChecked--;

            }
            else
            {

                System.out.println("offsite");

                createNewUserEmployeePosition_isEmployee = false;
                createNewUserEmployeePosition_isSalesAssociate = false;
                createNewUserEmployeePosition_isOnSiteTechnician = false;
                createNewUserEmployeePosition_isHumanResources = false;
                createNewUserEmployeePosition_isIntern = false;
                createNewUserEmployeePosition_isOffSiteTechnician = true;
    
                createNewUserNumberOfPositionsChecked++;

            }
            

        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        IA_closeProgram c;
        try {
            c = new IA_closeProgram();
            c.close(IA_User.getUserList());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}