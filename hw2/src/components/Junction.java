/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Junction  extends Point implements RouteParts {
	private static int objectsCount=1;
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	/**
	 * Default Ctor for a Junction
	 * Random constructor
	 */
	public Junction() {
		super(new Random().nextInt(799) + 0,new Random().nextInt(599) + 0);
		this.setJunctionName(String.valueOf(objectsCount));	
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);
		}
	/**Constructor
	 * @param name of junction
	 * @param  point(x and y) - junction location
	 */
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);	
		}
	public  static int getObjectsCount() {
		return objectsCount;
		}
	/**
	 * @return junction name
	 */
	public String getJunctionName() {
		return junctionName;
	}
	/**Sets the junction name
	 * @param name A String represents junction name
	 */
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	/**Entering roads getter
	 * @return ArrayList<Road> holds the entering roads of the junction
	 */
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}
	/**Sets the entering roads array for junction
	 * @param ArrayList<Road> holds the list of entering roads of the junction.
	 */
	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		this.enteringRoads =new ArrayList<Road>(enteringRoads);
	}
	/** Exiting roads getter
	 * @return ArrayList<Road> holds the exiting roads of the junction
	 */
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}
	/**Sets the exiting roads array for junction
	 * @param roads ArrayList<Road> holds the list of exiting roads of the junction.
	 */
	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		this.exitingRoads = new ArrayList<Road>(exitingRoads);
	}
	/**Sets the objects count for junction
	 * @param objects count - type int
	 */
	public static void setObjectsCount(int objectsCount2) {
		objectsCount = objectsCount2;
	}
	

	/*methods*/
	@Override
	public String toString() {
		return "junction "+this.getJunctionName();
		}
	/**Adds an exiting road 
	 * @param road 
	 */
	public void addExitingRoad(Road roadExitRoad) { 
		if(!this.exitingRoads.contains(roadExitRoad))
			this.exitingRoads.add (roadExitRoad);
		}
	/**Adds an entering 
	 * @param road 
	 */
	public void addEnteringRoad(Road roadEnterRoad) { 
		if(!this.enteringRoads.contains(roadEnterRoad))
			this.enteringRoads.add (roadEnterRoad);
		}
	public double calcEstimatedTime(Object obj){
		return this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad())+1;
		}
	/**
	 *  @param vehicle 
	 *   @return  Boolean value 
	 */
	public boolean canLeave(Vehicle vehicle){
		if(!checkAvailability(vehicle)) {
			if(!this.getExitingRoads().contains(vehicle.getLastRoad()))
				vehicle.setStatus("vehicle can't cross the junction and leave because there are no ways out of the junction");
			else
				vehicle.setStatus("vehicle can't cross the junction and leave because it is not on the waiting list");
			return false;
			}
		return true;
		}
	public boolean checkAvailability(Vehicle vehicle) {
		if(this.getEnteringRoads().contains(vehicle.getLastRoad()) && vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)!=-1) {
			for(int i=0 ;i<vehicle.getLastRoad().getWaitingVehicles().size();i++){
				if(i<vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)+1) {
						double time=calcEstimatedTime(this.enteringRoads.get(i).getWaitingVehicles().get(i));
						time-=1;
						}
				}
			return true;
			}
		return false;
		}
	/**
	 *  @param vehicle 
	 *  A method that "registers" the vehicle at a node, updates all relevant fields of the node and the vehicle.
	 *  @return void
	 */
	public void checkIn(Vehicle vehicle){
		if(vehicle.getLastRoad().getWaitingVehicles().contains(vehicle))
			vehicle.getLastRoad().getWaitingVehicles().remove(vehicle);
		}
	public void checkout(Vehicle vehicle){
		if(vehicle !=null)
			vehicle.getLastRoad().getWaitingVehicles().add(vehicle);
		System.out.println(this.toString()+ " has left  " +this.toString()+ ".");	
		}
	/**
	 *  @param vehicle 
	 *  @return  1 Roads found (random). 
	 *  else @return null.
	 */
	public RouteParts findNextPart(Vehicle vehicle){
		ArrayList<Road> temp= new ArrayList<Road>();
		for(int i=0;i<this.enteringRoads.size();i++) {
			if(this.exitingRoads.get(i).isEnable())
				temp.add(this.exitingRoads.get(i));
			}
		if(!temp.isEmpty()) 
			return temp.get(this.getRandomInt(0, temp.size()-1));
		return null;
		}
	/**
	 *  @param vehicle
	 *  @return void
	 */
	public void stayOnCurrentPart(Vehicle vehicle){
		System.out.println(vehicle.getStatus());
		}
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Junction) {
			ans=( this.junctionName==((Junction)other).junctionName   
					&& this.getX() ==((Junction)other).getX() 
					&& this.getY() ==((Junction)other).getY());
			return ans;
			}
		return ans;
		}	
}
