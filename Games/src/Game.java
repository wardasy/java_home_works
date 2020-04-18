
public abstract class Game {  
	private Player p1, p2;  
	private String name;    
	//game name  
	protected Action[] actions; 
	// the set of actions  
	public Game(Player p1, Player p2, String name){
		this.name = new String(name);	
		this.p1=p1;
		this.p2=p2;
	} 
	protected abstract void initActions();  
	public void play(int turnCount) {
		int i=0;
		while( i<turnCount) { 
			 playSingleTurn();
			 i++;
			 }
	}
	private void playSingleTurn() {
		rewardPlayers(p1.selectAction(actions),p2.selectAction(actions));
	}
	protected abstract void rewardPlayers(Action a1, Action a2); 
	public Player getWinner () {
		if(p1.isWinner(p2))
			 return p1;
		 return p2;
		 }
	public Player getLoser () {
		 if(p1.isWinner(p2))
			 return p2;
		 return p1;
		 }
	protected Player getFirstPlayer() {
		 return this.p1; 
		 }
	protected Player getSecondPlayer() {
		 return this.p2; 
		 }
	public String getName() {
		return name;
		}
}
