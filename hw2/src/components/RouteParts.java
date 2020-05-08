/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import utilities.Utilities;
/**
 *  Interface Route Parts 
 *
 */
public interface RouteParts extends Utilities{
	double calcEstimatedTime(Object obj);
	boolean canLeave(Vehicle vehicle);
	void checkIn(Vehicle vehicle);
	void checkout(Vehicle vehicle);
	RouteParts findNextPart(Vehicle vehicle);
	void stayOnCurrentPart(Vehicle vehicle); 
}
