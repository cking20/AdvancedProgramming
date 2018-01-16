


package lab.pkg01;
import java.util.Scanner;

/**
 * @author Christopher King
 * Due: Sept 7 15
 * Lab 01
 * Coast Guard
 */
public class Lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Produce coast guard travel time summery
	set the coast vessle data
	get vessle in distress data
	calc distances to vessel in distress
	calc ETA for each coast gaurd ship
	display vessel in distress data
	display coarst gaurd travel time summary*/
        
        //Vessel in distress vals
        int vesselXCoordinate;
        int vesselYCoordinate;
        int numberOfPeople;
        
        
       //set the coast vessle data
        Scanner kbd = new Scanner(System.in);
        
        int v1StationNumber = 1;
	int v2StationNumber = 2;
	int v3StationNumber = 3;
	int v4StationNumber = 4;
	int v5StationNumber = 5;
	int v6StationNumber = 6;
        
	String v1StationName = "Clayton";
	String v2StationName = "Alex Bay";
	String v3StationName = "Cape Vincent";
	String v4StationName = "Sackets Harbor";
	String v5StationName = "Fishers Landing";
	String v6StationName = "Chaumont";
        
	int v1XCoord = 6;
	int v2XCoord = 7;
	int v3XCoord = 5;
	int v4XCoord = 2;
	int v5XCoord = 9;
	int v6XCoord = 3;
        
	int v1YCoord = 2;
	int v2YCoord = 3;
	int v3YCoord = 2;
	int v4YCoord = 1;
	int v5YCoord = 4;
	int v6YCoord = 1;
        
	int v1Speed = 25;
	int v2Speed = 50;
	int v3Speed = 25;
	int v4Speed = 45;
	int v5Speed = 18;
	int v6Speed = 18;
        
	int v1Capacity = 13;
	int v2Capacity = 5;
	int v3Capacity = 13;
	int v4Capacity = 7;
	int v5Capacity = 19;
	int v6Capacity = 19;
        
        
        //calculated values
        double v1Distance;
        double v2Distance;
        double v3Distance;
        double v4Distance;
        double v5Distance;
        double v6Distance;
        
        double v1Time;
        double v2Time;
        double v3Time;
        double v4Time;
        double v5Time;
        double v6Time;
        
        //get Vessel in Distress Data
        System.out.println("Please enter the Vessel's X Coordinte");
        vesselXCoordinate = kbd.nextInt();
        
        System.out.println("Please enter the Vessel's Y Coordinte");
        vesselYCoordinate = kbd.nextInt();
        
        System.out.println("Please enter the number of people");
        numberOfPeople = kbd.nextInt();
        
        //calc distances to vessel in distress
        
        v1Distance = Math.sqrt(Math.pow(vesselXCoordinate - v1XCoord , 2) 
                + Math.pow(vesselYCoordinate - v1YCoord , 2));
        v2Distance = Math.sqrt(Math.pow(vesselXCoordinate - v2XCoord , 2) 
                + Math.pow(vesselYCoordinate - v2YCoord , 2));
        v3Distance = Math.sqrt(Math.pow(vesselXCoordinate - v3XCoord , 2) 
                + Math.pow(vesselYCoordinate - v3YCoord , 2));
        v4Distance = Math.sqrt(Math.pow(vesselXCoordinate - v4XCoord , 2) 
                + Math.pow(vesselYCoordinate - v4YCoord , 2));
        v5Distance = Math.sqrt(Math.pow(vesselXCoordinate - v5XCoord , 2) 
                + Math.pow(vesselYCoordinate - v5YCoord , 2));
        v6Distance = Math.sqrt(Math.pow(vesselXCoordinate - v6XCoord , 2) 
                + Math.pow(vesselYCoordinate - v6YCoord , 2));
        
        //calc ETA for each coast gaurd ship
         v1Time = v1Distance / v1Speed;
	 v2Time = v2Distance / v2Speed;
	 v3Time = v3Distance / v3Speed;
	 v4Time = v4Distance / v4Speed;
	 v5Time = v5Distance / v5Speed;
	 v6Time = v6Distance / v6Speed;
        
        //Display vessel in distress data
         System.out.format("%-20s" , "Vessel in Distress\n");
         System.out.format("Vessel's X Coordinate: %3d\n", vesselXCoordinate);
         System.out.format("Vessel's Y Coordinate: %3d\n", vesselYCoordinate);
         
         //Display coast guard travel time summary
         
        System.out.format("%-10s%-20s%11s%16s%12s%12s%20s\n", "Station", 
                 "Station Name" , "Coordinates" , "Vessel Speed" , "Capacity" , 
                 "Distance" , "Est. Arrival Time");
        
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v1StationNumber, 
                 v1StationName , v1XCoord + "," + v1YCoord , v1Speed , v1Capacity , 
                 v1Distance , v1Time);
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v2StationNumber, 
                 v2StationName , v2XCoord + "," + v2YCoord , v2Speed , v2Capacity , 
                 v2Distance , v2Time);
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v3StationNumber, 
                 v3StationName , v3XCoord + "," + v3YCoord , v3Speed , v3Capacity , 
                 v3Distance , v3Time);
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v4StationNumber, 
                 v4StationName , v4XCoord + "," + v4YCoord , v4Speed , v4Capacity , 
                 v4Distance , v4Time);
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v5StationNumber, 
                 v5StationName , v5XCoord + "," + v5YCoord , v5Speed , v5Capacity , 
                 v5Distance , v5Time);
        System.out.format("%6d    %-20s%11s%16d%12d%12.2f%20.2f\n", v6StationNumber, 
                 v6StationName , v6XCoord + "," + v6YCoord , v6Speed , v6Capacity , 
                 v6Distance , v6Time);
    }
    
}
