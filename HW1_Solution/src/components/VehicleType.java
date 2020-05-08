/**
 * 
 */
package components;

import java.util.ArrayList;
import java.util.Random;

/**Represents Vehicle Type
 * @author Sophie Krimberg
 *
 */
public class VehicleType {
	private String typeName;
	private int speed;
	public static ArrayList <VehicleType> vehicleTypes= new ArrayList<VehicleType>();
	
	

	/**Constructor
	 * 
	 * @param name vehicle type name
	 * @param speed average speed
	 */
	public VehicleType(String name, int speed) {
		typeName=name;
		this.speed=speed;
		
	}
	
	@Override
	public String toString() {
		return new String(typeName+", average speed: " + speed);
	}
	

	/**Indicates whether some other VehicleType object is "equal to" this one.
	 * @param other VehicleType that is compared to this one.
	 * @return true if this object is the same as the other argument; false otherwise.
	 */
	public boolean equals (VehicleType other) {
		
		if (typeName.compareTo(other.typeName)==0&&speed==other.speed) {
			return true;
		}
		return false;
	}
	
	/**Gets vehicle type name
	 * 
	 * @return String vehicle type name
	 */
	public String getName() {
		return typeName;
	}
	
	/**Gets average speed
	 * 
	 * @return int average speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**Initiates static list of vehicle types
	 * 
	 */
	private static void setVehicleTypes() {
		
		vehicleTypes.add( new VehicleType("car",90));
		vehicleTypes.add( new VehicleType("bus",60));
		vehicleTypes.add( new VehicleType("bicycle",40));
		vehicleTypes.add( new VehicleType("motorcycle",120));
		vehicleTypes.add( new VehicleType("truck",80));
		vehicleTypes.add( new VehicleType("tram",50));
		vehicleTypes.add( new VehicleType("semitrailer",80));
			
	}
	
	/**Static method gets random list of vehicle types
	 * 
	 * @return ArrayList<VehicleType> contains list of random vehicle types
	 */
	public static ArrayList<VehicleType> getRandomVehicleTypes(){
		if(vehicleTypes.size()==0)
			setVehicleTypes();
		ArrayList<VehicleType> newList =new ArrayList<VehicleType>();
		for (int i=0; i<vehicleTypes.size();i++) {
			if (new Random().nextBoolean()) {
				newList.add(vehicleTypes.get(i));
			}
		}
		if (newList.size()==0) {
			newList=getRandomVehicleTypes();
		}
		return newList;
	}
	
	
}
