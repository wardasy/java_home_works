package utilities;

public class Point 
{
	public final static double X_min=0;
	public final static double X_max=1000000;
	public final static double Y_min=0;
	public final static double Y_max=800;
	
	private double X;
	private double Y;
	
	public Point()
	{
		this(0,0);
	}
	
	public Point(double X,double Y) 
	{
		if(!this.SetX(X))
			this.X=0;
		if(!this.SetY(Y))
			this.Y=0;
	}
	
	public Point(Point other)
	{
		if (other==null)
			other=new Point(0,0);
		this.SetX(other.X);
		this.SetY(other.Y);
		
	}
	
	public double GetX()
	{
		return X;
	}
	public double GetY()
	{
		return Y;
	}
	
	public boolean SetX(double X)
	{
		if(X_min>X||X_max<X)
		{
			return false;
		}
		this.X=X;
		return true;
	}
	
	public boolean SetY(double Y)
	{
		if(Y_min>Y||Y_max<Y)
		{
			return false;
		}
		this.Y=Y;
		return true;
	}
	



	@Override
	public String toString() {
		return "Point [X=" + X + ", Y=" + Y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(X) != Double.doubleToLongBits(other.X))
			return false;
		if (Double.doubleToLongBits(Y) != Double.doubleToLongBits(other.Y))
			return false;
		return true;
	}
	
	
}
