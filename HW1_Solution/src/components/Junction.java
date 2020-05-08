/**
 * 
 */
package components;
import utilities.Point;
import java.util.Random;
import java.util.ArrayList;
/**Represents a junction
 * @author Sophie Krimberg
 */
public class Junction {
	
	private String junctionName;
	private Point location;
	private ArrayList <Road> enteringRoads;
	private ArrayList <Road> exitingRoads;
	private boolean hasLights;
	private int delay;
	private ArrayList <Road> vehicles;
	private int greenIndex;//the index of the entering road with current green light
	private final int maxDelay=8;//max delay time for traffic lights
	
	/**Constructor
	 * @param name String contains name of junction
	 * @param loc Point object contains the junction location
	 */
	public Junction (String name, Point loc) {
		
		junctionName=new String(name);
		location=new Point(loc.getX(), loc.getY());
		enteringRoads= new ArrayList<Road>();
		exitingRoads= new ArrayList<Road>();
		hasLights=false;
		delay=0;
		vehicles=new ArrayList<Road>();
		greenIndex=-1;
		System.out.println(this+ " has been created.");
	}

	/**For working traffic lights, moves the green light to the next entering road
	 *
	 */
	public void changeLights() {
		if (enteringRoads.size()==0) {
			System.out.println(this.toString() + ": No entering roads, can not change lights");
			return;
		}
		greenIndex=++greenIndex % enteringRoads.size();
		this.setGreenLight(greenIndex);
	}
	
	/** Name field getter
	 * @return String contains junction name
	 */
	public String getName() {
		return junctionName;
	}
	
	/**Location field getter
	 * @return Point represents the Cartesian location of the junction
	 */
	public Point getLocation() {
		return location;
	}
	
	/**Entering roads getter
	 * @return ArrayList<Road> holds the entering roads of the junction
	 */
	public ArrayList<Road> getEnteringRoads(){
		return enteringRoads;
	}
	
	/** Exiting roads getter
	 * @return ArrayList<Road> holds the exiting roads of the junction
	 */
	public ArrayList<Road> getExitingRoads(){
		return exitingRoads;
	}
	
	/**Gets vehicle field
	 * @return ArrayList<Road> holds the entering roads of the junction that have waiting vehicles
	 */
	public ArrayList<Road> getVehicles(){
		return vehicles;
	}
	
	/**hasLights getter
	 * @return a boolean represents the existing of traffic lights at the junction
	 */
	public boolean getLights() {
		return hasLights;
	}
	
	/**Gets the index of the entering road with current green light
	 * @return integer for index of the road in the enteringRoads array
	 */
	public int getGreenIndex() {
		return greenIndex;
	}
	
	/**Gets traffic lights delay
	 * @return integer represents the delay time
	 */
	public int getDelay() {
		return delay;
	}
	
	/**Sets the junction name
	 * @param name A String represents junction name
	 */
	public void setName(String name) {
		junctionName=new String(name);
	}
	
	/**Sets the junction location
	 * @param loc A Point represents junction Cartesian coordinates.
	 */
	public void setLocation(Point loc) {
		location = new Point (loc.getX(), loc.getY());
	}
	
	/**Restarts traffic lights
	 * Is used in situations when the enteringRoads array is changed.
	 */
	public void resetLights() {
		setLightsOf();
		setLightsOn();
	}
	
	/**Sets the traffic lights to the ON mode
	 */
	public void setLightsOn() {
		
		if (enteringRoads.size()>0) {
			for (Road road: enteringRoads) {road.setIsOpen(false);}//reset all entering roads to red first
			greenIndex=new Random().nextInt(enteringRoads.size());
			hasLights=true;
			setDelay(new Random().nextInt(maxDelay));
			System.out.println(this.toString() +": traffic lights ON. Delay time: " + delay);
			setGreenLight(greenIndex);
		}
		else System.out.println(this.toString() + ": No entering roads, traffic lights can't be turned on.");
	}
	
