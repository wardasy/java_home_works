/**
 * 
 */
package utilities;
import game.Competition;
import game.GameEngine;
//import game.arenas.AlpineSkiingArena;
//import game.arenas.ExtremeSkiingArena;
import game.arenas.FreeSkiingArena;
import game.sportsmen.OldTimer;
//import game.sportsmen.Showboarder;
//import game.sportsmen.Skier;
//import game.sportsmen.SnowBunny;
//import game.sportsmen.Snowbiker;
//import game.sportsmen.SunshineSkier;

public class Program {
	public static void main(String[] args) {

		// setting the Competition rules
		Competition comp = new Competition(20, "Finals", "Male", "Expert");
		Point start = new Point(-150, -5);
		System.out.println("start = " + start);
		Point finish = new Point(1000, 0);

		// set Arena
		//AlpineSkiingArena alp = new AlpineSkiingArena(start, finish, "surface", "nice", "DownHill");
		//System.out.print("setX(-10): ");
		//System.out.println(finish.SetX(-10));
		//System.out.println("finish = " + finish);
		//System.out.print("setX(10): ");
		//System.out.println(finish.SetX(10));
		//System.out.println("alp.finish = " + alp.getFinish());

		 //the game Engine
		GameEngine game = GameEngine.getInstance();
		System.out.println("----------");
		System.out.print("Set competition: ");
		game.setComp(comp);
		//System.out.print("Set alpine Arena: ");
		//System.out.println(game.setArena(alp));
		
		
		//finish = new Point(1000, 0);
		
		//System.out.println("----------");
		//System.out.print("add Oldtimer: ");
		//System.out.println(game.addRacer(new OldTimer("Jon", 30, 78, 10, "Expert", "Male", "international")));
		
		//System.out.print("add SunshineSkier: ");
		//System.out.println(game.addRacer(new SunshineSkier("Smeth", 80, 45, 22, "Expert", "Male", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lele", 59, 30, 0.17, "Expert", "Female", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lole", 26, 100, 13.2, "Expert", "Male", "international")));
		
		//System.out.print("add SnowBunny: ");
		//System.out.println(game.addRacer(new SnowBunny("Papa", 30, 78, 20, "Expert", "Male", "international")));
		
		//game.initRace();
		//game.startRace();

		//System.out.println("----------");
		//System.out.println("----------");
		//System.out.println("----------");
		
	
		// set Arena
	    //ExtremeSkiingArena ex= new ExtremeSkiingArena(start, finish, "surface", "nice", "DownHill");
		//System.out.print("Set ExtremeSkiing Arena: ");
		//System.out.println(game.setArena(ex));
		
		
		//System.out.println("----------");
		//System.out.print("add Oldtimer: ");
		//System.out.println(game.addRacer(new OldTimer("Jon", 30, 78, 10, "Expert", "Male", "international")));
		
		//System.out.print("add SunshineSkier: ");
		//System.out.println(game.addRacer(new SunshineSkier("Smeth", 80, 45, 22, "Expert", "Male", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lele", 59, 30, 0.17, "Expert", "Female", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lole", 200, 100, 13.2, "Expert", "Male", "international")));
		
		//System.out.print("add SnowBunny: ");
		//System.out.println(game.addRacer(new SnowBunny("Papa", 30, 78, 20, "Expert", "Male", "international")));

		//System.out.print("add Showboarder: ");
		//System.out.println(game.addRacer(new Showboarder("Bob", 30, 78, 90, "Expert", "Male", "international")));

		//System.out.print("add Skier: ");
		//System.out.println(game.addRacer(new Skier("Jon", 33, 70, 100, "Expert", "Male", "international")));

		//game.initRace();
		//game.startRace();

	
	
		//System.out.println("----------");
		//System.out.println("----------");
		//System.out.println("----------");
		
		
		// set Arena
	    FreeSkiingArena fs= new FreeSkiingArena(start, finish, "surface", "nice", "DownHill");


		System.out.print("Set FreeSkiingArena Arena: ");
		System.out.println(game.setArena(fs));
		
		
		System.out.println("----------");
		System.out.print("add Oldtimer: ");
		System.out.println(game.addRacer(new OldTimer("Jon", 30, 78, 10, "Expert", "Male", "international")));
		
		System.out.print("add Oldtimer: ");
		System.out.println(game.addRacer(new OldTimer("Meshel", 40, 65, 10, "Expert", "Male", "international")));
		
		//System.out.print("add SunshineSkier: ");
		//System.out.println(game.addRacer(new SunshineSkier("Smeth", 80, 45, 22, "Expert", "Male", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lele", 59, 30, 0.17, "Expert", "Female", "international")));
		
		//System.out.print("add Snowbiker: ");
		//System.out.println(game.addRacer(new Snowbiker("Lole", 200, 100, 13.2, "Expert", "Male", "international")));
		
		//System.out.print("add SnowBunny: ");
		//System.out.println(game.addRacer(new SnowBunny("Papa", 30, 78, 20, "Expert", "Male", "international")));

		//System.out.print("add Showboarder: ");
		//System.out.println(game.addRacer(new Showboarder("Bob", 30, 78, 90, "Expert", "Male", "international")));

		//System.out.print("add Skier: ");
		//System.out.println(game.addRacer(new Skier("Jon", 33, 70, 100, "Expert", "Male", "international")));

		game.initRace();
		game.startRace();
	
	}

}
