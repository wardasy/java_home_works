/**
 * 
 */
package components;
import java.util.ArrayList;
import java.util.Random;
/**Represents a Road that connects between two junctions.
 * @author Sophie Krimberg
 *
 */
public class Road {
	
	private Junction fromJunc;
	private Junction toJunc;
	private ArrayList<VehicleType> allowedVehicle;
	private boolean isOpen;
	private boolean isEnabled;
	private double length;
	private int maxSpeed;
	private final int [] speeds = new int[] {30,55,60,70,90,110};
	

	/**Constructor
	 * 	creates a new Road between 2 given junctions
	 *  sets random max allowed speed and vehicle types.
	 * @param from represents the start junction
	 * @param to represents the end junction
	 */
	public Road(Junction from, Junction to) {
		
		fromJunc=from;
		toJunc=to;
		allowedVehicle=VehicleType.getRandomVehicleTypes();
		isOpen=false;
		countLength();
		isEnabled=true;
		maxSpeed=new Random().nextInt(speeds.length);
		maxSpeed=speeds[maxSpeed];
		toJunc.addEnteringRoad(this);
		fromJunc.addExitingRoad(this);
				
	}
	
	/**Constructor
	 * 	creates a new Road between 2 given junctions with given parameters
	 *  sets random max allowed speed.
	 * @param from represents the start junction
	 * @param to represents the end junction
	 */
	public Road(Junction from, Junction to, ArrayList<VehicleType>allowed, boolean open, boolean enable) {
		
		fromJunc=from;
		toJunc=to;
		allowedVehicle=new ArrayList<VehicleType>(allowed);
		isOpen=open;
		countLength();
		isEnabled=enable;
		maxSpeed=new Random().nextInt(speeds.length);
		maxSpeed=speeds[maxSpeed];
		toJunc.addEnteringRoad(this);
		fromJunc.addExitingRoad(this);
		System.out.println(this.toString() + " has been created.");
	}
	
	/**Sets IsOpen field to true for green light and false for red
	 * 
	 * @param bool is true for green light and false for red
	 */
	public void setIsOpen(boolean bool) {
		isOpen=bool;
	}
	
	/**Calculates the road length
	 * 
	 */
	public void countLength() {
		length=Math.sqrt(Math.pow(toJunc.getLocation().getX()-fromJunc.getLocation().getX(),2)+Math.pow(toJunc.getLocation().getY()-fromJunc.getLocation().getY(),2));
		
	}
	
	/**Sets the start Junction of the road
	 * and updates all the affected objects
	 * 
	 * @param from represents the given junction
	 */
	public void setFromJunc(Junction from) {
		fromJunc.getExitingRoads().remove(this);
		fromJunc=from;
		fromJunc.addExitingRoad(this);
		countLength();
	}
	
	/**Sets the end Junction of the road
	 * and updates all the affected objects
	 * 
	 * @param to represents the given junction
	 */
	public void setToJunc(Junction to) {
		toJunc.getEnteringRoads().remove(this);
		if(toJunc.getLights()) {toJunc.resetLights();}//reset lights at the old junction
		toJunc=to;
		toJunc.addEnteringRoad(this);
		toJunc.resetLights();//reset lights at the new junction
		countLength();
	}
	
	/**Sets max allowed speed to a given value
	 * 
	 * @param speed represents the given speed
	 */
	public void setMaxSpeed(int speed) {
		maxSpeed=speed;
	}
	
	/**Sets allowed vehicle types
	 * 
	 * @param vehicleList a list of allowed vehicle types.
	 */
	public void setAllowedVehicle(ArrayList<VehicleType> vehicleList) {
		
		allowedVehicle=new ArrayList<VehicleType>(vehicleList);
	}
	
	/**Gets the start junction
	 * 
	 * @return Junction
	 */
	public Junction getFromJunc() {
		return fromJunc;
	}
	
	/**Gets the end junction
	 * 
	 * @return Junction
	 */
	public Junction getToJunc() {
		return toJunc;
	}
	
	/**Gets the list of allowed vehicles
	 * 
	 * @return ArrayList<VehicleType>
	 */
	public ArrayList<VehicleType> getAllowedVehicle(){
		return allowedVehicle;
	}
	
	/**Gets the road lenth value
	 * 
	 * @return double for the road length
	 */
	public double getLength() {
		return length;
	}
	
	/**Gets isOpen field
	 * 
	 * @return true for green light and false for red
	 */
	public boolean getIsOpen() {
		return isOpen;
	}
	
	/**Gets max allowed speed
	 * 
	 * @return int represents speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**Sets isEnable field
	 * 
	 * @param bool represents the appearance of the road on the map. 
	 */
	public void setEnabled(boolean bool) {
		isEnabled=bool;
	}
	
	/**Gets isEnable field
	 * 
	 * @return true for road that appears on the map and false for disabled one
	 */
	public boolean getEnabled() {
		return isEnabled;
	}
	
	/**Adds a vehicle type to the existing allowed vehicle types list
	 * 
	 * @param type for given vehicle type to be added
	 */
	public void addVehicleType(VehicleType type) {
		allowedVehicle.add(type);
	}
	
	@Override
	public String toString() {
		return "Road from " + fromJunc.getName()+" to " +toJunc.getName();
	}
	
	/**Indicates whether some other Road object is "equal to" this one.
	 * @param other Road that is compared to this one.
	 * @return true if this object is the same as the other argument; false otherwise.
	 */
	public boolean equals(Road other) {
		if (fromJunc.equals(other.fromJunc)&&
			toJunc.equals(other.toJunc)&&
			allowedVehicle.equals(other.allowedVehicle)&&
			isOpen==other.isOpen&&
			isEnabled==other.isEnabled&&
			maxSpeed==other.maxSpeed) {
				return true;
		}
		return false;
			
	}
	
	/**Calculates the estimated time that takes the given vehicle type to pass the road
	 * 
	 * @param type represents the given VehicleType
	 * @return double
	 */
	public double calcDelay(VehicleType type) {
		return length/Math.min(type.getSpeed(), maxSpeed);
	}
}
