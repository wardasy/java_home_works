/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Random;

public class SequentialTrafficLights  extends TrafficLights {

	private int increment;
	
	/**Constructor
	 * @param ArrayList of roads 
	 */
	public SequentialTrafficLights(ArrayList<Road> roads) {
		super(roads);
	}
	/**
	 * method "changeIndex" returns index for green light.
	 */
	public void changeIndex() {
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
		}
}
