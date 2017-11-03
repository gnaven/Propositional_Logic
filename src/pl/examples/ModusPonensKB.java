package pl.examples;

import pl.core.*;

public class ModusPonensKB extends KB {
	
	public ModusPonensKB() {
		super();
		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));
	}



	public static void main(String[] argv) {
		new ModusPonensKB().dump();
		ModusPonensKB newKB = new ModusPonensKB();
		Symbol q = intern("Q");
		System.out.println();
		System.out.println("Checking entailment "+ Entailment.tt_entails(newKB, q));

		DPLL check = new DPLL ();
		System.out.println();
		System.out.println("Checking if the query is satisfiied "+check.DPLL_Satisfiable(newKB,q));

	}

}
