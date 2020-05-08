/**
 * 
 */
package components;

import java.util.ArrayList;

/**Represents a Route build for an vehicle.
 * @author Sophie Krimberg
 *
 */
public class Route {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private double delay;
	private VehicleType vehicleType;
	
	/**Constructor
	 * creates an object with all given parameters
	 * @param juncs represents the junctions on the route in the order they appear on the route
	 * @param roads represents the roads of the route in the order they appear 
	 * @param vehType represents the vehicle type the route is constructed for.
	 */
	public Route(ArrayList<Junction> juncs, ArrayList<Road> roads, VehicleType vehType) {
		junctions=new ArrayList<Junction>(juncs);
		this.roads=new ArrayList<Road>(roads);
		vehicleType=new VehicleType(vehType.getName(), vehType.getSpeed());
		delay=calcDelay();
	}
	
	public Route(Junction start, Junction end, VehicleType type) {}//not implemented in this part
	
	/**Constructor
	 * builds a random route with up to 10 junctions starting from given junction and for given vehicle type
	 * @param start the junction for the route start point
	 * @param type vehicle type the route is build for.
	 */
	public Route (Junction start, VehicleType type) {//builds random route 
		ArrayList<Junction> newJuncs=new ArrayList<Junction>();
		ArrayList<Road> newRoads=new ArrayList<Road>();
		boolean flag=true;
		int j=0;
		while(flag&&j<10) {
			newJuncs.add(start);
			flag=false;
			for (int i=0; i<start.getExitingRoads().size();i++) {
				if (start.getExitingRoads().get(i).getAllowedVehicle().contains(type)&&start.getExitingRoads().get(i).getEnabled()==true) {
					newRoads.add(start.getExitingRoads().get(i));
					start=start.getExitingRoads().get(i).getToJunc();
					flag=true;
					j++;
					break;
				}
			}
		}
		roads=new ArrayList<Road>(newRoads);
		junctions=new ArrayList<Junction>(newJuncs);
		vehicleType=type;
		delay=calcDelay();
		
	}
	
	/**Calculates the estimated time that will take to current vehicle type to pass the route
	 * 
	 * @return double represents the estimated time
	 */
	public double calcDelay() {
		return calcJuncsDelay()+calcRoadsDelay();
	}
	
	/**Calculates the estimated time to pass all the junctions of the route
	 * 
	 * @return double represents the estimated time
	 */
	private double calcJuncsDelay() {
		double result=0;
		for (int i=1; i<junctions.size();i++) {
			result+=junctions.get(i).calcDelay(roads.get(i-1));
		}
		//the previous road of the first junction is unknown, so we calculate it by worst case
		if (getStart().getLights()) {
			return result+ getStart().calcDelay(null);
			}
		else return result+getStart().getEnteringRoads().size()-1;
	}
	
	
	/**Calculates the estimated time to pass all the roads of the route
	 * 
	 * @return double represents the estimated time
	 */
	private double calcRoadsDelay() {
		double result=0;
		for (int i=0; i<roads.size();i++) {
			result+=roads.get(i).calcDelay(vehicleType);
		}
		return result;
	}
	
	/**Gets the first junction on the road
	 * 
	 * @return Junction
	 */
	public Junction getStart() {
		return junctions.get(0);
	}
	
	/**Gets the last junction on the road
	 * 
	 * @return Junction
	 */
	public Junction getEnd() {
		return junctions.get(junctions.size()-1);
	}
	
	/**Gets estimated time to pass the route for current vehicle type
	 * 
	 * @return double
	 */
	public double getDelay() {
		return delay;
	}
	
	/**Gets the junctions of the route
	 * 
	 * @return ArrayList<Junction> holds the list of route junctions
	 */
	public ArrayList<Junction> getJunctions(){
		return junctions;
	}
	
	@Override //javadoc will be generated from the super method
	public String toString() {
		return "Route from " + getStart().toString() + " to " + getEnd().toString();
	}
	
	/**Prints the route components by moving order
	 * 
	 */
	public void printRoute() {
		for (int i=0; i<roads.size(); i++) {
			System.out.print(junctions.get(i).toString()+", "+roads.get(i)+ ", ");
		}
		System.out.println(getEnd().toString());
	}
	/**Gets the quantity of roads in the route
	 * 
	 * @return int represents quantity of roads
	 */
	public int getSize() {
		return roads.size();
	}
	
	/**Gets a junction with a given index in the junctions array of the route
	 * 
	 * @param index given index
	 * @return Junction
	 */
	public Junction getJunction (int index) {
		return junctions.get(index);
	}
	
	/**Gets a road with a given index in the roads array of the route
	 * 
	 * @param index given index
	 * @return Road
	 */
	public Road getRoad(int index) {
		return roads.get(index);
	}
	
}
