/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.*;
/**
 * Represents the system functionality  
 */

public class Driving  implements Utilities, Timer {
	private Map map;
	private  ArrayList<Vehicle> vehicles; 
	private int drivingTime;
	private ArrayList<Timer> allTimedElements;
	
	/**Constructor
	 * 
	 * @param numOfJunctions
	 * numOfVehicles
	 * Random constructor
	 */
	public Driving (int numOfJunctions, int numOfVehicles) {
		System.out.println("================= CREATING JUNCTIONS=================");
		this.map= new Map(numOfJunctions);
		System.out.println("================= GAME MAP HAS BEEN CREATED =================");
		System.out.println("================= CREATING VEHICLES =================");
		this.vehicles=new ArrayList<Vehicle>();
		for (int i = 0; i < numOfVehicles ; i++) {
			Vehicle temp=new Vehicle(map.getRoads().get(new Random().nextInt(map.getRoads().size())));
			this.vehicles.add(temp);
			}
		}
	/**
	 * @param numOfTurns
	 *  @return void
	 */
	public void  drive(int numOfTurns) {
		System.out.println("================= START DRIVING=================");
		for(int i=0;i<numOfTurns+1 ;i++) {
			System.out.println("*************** TURN "+i +" ***************");
			this.incrementDrivingTime();
			}
		}
	public void incrementDrivingTime() {
			for(int j=0; j<this.vehicles.size();j++) {
				System.out.println(this.vehicles.get(j).toString());
				this.vehicles.get(j).incrementDrivingTime();
				}
		this.map.printLight();
		}
	/**
	 * @return Time of driving 
	 */	
	public int getDrivingTime() {
		return drivingTime;
		}
	/**
	 * @return vehicles
	 */	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
		}
	/**
	 * @param vehicles - type ArrayList<Vehicle>
	 * @return nothing
	 */	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		}
	/**
	 * @param drivingTime 
	 */	
	public void setDrivingTime(int drivingTime) {
		this.drivingTime = drivingTime;
	}
	/**
	 * @return ArrayList<Timer> 
	 */	
	public ArrayList<Timer> getAllTimedElements() {
		return allTimedElements;
	}
	/**
	 * @param allTimedElements
	 * @return no returns (void)
	 */
	public void setAllTimedElements(ArrayList<Timer> allTimedElements) {
		this.allTimedElements = new ArrayList<Timer>(allTimedElements);
		}	
}
