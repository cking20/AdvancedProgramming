package decisionstruct;
import javax.swing.JOptionPane;
public class DecisionStruct {
    public static void main(String[] args) {
        char letter;
       //get letter grade
        letter = GetLetterGrade();
        ProcessLetterGrage(letter);
        System.exit(0);
    }
    public static/* static refers to class level not instance*/ char GetLetterGrade(){
        char letter;
        do { letter = JOptionPane.showInputDialog("WHATS YO LETTER GRADE?").charAt(0);    
        } while(letter != 'A' && letter != 'a' && letter != 'B' && letter != 'b' 
                && letter != 'C' && letter != 'c' && letter != 'D' && 
                letter != 'd' && letter != 'F' && letter != 'f');
        return letter;   
    }
    public static void ProcessLetterGrage(char letter){
             // RAANDOM FACTS
             // | bit wise opr. works on the bianary behind it 
                //01000001 = A 65   0 or 1 = 1  
                //01100001 = a 97
        switch(letter){
            case 'A':
            case 'a': JOptionPane.showMessageDialog(null, "You did damn good son");
                break;
            case 'B': 
            case 'b': JOptionPane.showMessageDialog(null, "WHY YOU NO GET A");
                break;
            case 'C': 
            case 'c': JOptionPane.showMessageDialog(null, "DISHONNOR YOU FAMIRY");
                break;
            case 'D': 
            case 'd': JOptionPane.showMessageDialog(null, "SEPOKUUU WRITE NAOW");
                break;
            case 'F': 
            case 'f': JOptionPane.showMessageDialog(null, "FFFFFFFFFFFFFFFFFFFF");
                break;
            default: JOptionPane.showMessageDialog(null, "what even");
        }
    }
    
}
