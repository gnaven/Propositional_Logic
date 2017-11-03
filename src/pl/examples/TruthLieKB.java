package pl.examples;

/**
 * Created by naven on 3/7/2017.
 */
import pl.core.*;

public class TruthLieKB extends KB {

    public TruthLieKB() {
        super();

        Symbol cT = intern ("C(T)");
        Symbol aT = intern ("A(T)");
        Symbol bT = intern ("B(T)");


       //add(new Disjunction(aT,new Disjunction(bT,cT)));
       //a//

        add (new Implication ( aT,(new Conjunction(cT,aT))));

        add(new Implication ( bT,new Negation(cT)));

        add (new Implication ( cT,new Disjunction(bT, new Negation(aT))));

       //b// to test this part please uncomment part b(below) and comment part b
/**
        add(new Biconditional (aT, new Negation(cT)));
        add(new Biconditional (bT, new Conjunction(aT,cT)));
        add(new Biconditional (cT,bT));
**/
    }
    public static void main(String[] argv) {
        new TruthLieKB().dump();
        TruthLieKB TL = new TruthLieKB();
        DPLL check = new DPLL ();

        Symbol aT = intern("A(T)");
        Symbol cT = intern("C(T)");
        Symbol bT = intern("B(T)");

        //for checking part (a) //
        System.out.println("Part (a)");
        System.out.println("Is Amy truthful with Entailment  "+ Entailment.tt_entails(TL,aT ));
        System.out.println("Is Amy truthful with DPLL " + check.DPLL_Satisfiable(TL,aT));

        System.out.println("Is Bob truthful with Entailment  "+ Entailment.tt_entails(TL,bT ));
        System.out.println("Is Bob truthful with DPLL " + check.DPLL_Satisfiable(TL,bT));

        System.out.println("Is Cal truthful with Entailment  "+ Entailment.tt_entails(TL,cT ));
        System.out.println("Is Cal truthful with DPLL " + check.DPLL_Satisfiable(TL,cT));

/** //Please Uncomment out part B below and comment Part a to test it
        System.out.println("Part (b)");


        System.out.println("Is Amy truthful with Entailment  "+ Entailment.tt_entails(TL,aT ));
        System.out.println("Is Amy truthful with DPLL " + check.DPLL_Satisfiable(TL,aT));

        System.out.println("Is Bob truthful with Entailment  "+ Entailment.tt_entails(TL,bT ));
        System.out.println("Is Bob truthful with DPLL " + check.DPLL_Satisfiable(TL,bT));

        System.out.println("Is Cal truthful with Entailment  "+ Entailment.tt_entails(TL,cT ));
        System.out.println("Is Cal truthful with DPLL " + check.DPLL_Satisfiable(TL,cT));

**/

    }
}
