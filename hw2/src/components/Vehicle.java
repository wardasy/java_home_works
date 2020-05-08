/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.Timer;
import utilities.Utilities;
import utilities.VehicleType;

public class Vehicle implements Utilities, Timer {
	private int id;
	private VehicleType vehicleType;
	private Route currentRoute ;
	private Road lastRoad;
	private String status;
	private RouteParts currentRoutePart;
	private int timeFromRouteStart;
	private int timeOnCurrentPart;
	private static int objectsCount=1;
	/**Constructor
	 * creates random route.
	 * @param road
	 */
	public Vehicle(Road road) {
		this.setId(this.getObjectsCount());
		this.setStatus(null);
		this.setVehicleType(road.getVehicleTypes()[ new Random().nextInt(road.getVehicleTypes().length)]);
		this.setLastRoad(road);
		System.out.println("Vehicle "+ this.objectsCount +": "+ this.vehicleType.name()+", average speed: "+ this.vehicleType.getAverageSpeed()+"  has been created");
		this.setCurrentRoutePart(lastRoad);
		this.setTimeFromRouteStart(getRandomInt(1, 15));
		this.setTimeOnCurrentPart(getRandomInt(1, 13));
		this.currentRoute=new Route(currentRoutePart,this);
		this.setObjectsCount(objectsCount+1);
		}
	/**
	 * moves the vehicle from current junction to the next one on route
	 */
	public void move(){
		if(this.currentRoute.getRouteParts().get(1).equals(this.getLastRoad().getEndJunction() )) {
			this.lastRoad.getStartJunction().checkout(this);
			checkIn();
			}
		if(!this.currentRoutePart.equals(this.getLastRoad().getEndJunction())) {
			this.currentRoute.stayOnCurrentPart(this);
			}
		else {
			this.lastRoad.getStartJunction().checkout(this);
			}
		}
	@Override
	public void incrementDrivingTime() {
		this.setTimeFromRouteStart(this.timeFromRouteStart+1);
		this.setTimeOnCurrentPart(timeOnCurrentPart+1);
		move();
		}
	public void checkIn() {
		this.lastRoad.getWaitingVehicles().add(this);
		this.setTimeOnCurrentPart(timeOnCurrentPart+1);
		if (this.lastRoad.getStartJunction().equals(currentRoute.getRouteParts().get(currentRoute.getRouteParts().size()-1))) {
			System.out.println(this.toString() + " has finished the route. Total time: " + this.getTimeOnCurrentPart());
			this.currentRoute=new Route(currentRoutePart,this);
			}
		}
	/**
	 * checks if out of junction
	 */
	public void checkOutJunc(Junction junc, Road road) {
		System.out.println(this.toString()+ " has left  " +junc.toString()+ ".");
		this.lastRoad.getWaitingVehicles().remove(this);
		lastRoad=road;
		}
	/**
	 * @return object
	 */
	@Override
	public String toString() {
		return "Vehicle "+this.id +" "+this.vehicleType +", average speed: " + this.vehicleType.getAverageSpeed();
	}
	
	public int getId() {
		return id;
		}
	public void setId(int id) {
		this.id = id;
		}
	public VehicleType getVehicleType() {
		return vehicleType;
		}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
		}

	public RouteParts getCurrentRoutePart() {
		return currentRoutePart;
		}
	public void setCurrentRoutePart(RouteParts currentRoutePart) {
		this.currentRoutePart = currentRoutePart;
		}
	public int getTimeFromRouteStart() {
		return timeFromRouteStart;
		}
	public void setTimeFromRouteStart(int timeFromRouteStart) {
		this.timeFromRouteStart = timeFromRouteStart;
		}
	public int getTimeOnCurrentPart() {
		return timeOnCurrentPart;
		}
	public void setTimeOnCurrentPart(int timeOnCurrentPart) {
		this.timeOnCurrentPart = timeOnCurrentPart;
		}
	public int getObjectsCount() {
		return objectsCount;
		}
	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
		}
	public String getStatus() {
		return status;
		}
	public void setStatus(String status) {
		this.status = status;
		}
	public Road getLastRoad() {
		return lastRoad;
		}
	public void setLastRoad(Road lastRoad) {
		this.lastRoad = lastRoad;
		}
	public Route getCurrentRoute() {
		return currentRoute;
		}
	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
		}
}
