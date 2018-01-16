
package grading;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author Christopher
 */
public class Grading {

   
    public static void main(String[] args) {
       //double q1,q2,q3, avg;
        double avg, quizzes[];
        int size;
        Scanner kbd = new Scanner(System.in);
         
        //if its negative it crashes
        quizzes = LoadEM();
        avg = Average(quizzes);
       
      // q1 = kbd.nextDouble();
       //q2 = kbd.nextDouble();
      // q3 = kbd.nextDouble();
     //  avg = Average(q1, q2, q3);
       
       System.out.printf("Average  = %f", avg);
    }       
    public static double[] LoadEM() {
        int size;
        Scanner kbd = new Scanner(System.in);
        System.out.println("How many Quizes?");
        size = kbd.nextInt();
        double [] quizzes;
        quizzes = new double[Math.abs(size)];
     
        for(int i = 0; i < quizzes.length; i++){
            System.out.println("Quiz grade:");
            quizzes[i]= kbd.nextDouble();
        }
        return quizzes;
    }
    public static double Average(double [] quizzes){
        double avg, sum = 0;
        
        for(int i = 0; i < quizzes.length; i++)
            sum = quizzes[i] + sum;
        avg = sum / quizzes.length;
        
        return avg;
        
    }
    
}
