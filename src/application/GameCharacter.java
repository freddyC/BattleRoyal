package application;


public class GameCharacter implements GameData {
	private GameVitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private Element element;
	private String name;
	private int experience = 0;
	private GameLoop gl;
	private GameActPlayersTurn turn;
	private UtilWatched watchedState;  
	
	public GameCharacter () {
		gl = GameLoop.getInstance();
		vitals = new GameVitals();
		weapon = new Equipment(vitals.getVital(GameStat.Intelect));
		armor = new Equipment(vitals.getVital(GameStat.Intelect));
	}
	
	public void queueTurn () throws InterruptedException {
		turn = new GameActPlayersTurn(name + "_turn_timer", 3000);
		gl.addAction(turn);
	}

	public void updateAllVitals (int hp, int mana, int stamina, int intelect, int speed) {
		vitals.updateAllVitals (hp, mana, stamina, intelect, speed);
	}

	public int getVital (GameStat stat) {
		return vitals.getVital(stat);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws InterruptedException {
		this.name = name;
		queueTurn();
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
}
