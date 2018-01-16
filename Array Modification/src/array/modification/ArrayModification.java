
package array.modification;
import java.util.Scanner;


public class ArrayModification {

    
    public static void main(String[] args) {
        String [] tools;
        tools = new String[70];
        int numTools;
        tools[0] = "screwdriver";
        tools[1] = "torque wrench";
        tools[2] = "ducktape";
        tools[3] = "red pens";
        tools[4] = "LATHE";
        numTools = countTools(tools);
        numTools = addTool(tools,numTools);
        displayTools(tools, numTools);
        numTools =loseTool(tools, numTools);
        displayTools(tools, numTools);
        //addTool(tools);
    }
    public static int countTools(String [] tools){
        int numTools = 0;
        for (int cnt = 0; cnt < tools.length; cnt++)
            if(tools[cnt] != null)
                numTools++;
        return numTools;
        
    }
     public static void displayTools(String [] tools, int numTools){
         System.out.println("\n");
        for (int cnt = 0; cnt < numTools; cnt++)
            if(tools[cnt] != null)
                System.out.println(tools[cnt]);
    }
    public static int addTool(String [] tools, int numTools){
        
        Scanner kbd = new Scanner(System.in);
        System.out.println("\nWhat is your new Tool?");
        tools[numTools] = kbd.nextLine();
        numTools++;
        return numTools;
    }
    public static int loseTool(String [] tools, int numTools){
        String lostTool;
        
        int lostToolAddr;
        int cnt;
        Scanner kbd = new Scanner(System.in);
        //numTools = countTools(tools);
        
        //ask for item
        System.out.println("\nWhat Tool did you lose?");
        lostTool = kbd.nextLine();
        //search for item
        
                //find it or not no other option
        cnt = 0;
        while(cnt < numTools && !tools[cnt].equalsIgnoreCase(lostTool) ){
            cnt++;    
        }
        
        //remove item
        if (cnt < numTools){
            //brings the last item up, so it "empty"
            tools[cnt] = tools[numTools - 1];
            //decrement num tools
            numTools--;
        }
            
        return numTools;
    }
}
