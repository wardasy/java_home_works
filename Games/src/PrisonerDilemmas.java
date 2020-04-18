
public class PrisonerDilemmas extends Game{
	public PrisonerDilemmas(Player p1, Player p2){   
		super(p1, p2, "Prisoner's Dilemma");
		}  
	protected void initActions(){
		actions=new Action[2];
		actions[0]=new Action("TO BE QUIET");
		actions[1]=new Action("TO SPEAK");
	}
	protected void rewardPlayers(Action a1, Action a2) 
	{
		if(a1.equals(actions[0])){
			 if(a2.equals(actions[0])){
				getFirstPlayer().updateScore(-1);
				getSecondPlayer().updateScore(-1);
			 }
			 else if(a2.equals(actions[1])){
				 getFirstPlayer().updateScore(-15);
				 getSecondPlayer().updateScore(0);
				 }
			 }
		else if(a1.equals(actions[1])) {
			if(a2.equals(actions[0])){
				getFirstPlayer().updateScore(0);
				getSecondPlayer().updateScore(-15);
			 }
			 else if(a2.equals(actions[1])){
				getFirstPlayer().updateScore(-5);
				getSecondPlayer().updateScore(-5);
			 }
		}
	}
}