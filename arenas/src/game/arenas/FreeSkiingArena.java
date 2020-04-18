package game.arenas;

import java.util.ArrayList;

import game.sportsmen.OldTimer;
import utilities.Point;

public class FreeSkiingArena 
{
	private ArrayList<OldTimer> oldTimer;
	private Point start;
	private Point finish;
	private ArrayList<OldTimer> finished;
	private static final double FRICTION=0.7;
	private static final int MAX_RACERS=8;
	private String surface;
	private String condition;
	private String discipline;
	
	public FreeSkiingArena(Point start,Point finish,String surface,String condition,String discipline)
	{
		this.start=new Point(start.GetX(),start.GetY());
		this.finish=new Point(finish.GetX(),finish.GetY());
		this.surface=surface;
		this.condition=condition;
		this.discipline=discipline;
		oldTimer=new ArrayList<OldTimer>();
		finished=new ArrayList<OldTimer>();
	}
	
	public boolean add(OldTimer newCompetitor)
	{
		if(getNumOfRacers()<MAX_RACERS)
		{
			this.oldTimer.add(newCompetitor);
		}
		return false;
	}
	
	public int crossFinishLine(OldTimer sportmen)
	{
		finished.add(sportmen);
		oldTimer.remove(sportmen);
		return finished.size();
	}
	
	public int getNumOfRacers()
	{
		return oldTimer.size();
	}
	
	public void initRace()
	{
		for(OldTimer i:oldTimer)
		{
			i.initRace(start);
		}
	}
	
	@SuppressWarnings("unused")
	public boolean playTurn()
	{
		for(int i=0;i<oldTimer.size();i++)
		{
			if(!(oldTimer.get(i).move(finish, FRICTION)))
			{
				crossFinishLine(oldTimer.get(i));
			}
			return true;
		}
		if(getNumOfRacers()==0)
			return false;
		return true;
	}

	public ArrayList<OldTimer> getOldTimer() {
		return oldTimer;
	}

	public void setOldTimer(ArrayList<OldTimer> oldTimer) {
		this.oldTimer = oldTimer;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getFinish() {
		return finish;
	}

	public void setFinish(Point finish) {
		this.finish = finish;
	}

	public ArrayList<OldTimer> getFinished() {
		return finished;
	}

	public void setFinished(ArrayList<OldTimer> finished) {
		this.finished = finished;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public static double getFriction() {
		return FRICTION;
	}

	public static int getMaxRacers() {
		return MAX_RACERS;
	}

	@Override
	public String toString() {
		return "FreeSkiingArena [oldTimer=" + oldTimer + ", start=" + start + ", finish=" + finish + ", finished="
				+ finished + ", surface=" + surface + ", condition=" + condition + ", discipline=" + discipline + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreeSkiingArena other = (FreeSkiingArena) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (finish == null) {
			if (other.finish != null)
				return false;
		} else if (!finish.equals(other.finish))
			return false;
		if (finished == null) {
			if (other.finished != null)
				return false;
		} else if (!finished.equals(other.finished))
			return false;
		if (oldTimer == null) {
			if (other.oldTimer != null)
				return false;
		} else if (!oldTimer.equals(other.oldTimer))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}

	
}
