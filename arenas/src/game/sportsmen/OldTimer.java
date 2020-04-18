package game.sportsmen;

import utilities.Point;

public class OldTimer 
{
	private String name;
	private Point currentLocation;
	private double maxSpeed;
	private double acceleration;
	private double currentSpeed;
	private String qualification;
	private String gender;
	private double age;
	private String league;
	////////////////////////////////////////////////////////////
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Point d) {
		this.currentLocation = d;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	////////////////////////////////////////////////////////////////
	public OldTimer(String name,double maxSpeed,double age,double acceleration ,String qualification,String gender,String league)
	{
		this.name=name;
		this.maxSpeed=maxSpeed;
		this.age=age;
		this.acceleration=acceleration;
		this.qualification=qualification;
		this.gender=gender;
		this.league=league;
	}
	
	public OldTimer(Point start)
	{
		this.currentLocation=new Point(start.GetX(),start.GetY());
	}
	
	public void initRace(Point start)
	{
		this.currentLocation=new Point(start);
	}
	
	public boolean move(Point finish,double friction)
	{
		if(this.maxSpeed < getMaxSpeed())
		{
			currentSpeed+=acceleration*friction;
			currentLocation.SetX(currentLocation.GetX()+currentSpeed);
			currentLocation.SetY(0);
			if(this.currentLocation==finish)
			{
				return false;
			}
			System.out.println(this.name + "My Location"+ currentLocation.toString()+ "My Speed is"+ currentSpeed);
			return true;
		}
		return false;
	}
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	
	@Override
	public String toString() {
		return "OldTimer [name=" + name + ", currentLocation=" + currentLocation + ", maxSpeed=" + maxSpeed
				+ ", acceleration=" + acceleration + ", currentSpeed=" + currentSpeed + ", qualification="
				+ qualification + ", gender=" + gender + ", age=" + age + ", league=" + league + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OldTimer other = (OldTimer) obj;
		if (Double.doubleToLongBits(acceleration) != Double.doubleToLongBits(other.acceleration))
			return false;
		if (Double.doubleToLongBits(age) != Double.doubleToLongBits(other.age))
			return false;
		if (currentLocation == null) {
			if (other.currentLocation != null)
				return false;
		} else if (!currentLocation.equals(other.currentLocation))
			return false;
		if (Double.doubleToLongBits(currentSpeed) != Double.doubleToLongBits(other.currentSpeed))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (Double.doubleToLongBits(maxSpeed) != Double.doubleToLongBits(other.maxSpeed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		return true;
	}
	
}
