/**
 * 
 */
package utilities;
/**
 * @author Sophie Krimberg
 *
 */
public class Point {
	
	private double x;
	private double y;
	private final int min =0;
	private final int xMax=1000000;
	private final int yMax=800;
	
	/**Constructor
	 * creates point with given values
	 * if given values are illegal replaces them with random generated values
	 * @param xVal
	 * @param yVal
	 */
	public Point(double xVal, double yVal) {
		
		if (xVal<min || xVal>xMax) {
			x=Math.random()*((xMax-min)+1)-min;
			errorMessage(xVal,x,'X');
		}
		else {
			x=xVal;
		}
		if (yVal<min || yVal>yMax) {
			y=Math.random()*((yMax-min)+1)-min;
			errorMessage(yVal,y,'Y');
		}
		else {
			y=yVal;
		}
		
		System.out.println("Point ("+x+" , "+y+") has been created");
			
	}
	/**Constructor
	 * creates random Point object
	 */
	public Point() {
		x=Math.random()*((xMax-min)+1)-min;
		y=Math.random()*((yMax-min)+1)-min;
		System.out.println("Point ("+x+" , "+y+") has been created");
	}
	
	/**prints message about replacing illegal values with random generated
	 * 
	 * @param wrong illegal value
	 * @param right new legal value 
	 * @param coordinate variable name for value
	 */
	private void errorMessage(double wrong, double right, char coordinate) {
		
		System.out.println("The value " + wrong + " is illegal for" +coordinate +", therefore has been replaced with " + right);
	}
	  
	/**Get x value
	 * 
	 * @return double x
	 */
	public double getX() {
		return x;
	}
	
	/**Get x value
	 * 
	 * @return double x
	 */
	public double getY() {
		return y;
	}
	
	/**Sets given value to x
	 * 
	 * @param xVal given value
	 * @return true if value is legal and has been set successfully
	 */
	public boolean setX(double xVal) {
		
		if (xVal>=min && xVal<=xMax) {
			x=xVal;
			return true;
		}
		
		else {
			System.out.println("The value "+ xVal + " is illegal for x");
			return false;
			
		}
	}
	
	/**Sets given value to y
	 * 
	 * @param yVal given value
	 * @return true if value is legal and has been set successfully
	 */
	public boolean setY(double yVal) {
		
		if (yVal>=min && yVal<=yMax) {
			y=yVal;
			return true;
		}
		
		else {
			System.out.println("The value "+ yVal + " is illegal for y");
			return false;
		}
	}

	@Override 
	public String toString() {
		
		String str= new String("(" + x + " , " + y + ")");
		return str;
	}
	
	/**Indicates whether some other Point object is "equal to" this one.
	 * @param other Point that is compared to this one.
	 * @return true if this object is the same as the other argument; false otherwise.
	 */
	public boolean equals(Point other) {
		if (this.x==other.x && this.y==other.y) {
			return true;
		}
		else return false;
	}
}	
