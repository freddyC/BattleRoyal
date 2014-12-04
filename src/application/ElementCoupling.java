package application;

import java.util.HashMap;

public class ElementCoupling {
	private static ElementCoupling instance = null;
	private HashMap<Element, HashMap<Element, Integer>> couplingStat;
	private HashMap<Element, HashMap<Element, String>>  couplingText;
	
	public static ElementCoupling getInstance() {
		if(instance == null) {
			instance = new ElementCoupling();
		}
		return instance;
	}

	
	protected ElementCoupling() {
		couplingStat = new HashMap<Element, HashMap<Element, Integer>>();
		HashMap<Element, Integer> fireEffect = new HashMap <Element,Integer>();
		fireEffect.put(Element.Fire, 0);
		fireEffect.put(Element.Water, -1);
		fireEffect.put(Element.Earth, 0);
		fireEffect.put(Element.Wind, 1);
		
		HashMap<Element, Integer> waterEffect = new HashMap <Element,Integer>();
		waterEffect.put(Element.Fire, 1);
		waterEffect.put(Element.Water, 0);
		waterEffect.put(Element.Earth, -1);
		waterEffect.put(Element.Wind, 0);
		
		HashMap<Element, Integer> earthEffect = new HashMap <Element,Integer>();
		earthEffect.put(Element.Fire, 0);
		earthEffect.put(Element.Water, 1);
		earthEffect.put(Element.Earth, 0);
		earthEffect.put(Element.Wind, -1);
		
		HashMap<Element, Integer> windEffect = new HashMap <Element,Integer>();
		windEffect.put(Element.Fire, -1);
		windEffect.put(Element.Water, 0);
		windEffect.put(Element.Earth, 1);
		windEffect.put(Element.Wind, 0);
		
		couplingStat.put(Element.Fire, fireEffect);
		couplingStat.put(Element.Wind, windEffect);
		couplingStat.put(Element.Water, waterEffect);
		couplingStat.put(Element.Earth, earthEffect);
		
		couplingText = new HashMap<Element, HashMap<Element, String>>();
		HashMap<Element, String> fireDesc = new HashMap <Element,String>();
		fireDesc.put(Element.Water, "doused");
		fireDesc.put(Element.Wind, "kindled");
		fireDesc.put(Element.Earth, "unaffected");
		fireDesc.put(Element.Fire, "unaffected");

		HashMap<Element, String> waterDesc = new HashMap <Element,String>();
		waterDesc.put(Element.Water, "unaffected");
		waterDesc.put(Element.Wind, "unaffected");
		waterDesc.put(Element.Earth, "muddied");
		waterDesc.put(Element.Fire, "boiled");

		HashMap<Element, String> earthDesc = new HashMap <Element,String>();
		earthDesc.put(Element.Water, "quickened");
		earthDesc.put(Element.Wind, "eroded");
		earthDesc.put(Element.Earth, "unaffected");
		earthDesc.put(Element.Fire, "unaffected");

		HashMap<Element, String> windDesc = new HashMap <Element,String>();
		windDesc.put(Element.Water, "unaffected");
		windDesc.put(Element.Wind, "unaffected");
		windDesc.put(Element.Earth, "given projectiles");
		windDesc.put(Element.Fire, "miss directed");

		couplingText.put(Element.Fire, fireDesc);
		couplingText.put(Element.Wind, windDesc);
		couplingText.put(Element.Water, waterDesc);
		couplingText.put(Element.Earth, earthDesc);
	
	}
	


	public int getElementalCoupling (Element actioner, Element actionee) {
		return (couplingStat.get(actioner)).get(actionee);
	}


	public String getCouplingText (Element actioner, Element actionee) {
		return (couplingText.get(actioner)).get(actionee);
	}
}
