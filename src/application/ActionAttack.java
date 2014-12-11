package application;

public class ActionAttack extends Action implements GameData {
	private int finalDamage;
	private Player attacker = null;
	private Player attackee = null;
	private ElementCoupling effect;
	
	public ActionAttack() {
		super("attack-", 5000);
		finalDamage = Tools.randomInt(8, 12);
		effect = ElementCoupling.getInstance();
	}
	
	public void calculateDamage () {
		if (attacker == null || attackee == null) return;
		calcAttackerToSword();
		calcAttackeeToArmor();
		calcAttackerToAttackeeEquipment();
	}
	
	private void calcAttackerToSword () {
		int damage = Tools.randomInt(5, 15);
		damage *= effect.getAttackRes(attacker.getElement(), attacker.getWeaponAffinity());
		finalDamage += damage;
	}
	
	private void calcAttackeeToArmor () {
		int damage = Tools.randomInt(5, 15);
		damage *= effect.getAttackRes(attackee.getElement(), attackee.getWeaponAffinity());
		finalDamage -= damage;
	}
	
	private void calcAttackerToAttackeeEquipment () {
		int damage = Tools.randomInt(5, 15);
		damage *= effect.getAttackRes(attacker.getWeaponAffinity(), attackee.getWeaponAffinity());
		finalDamage += damage;
	}
	
	public int getDamage() {
		return finalDamage;
	}

	
	@Override
	protected void update() {

	}

	@Override
	protected void performAction() {
		attackee.changeVitals(EnumStat.MissingHP, finalDamage);
	}

}
