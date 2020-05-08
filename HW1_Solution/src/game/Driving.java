/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.Random;

import components.Junction;
import components.Map;
import components.Vehicle;
import components.VehicleType;
import utilities.Point;

/**Represents the system functionality 
 * @author Sophie Krimber
 *
 */
public class Driving {
	private int numOfJuncs;
	private int numOfVehicles;
	Map currentMap;
	ArrayList<Vehicle> currentVehicles;
	double drivingTime;
	int maxTime; //represents quantity of running turns
	
	/**Constructor
	 * 
	 * @param juncs quantity of junctions in the system
	 * @param vehicles quantity of vehicles in the system
	 * @param maxTime  quantity of running turns
	 */
	public Driving(int juncs, int vehicles, int maxTime) {
		numOfJuncs=juncs;
		numOfVehicles=vehicles;
		this.maxTime=maxTime;
		drivingTime=0;
		//create random junctions
		ArrayList<Junction> junctions=new ArrayList<Junction>();
		for (int i=0; i<numOfJuncs;i++) {
			junctions.add(new Junction(new String("" +i),new Point()));
		}
	
		currentMap=new Map(junctions);
		
		setVehicles();
	}
	
	/**Gets quantity of junctions
	 * 
	 * @return int 
	 */
	public int getNumOfJuncs() {
		return numOfJuncs;
	}
	
	/**Gets quantity of vehicles
	 * 
	 * @return int 
	 */
	public int getNumOfVehicles() {
		return numOfVehicles;
	}
	
	/**replaces the current map with a new one with random quantity of junctions
	 * 
	 */
	public void addMap() {
		final int min=15;
		final int max=25;
		int num=new Random().nextInt(max-min)+min;
		currentMap=new Map(num);
	}
	
	/**Creates random vehicles
	 * 
	 */
	public void setVehicles() {
		
		currentVehicles=new ArrayList<Vehicle>();
		for (int i=0; i<numOfVehicles;i++) {
			
			VehicleType type=VehicleType.getRandomVehicleTypes().get(0);
			Junction junc=currentMap.getRandomJunction();
			while(junc.getExitingRoads().size()==0) {
				junc=currentMap.getRandomJunction();
			}
			currentVehicles.add(new Vehicle(i,type,junc));
		}
	}
	
	/**changes the number of vehicles in the game to a random one and replaces current vehicles
	 * 
	 */
	public void addVehicles(){
		final int min=2;
		final int max=8;
		
		numOfVehicles = new Random().nextInt(max-min)+min;
		setVehicles();
	}
	
	/**Activates the time(turns) count
	 * at every turn all the vehicles try to move and all the traffic lights change lights
	 * 
	 * @param maxTime num of turns to play
	 */
	public void startDrive(int maxTime) {
		
		for(int i=1; i<=maxTime; i++) {
			System.out.println("\nTURN "+i);
			for (int j=0;j<numOfVehicles;j++) {
				currentVehicles.get(j).move();
			
			}
			for (int k=0; k<currentMap.getJunctions().size();k++) {
				if(currentMap.getJunctions().get(k).getLights()) {
					currentMap.getJunctions().get(k).changeLights();
				}
			}
		}
		System.out.println("\nSTATUS");
		for (int j=0;j<numOfVehicles;j++) {
			currentVehicles.get(j).status();
		}
	}
	
	@Override 
	public String toString() {
		return new String("Driving");
	}
	/**Gets current vehicles list
	 * 
	 * @return ArrayList<Vehicle> list of current vehicles
	 */
	public ArrayList<Vehicle> getVehicles(){
		return currentVehicles;
	}
}
