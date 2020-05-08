/**
 * 
 */
package components;


import utilities.Point;

import java.util.Random;
/**Represents Vehicle
 * @author Sophie Krimberg
 *
 */
public class Vehicle {
	int id;
	VehicleType type;
	Route currentRoute;
	Junction lastJunction;
	Road lastRoad;
	boolean movesNow=false;
	double spentTime=0;

	/**Constructor
	 * creates an object with given parameters, sets random route.
	 * @param id
	 * @param type
	 * @param lastJunction
	 */
	public Vehicle(int id, VehicleType type, Junction lastJunction) {
		
		this.id=id;
		this.type=type;
		this.lastJunction=lastJunction;
		currentRoute=new Route(lastJunction, type);
		
		if (lastJunction.getEnteringRoads().size()==0) {//last junction has to have entering roads
			Junction dummy=new Junction("dummy", new Point());
			Road dummyRoad=new Road(dummy, lastJunction);
			lastRoad=dummyRoad;
		}
		//select random entering road
		lastRoad=lastJunction.getEnteringRoads().get(new Random().nextInt(lastJunction.getEnteringRoads().size()));
		System.out.println(this.toString() + " has been created and placed at " +lastJunction+ ".");
	}
	
	/**Gets vehicle Id
	 * 
	 * @return int vehicle id
	 */
	public int getId() {
		return id;
	}
	
	/**Sets vehicle id
	 * 
	 * @param newID
	 */
	public void setId(int newID){
		id=newID;
	}
	
	/**Gets vehicle type
	 * 
	 * @return VehicleType object represents vehicle type
	 */
	public VehicleType getType() {
		return type;
	}
	
	/**Sets vehicle type to given type
	 * 
	 * @param type given vehicle type
	 */
	public void setType(VehicleType type) {
		this.type=type;
	}
	
	/**Gets current route
	 * 
	 * @return Route current route
	 */
	public Route getRoute() {
		return currentRoute;
	}
	
	/**Sets given route to vehicle
	 * 
	 * @param route represents given route
	 */
	public void setRoute(Route route) {
		currentRoute=route;
	}
	
	/**Gets the last junction vehicle visited
	 * @return Junction last visited junction
	 */
	public Junction getLastJunction(){
		return lastJunction;
	}
	
	/**Sets last junction
	 * 
	 * @param junc last visited junction
	 */
	public void setLastJunction(Junction junc) {
		lastJunction=junc;
	}
	
	/**Gets last road
	 * 
	 * @return Road last road
	 */
	public Road getLastRoad() {
		return lastRoad;
	}
	
	/**Sets last road
	 * 
	 * @param road Road object
	 */
	public void setLastRoad(Road road) {
		lastRoad=road;
	}
	
	/**Gets movesNow
	 * 
	 * @return true for moves, otherwise false
	 */
	public boolean getMovesNow() {
		return movesNow;
	}
	
	/**Gets spent time
	 * @return double represents time spent on the route
	 */
	public double getSpentTime() {
		return spentTime;
	}
	
	@Override
	public String toString() {
		return new String (type+", "+ " ID: " + id);
	}
	
	/**Check in procedure for vehicle that just arrived to a junction
	 * 
	 */
	public void checkIn() {
		lastJunction.addVehicle(lastRoad);
		movesNow=false;
		spentTime+=lastRoad.calcDelay(type);
		System.out.println(this.toString()+" has arrived to "+lastJunction.toString()+".");
		
		if (lastJunction.equals(currentRoute.getEnd())) {
			
			System.out.println(this.toString() + " has finished the route. Total time: " + spentTime);
			currentRoute=new Route(lastJunction, this.type);//start new Route
		}
	}
	
	/**Check out procedure for vehicle that is leaving a junction
	 * 
	 */
	public void checkOutJunc(Junction junc, Road road) {
		
		junc.getVehicles().remove(lastRoad);
		lastRoad=road;
		movesNow=true;
		
		System.out.println(this.toString()+ " has left  " +junc.toString()+ ".");
		System.out.println(this.toString()+ " is moving on  " +road.toString()+ ". Delay time: " + road.calcDelay(type)+".");
		
	}
	/**moves the vehicle from current junction to the next one on its route
	 * 
	 */
	public void move() {
		if(lastJunction.equals(currentRoute.getEnd())) {//for routes that start at junctions with no exiting roads
			System.out.println(this.toString()+ " stays at "+lastJunction + " - no exiting roads.");
			spentTime+=1;
			return;
		}
		if (lastJunction.equals(currentRoute.getStart())) {//starting route
			spentTime=0;
			System.out.println(this.toString()+ " is starting route from "+this.currentRoute.getStart().toString()+ " to " + this.currentRoute.getEnd().toString()+ ".");
		}
		if (lastJunction.getLights()&&!lastRoad.getIsOpen()) {//red light
			System.out.println(this+ " is waiting for green light at " + lastJunction);
			spentTime+=lastJunction.getDelay();
			return;
		}
		if (!lastJunction.getLights()&&!lastJunction.checkAvailability(lastRoad)) {
			System.out.println(this+ " is waiting for his priority at " + lastJunction);
			spentTime+=1;
			return;
		}
		int index=currentRoute.getJunctions().indexOf(lastJunction);
		checkOutJunc(lastJunction, currentRoute.getRoad(index) );
		lastJunction=currentRoute.getJunction(index+1);
		checkIn();
	
			
	}
	/**Prints the vehicle status
	 * 
	 */
	public void status() {
		System.out.print(this.toString() + ". Position: ");
		if(movesNow) {
			System.out.print(lastRoad.toString());
			}
		else {
			System.out.print(lastJunction.toString());
		}
		System.out.println(" .Current Route: from "+currentRoute.getStart()+" to "+currentRoute.getEnd()+". Time spent: "+ spentTime +".");
		
	}
	
}