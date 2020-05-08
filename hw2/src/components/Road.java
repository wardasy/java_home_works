/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import utilities.Utilities;
import utilities.VehicleType;

public class Road  implements RouteParts, Utilities{
	private int [] allowedSpeedOptions;
	private boolean enable;
	private Junction endJunction;
	private boolean greenlight;
	private Junction startJunction;
	private int maxSpeed;
	private  VehicleType[] vehicleTypes;
	private double length;

	private ArrayList<Vehicle> waitingVehicles;
	/**Constructor
	 * 	creates a new Road 
	 * @param start junction
	 * @param end junction
	 */
	public Road (Junction start, Junction end){
		this.allowedSpeedOptions= new int[]{20,40,50,55,60,70,80,90};
		VehicleType[] vehicleTypesList= {VehicleType.car,VehicleType.bus,VehicleType.bicycle, VehicleType.motorcycle, VehicleType.truck, VehicleType.tram, VehicleType.semitrailer};
		this.setVehicleTypes(vehicleTypesList);
		this.setStartJunction(start);
		this.setEndJunction(end);
		this.setWaitingVehicles(new ArrayList<Vehicle>());
		this.setGreenlight(false);
		this.setMaxSpeed(this.allowedSpeedOptions[ new Random().nextInt(this.allowedSpeedOptions.length)]);
		this.setLength(this.calcLength());
		this.setEnable(enable);
		this.endJunction.addEnteringRoad(this);
		this.startJunction.addExitingRoad(this);
		System.out.println("Road from "+this.startJunction.toString()+" to "+this.getEndJunction().toString()+" length: "+this.length+ ", max speed: "+this.maxSpeed+ " has been created");


	}

	/* set & get*/
	/**Sets vehicleType
	 * @param vehicleTypes 
	 */
	private void setVehicleTypes(VehicleType[] vehicleTypes) {
		this.vehicleTypes=new VehicleType[7];
		for(int i=0;i<vehicleTypes.length;i++)
			this.vehicleTypes[i]=vehicleTypes[i];	
		}
	/**Gets the allowedSpeedOptions value
	 * @return allowedSpeedOptions
	 */
	public int[] getAllowedSpeedOptions() {return allowedSpeedOptions;}
	/**Gets enable value
	 * @return boolean road enable
	 */
	public boolean isEnable() {return enable;}
	/**Sets enable field
	 * @param enable 
	 */
	public void setEnable(boolean enable) {this.enable = enable;}
	/**Gets green light value
	 * @return boolean green light
	 */
	public boolean getGreenlight() {return greenlight;}
	/**Sets greenlight 
	 * @param  boolean greenlight 
	 */
	public void setGreenlight(boolean greenlight) {this.greenlight = greenlight;}
	/**Gets road lenghth value
	 * @return  road length
	 */
	public double getLength() {return length;}
	/**Sets length 
	 * @param length 
	 */
	public void setLength(double length) {this.length = length;}
	/**Gets road maximum speed
	 * @return road max speed
	 */
	public int getMaxSpeed() {return maxSpeed;}
	/**Sets max speed 
	 * @param maxSpeed 
	 */
	public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
	/**Gets VehicleType  array
	 * @return vehicleTypes 
	 */
	public VehicleType[] getVehicleTypes() {return vehicleTypes;}
	/**Sets vehicleType 
	 * @param VehicleType  ,index 
	 */
	public void setVehicleTypes(VehicleType vehicleTypes,int index) {this.vehicleTypes[index] = vehicleTypes;}
	/**Gets  waitingVehicles
	 * @return waitingVehicles 
	 */
	public ArrayList<Vehicle> getWaitingVehicles() {return waitingVehicles;}
	/**Sets waitingVehicles 
	 * @param waitingVehicles. 
	 */
	public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {this.waitingVehicles =new ArrayList<Vehicle>(waitingVehicles);}
	/**Gets start Junction 
	 * @return startJunction
	 */
	public Junction getStartJunction() {return startJunction;}
	/**Sets startJunction
	 * @param startjunction. 
	 */
	public void setStartJunction(Junction startJunction) {this.startJunction = startJunction;}
	/**Gets end Junction
	 * @return endJunction
	 */
	public Junction getEndJunction() {	return endJunction;}
	/**Sets endJunction  
	 * @param end junction. 
	 */
	public void setEndJunction(Junction endJunction) {this.endJunction = endJunction;}


	/*methods*/
	
	/**Adds vehicle to the waiting vehicles list	 
	*/
	public void addVehicleToWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.add(vehicle);
		}
	public double calcEstimatedTime(Object obj){
		if(obj instanceof Vehicle) {
			return this.length/Math.min(this.maxSpeed,((Vehicle) obj).getVehicleType().getAverageSpeed());
			}
		return 0;
		}
	/**
	 *
	 * @return length of the road.
	 */
	public double calcLength(){
		double xPoint=this.startJunction.getX()-this.endJunction.getX();
		double yPoint=this.startJunction.getY()-this.endJunction.getY();
		return Math.sqrt(xPoint*xPoint + yPoint*yPoint);
		}
	public boolean canLeave(Vehicle vehicle){
		return vehicle.getTimeOnCurrentPart()<=vehicle.getTimeFromRouteStart();
		}
	public void checkIn(Vehicle vehicle){
		for(Vehicle i: waitingVehicles) {
			
			if (!i.equals(vehicle)) {
				this.waitingVehicles.add(i);
				System.out.println(" vehicle "+vehicle+" on the road ");
				break;
			}
		}
	}
	/**
	 *  @param vehicle 
	 *  @return void
	 */
	public void checkout(Vehicle vehicle){
		for(Vehicle i: waitingVehicles) {
			if (i.equals(vehicle)) {
				this.waitingVehicles.remove(i);
				System.out.println(" vehicle "+vehicle+" delete on the road ");
				break;
			}
		}
	}
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Road) {
			ans=( this.allowedSpeedOptions==((Road)other).allowedSpeedOptions   &&  this.enable==((Road)other).enable 
					&& this.startJunction ==((Road)other).startJunction &&  this.endJunction ==((Road)other).endJunction
					&& this.greenlight ==((Road)other).greenlight && this.length ==((Road)other).length
					&& this.maxSpeed ==((Road)other).maxSpeed) && this.vehicleTypes ==((Road)other).vehicleTypes
					&& this.waitingVehicles ==((Road)other).waitingVehicles;
			return ans;
			}
		return ans;
		}
	
	
	public RouteParts findNextPart(Vehicle vehicle){
		return vehicle.getCurrentRoutePart();
		}
	
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.remove(vehicle);
		}
	public void stayOnCurrentPart(Vehicle vehicle){
		if(!vehicle.getCurrentRoutePart().equals(vehicle.getLastRoad())) {
			System.out.println("-is still moving on "+vehicle.getCurrentRoutePart()+", time to finish: "+vehicle.getTimeFromRouteStart());
			}
		}
	@Override
	public String toString() {
		return 	"Road from "+this.startJunction+" to "+this.endJunction+" length: "+this.length+ ", max speed: "+this.maxSpeed;
		}	
}
