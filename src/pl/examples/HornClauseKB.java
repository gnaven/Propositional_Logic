package pl.examples;

/**
 * Created by naven on 3/7/2017.
 */

import pl.core.*;
public class HornClauseKB extends KB {

    public HornClauseKB() {
        super();
        //Unicorn Mythical represented by P
        Symbol p = intern ("P");
        //Unicorn Immortal represented by Q
        Symbol q = intern ("Q");
        //Unicorn mortal is represented by R
        Symbol r = intern ("R");
       // Sentence r= new Negation(q);
        //Unicorn has horn is represented by S
        Symbol s = intern ("S");
        //Unicorn is magical is represented by T
        Symbol t = intern ("T");
        //Unicorn is mammal
        Symbol m = intern ("M");



        add(new Conjunction(new Implication(p, q),new Implication(new Negation(p), new Conjunction(r, m))));
        add(new Implication(new Disjunction(q,m), s ));
        add(new Implication(s, t));
       // add(new Negation(r));
       // add(new Negation(m));
    }
    public static void main (String[] argv) {
        new HornClauseKB().dump();


        new HornClauseKB().dump();

        HornClauseKB world = new HornClauseKB();
        Symbol p = intern ("P");
        Symbol q = intern ("Q");
        Symbol r = intern ("R");
        Symbol m= intern("M");

        Symbol t = intern ("T");
        Symbol s = intern ("S");

//			System.out.println(Entailment.tt_entails(world,p12 ));
        //world.printSym(world);

        DPLL check = new DPLL ();

        System.out.println("(a) for Unicorn Mythical with Entailment "+ Entailment.tt_entails(world,p));
        System.out.println("(b) for Unicorn Magical with Entailment "+ Entailment.tt_entails(world,t));
        System.out.println("(c) for Unicorn horned with Entailment "+ Entailment.tt_entails(world,s));
        System.out.println();
       System.out.println("(a) for Unicorn Mythical with DPLL "+check.DPLL_Satisfiable(world,p));
        System.out.println("(b) for Unicorn Magical with DPLL "+ check.DPLL_Satisfiable(world,t));
        System.out.println( "(c) for Unicorn horned with DPLL "+check.DPLL_Satisfiable(world,s));





    }


}
