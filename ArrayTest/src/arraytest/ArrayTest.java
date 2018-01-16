
package arraytest;

import javax.swing.JOptionPane;
import java.util.Random;


public class ArrayTest {
    
    
    public static void main(String[] args) {
        String map;
        map = genMap();
        JOptionPane.showInputDialog(map);
        
        System.exit(0);
        
    }
    
    public static String genMap(/*int screenXPos,int screenYPos*/){ 
        String stringMap = "";
        Random randGen;
        int randInt;
         char map[][];
         map = new char[10][30];
         randGen = new Random();
         
         
         for(int row = 0; row < map.length; row++){
            for(int column = 0; column < map[row].length; column++){
                randInt = randGen.nextInt(10);
                switch(randInt){
                    case 0:
                        map[row][column] = '_';
                        break;
                    case 1:
                        map[row][column] = '_';
                        break;
                    case 2:
                        map[row][column] = 'T';
                        break;
                    case 3:
                        map[row][column] = '.';
                        break;
                    case 4:
                        map[row][column] = 'o';
                        break;
                    case 5:
                        map[row][column] = '_';
                        break;
                    default:
                        map[row][column] = '_';
                        break;
                }
                 
            }
            
        }    
        
        
        for(int row = 0; row < map.length; row++){
            for(int column = 0; column < map[row].length; column++){
                    stringMap = stringMap + map[row][column];
            }
            stringMap += "\n";
        }
        
        return stringMap;
    }
    
}
