package application;

import java.util.HashMap;

public class ElementCoupling {
	private static ElementCoupling instance = null;
	private HashMap<EnumElement, HashMap<EnumElement, Integer>> couplingStat;
	private HashMap<EnumElement, HashMap<EnumElement, String>>  couplingText;
	
	public static ElementCoupling getInstance() {
		if(instance == null) {
			instance = new ElementCoupling();
		}
		return instance;
	}

	
	protected ElementCoupling() {
		couplingStat = new HashMap<EnumElement, HashMap<EnumElement, Integer>>();
		HashMap<EnumElement, Integer> fireEffect = new HashMap <EnumElement,Integer>();
		fireEffect.put(EnumElement.Fire, 0);
		fireEffect.put(EnumElement.Water, -1);
		fireEffect.put(EnumElement.Earth, 0);
		fireEffect.put(EnumElement.Wind, 1);
		
		HashMap<EnumElement, Integer> waterEffect = new HashMap <EnumElement,Integer>();
		waterEffect.put(EnumElement.Fire, 1);
		waterEffect.put(EnumElement.Water, 0);
		waterEffect.put(EnumElement.Earth, -1);
		waterEffect.put(EnumElement.Wind, 0);
		
		HashMap<EnumElement, Integer> earthEffect = new HashMap <EnumElement,Integer>();
		earthEffect.put(EnumElement.Fire, 0);
		earthEffect.put(EnumElement.Water, 1);
		earthEffect.put(EnumElement.Earth, 0);
		earthEffect.put(EnumElement.Wind, -1);
		
		HashMap<EnumElement, Integer> windEffect = new HashMap <EnumElement,Integer>();
		windEffect.put(EnumElement.Fire, -1);
		windEffect.put(EnumElement.Water, 0);
		windEffect.put(EnumElement.Earth, 1);
		windEffect.put(EnumElement.Wind, 0);
		
		couplingStat.put(EnumElement.Fire, fireEffect);
		couplingStat.put(EnumElement.Wind, windEffect);
		couplingStat.put(EnumElement.Water, waterEffect);
		couplingStat.put(EnumElement.Earth, earthEffect);
		
		couplingText = new HashMap<EnumElement, HashMap<EnumElement, String>>();
		HashMap<EnumElement, String> fireDesc = new HashMap <EnumElement,String>();
		fireDesc.put(EnumElement.Water, "doused");
		fireDesc.put(EnumElement.Wind, "kindled");
		fireDesc.put(EnumElement.Earth, "unaffected");
		fireDesc.put(EnumElement.Fire, "unaffected");

		HashMap<EnumElement, String> waterDesc = new HashMap <EnumElement,String>();
		waterDesc.put(EnumElement.Water, "unaffected");
		waterDesc.put(EnumElement.Wind, "unaffected");
		waterDesc.put(EnumElement.Earth, "muddied");
		waterDesc.put(EnumElement.Fire, "boiled");

		HashMap<EnumElement, String> earthDesc = new HashMap <EnumElement,String>();
		earthDesc.put(EnumElement.Water, "quickened");
		earthDesc.put(EnumElement.Wind, "eroded");
		earthDesc.put(EnumElement.Earth, "unaffected");
		earthDesc.put(EnumElement.Fire, "unaffected");

		HashMap<EnumElement, String> windDesc = new HashMap <EnumElement,String>();
		windDesc.put(EnumElement.Water, "unaffected");
		windDesc.put(EnumElement.Wind, "unaffected");
		windDesc.put(EnumElement.Earth, "given projectiles");
		windDesc.put(EnumElement.Fire, "miss directed");

		couplingText.put(EnumElement.Fire, fireDesc);
		couplingText.put(EnumElement.Wind, windDesc);
		couplingText.put(EnumElement.Water, waterDesc);
		couplingText.put(EnumElement.Earth, earthDesc);
	
	}
	


	public int getElementalCoupling (EnumElement actioner, EnumElement actionee) {
		return (couplingStat.get(actioner)).get(actionee);
	}


	public String getCouplingText (EnumElement actioner, EnumElement actionee) {
		return (couplingText.get(actioner)).get(actionee);
	}
}
