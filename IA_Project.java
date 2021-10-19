import java.io.Serializable;

/**
 * IA_Project
 */
public class IA_Project implements Serializable{

    public static Boolean guiIsActive = false;

    public static void main(String[] args) throws Exception 
    {
        
        IA_GUI gui = new IA_GUI();
        gui.runProgram();

    }
}