	/**Sets the traffic lights to the OFF mode
	 */
	public void setLightsOf() {
		enteringRoads.get(getGreenIndex()).setIsOpen(false);//turn off current green light
		hasLights=false;
		greenIndex=-1;
	}
	
	/**Sets the delay time for traffic lights
	 * @param del An integer represents the delay time
	 */
	public void setDelay(int del) {
		delay=del;
	}
	
	/**Sets the traffic lights to green light for an entering road
	 * @param index integer for the index of the road in the enteringRoads array
	 */
	public void setGreenLight(int index) {
		if(!hasLights) {
			System.out.println(this.toString() +" traffic lights are OFF");
		}
		if(greenIndex>=0) {
			
			enteringRoads.get(greenIndex).setIsOpen(false);
			greenIndex=index;
			enteringRoads.get(greenIndex).setIsOpen(true);
			System.out.println(enteringRoads.get(greenIndex).toString() + ": green light");
			
		}
		
	}
	
	/**Sets the entering roads array for junction
	 * @param ArrayList<Road> holds the list of entering roads of the junction.
	 */
	public void setEnteringRoads(ArrayList<Road>roads) {
		enteringRoads=new ArrayList<Road>(roads);
	}
	
	/**Sets the exiting roads array for junction
	 * @param roads ArrayList<Road> holds the list of exiting roads of the junction.
	 */
	public void setExitingRoads(ArrayList<Road>roads) {
		exitingRoads=new ArrayList<Road>(roads);
	}
	
	/**Sets the "vehicles" array  of roads
	 * @param roads ArrayList<Road> holds the list of entering roads that have waiting vehicles on them.
	 */
	public void setVehicles(ArrayList<Road> roads) {
		vehicles=new ArrayList<Road>(roads);
	}
	
	/**Adds an entering road to the enteringRoads array
	 * @param road Road representing the added entering road.
	 */
	public void addEnteringRoad(Road road) {
		enteringRoads.add(road);
		if (getLights()) {resetLights();}//reset lights if lights is on
	}
	

	/**Adds an exiting road to the exetingRoads array
	 * @param road Road representing the added exiting road.
	 */
	public void addExitingRoad(Road road) {
		exitingRoads.add(road);
	}
	

	/**Adds an entering road to the vehicle array
	 * @param road Road representing the added entering road that has waiting vehicle on it.
	 */
	public void addVehicle(Road road) {
		vehicles.add(road);
	}
	
	/**Checks for vehicle the ability to cross the junction.
	 * @param r Road represents the road that led the checking vehicle to the junction.
	 * @return a boolean representing the availability of the junction.
	 */
	public boolean checkAvailability(Road r) {
		
		int index=enteringRoads.indexOf(r);
		
		for (int i=0; i<vehicles.size();i++) {
			if (enteringRoads.indexOf(vehicles.get(i))<index) {
				return false;
			}
		}
		return true;
	}
	
	
	/**Returns a string representation of the object
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return new String("Junction " + junctionName);
	}
	
	
	/**Indicates whether some other object is "equal to" this one.
	 * @param obj Object that is compared to this one.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		Junction other=(Junction)obj;
		if ( other==null||
			!this.enteringRoads.equals(other.enteringRoads)||
			!this.exitingRoads.equals(other.exitingRoads)||
			!this.vehicles.equals(other.vehicles)||
			!this.junctionName.equals(other.junctionName)||
			!(this.hasLights==other.hasLights)||
			!(this.delay==other.delay)||
			!(this.greenIndex==other.greenIndex)||
			!this.location.equals(other.location)) {
		
				return false;
		}
		
		
		
		return true;
	}

	/**Calculates the estimated delay time on the junction for vehicle that arrived from specific road
	 * @param road A Road represents the entering road the vehicle arrives from to the junction.
	 * @return double represents the estimated delay time
	 */
	public double calcDelay(Road road) {
		if(hasLights) {
			return delay*(enteringRoads.size()-1);
		}
		else {
			return enteringRoads.indexOf(road);
		}
	}
}
