
public class GameDriver {
	public static void main(String[] args) {
		Player p1 = new ConsecutivePlayer("warda");
		Player p2 = new RandomPlayer("naseem");
		Game G1 = new PrisonerDilemmas(p1,p2);
		System.out.println("GAME \""+G1.getName()+"\" is starting now!");
		System.out.println("------------------------------------------");
		G1.play(25);
		Player winner= G1.getWinner();
		Player loser = G1.getLoser();
		if(winner.getScore() != loser.getScore()){
			System.out.println("WINNER IN GAME \""+G1.getName()+"\" is "+winner.getName());
			System.out.println("SCORE OF WINNER IS"+winner.getScore());
			System.out.println("THIS PLAYER "+loser.getName()+" LOST GAME");
			System.out.println("SCORE IS "+loser.getScore());
		}
		else{
			System.out.println("NO WINNER IN GAME\""+G1.getName()+"\", BOTH "+winner.getName()+" & "+loser.getName());
			System.out.println(" THERE SCORE IS"+winner.getScore());
			}
			p1.updateScore(-(p1.getScore()));
			p2.updateScore(-(p2.getScore()));
			System.out.println("------------- RESTART----------");
			System.out.println("SCORR FOR "+p1.getName()+" is "+p1.getScore());
			System.out.println("SCORE FOR "+p2.getName()+" is "+p2.getScore());
			Game G2 = new RockPaperScissors(p1,p2);
			System.out.println("GAME \""+G2.getName()+"\"STARTS NOW");
			
			G2.play(25);
			winner = G2.getWinner();
			loser = G2.getLoser();
			if(winner.getScore() != loser.getScore())
			{
				System.out.println("WINNER IN GAME \""+G2.getName()+"\" is "+winner.getName());
				System.out.println("SCORE OF WINNER IS"+winner.getScore());
				System.out.println("THIS PLAYER "+loser.getName()+" LOST GAME");
				System.out.println("HIS SCORE IS "+loser.getScore());
			}
			else{
				System.out.println("NO WINNER IN GAME \""+G2.getName()+"\",BOTH "+winner.getName()+"& "+loser.getName());
				System.out.println(" THERE SCORE IS"+winner.getScore());
				}
	}
	
}
