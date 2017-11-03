
package pl.examples;
import pl.core.*;

public class MoreLiarsandTruthKB extends KB {

    public MoreLiarsandTruthKB() {
        super();


        Symbol aT = intern("A(T)");
        Symbol bT = intern("B(T)");
        Symbol cT = intern("C(T)");

        Symbol dT = intern("D(T)");
        Symbol eT = intern("E(T)");
        Symbol fT = intern("F(T)");


        Symbol gT = intern("G(T)");
        Symbol hT = intern("H(T)");
        Symbol iT = intern("I(T)");


        Symbol jT = intern("J(T)");
        Symbol kT = intern("K(T)");
        Symbol lT = intern("L(T)");


        add(new Biconditional(aT, new Conjunction(hT, iT)));
        add(new Biconditional(bT, new Conjunction(aT, lT)));
        add(new Biconditional(cT, new Conjunction(bT, gT)));

        add(new Biconditional(dT, new Conjunction(eT, lT)));
        add(new Biconditional(eT, new Conjunction(cT, hT)));
        add(new Biconditional(fT, new Conjunction(dT, iT)));

        add(new Biconditional(gT, new Conjunction(eT, jT)));
        add(new Biconditional(hT, new Conjunction(fT, kT)));
        add(new Biconditional(hT, new Conjunction(gT, kT)));

        add(new Biconditional(iT, new Conjunction(aT, cT)));
        add(new Biconditional(jT, new Conjunction(dT, fT)));
        add(new Biconditional(kT, new Conjunction(bT, jT)));


    }

    public static void main(String[] argv) {
        new MoreLiarsandTruthKB().dump();
        MoreLiarsandTruthKB LT = new MoreLiarsandTruthKB();
        DPLL check = new DPLL ();
        Symbol aT = intern("A(T)");
        Symbol bT = intern("B(T)");
        Symbol cT = intern("C(T)");

        Symbol dT = intern("D(T)");
        Symbol eT = intern("E(T)");
        Symbol fT = intern("F(T)");


        Symbol gT = intern("G(T)");
        Symbol hT = intern("H(T)");
        Symbol iT = intern("I(T)");


        Symbol jT = intern("J(T)");
        Symbol kT = intern("K(T)");
        Symbol lT = intern("L(T)");
        System.out.println("Amy says with Entailment "+ Entailment.tt_entails(LT,aT));
        System.out.println("Is Amy truthful with DPLL " + check.DPLL_Satisfiable(LT,aT));

        System.out.println("Bob says with Entailment "+ Entailment.tt_entails(LT,bT));
        System.out.println("Is Bob truthful with DPLL " + check.DPLL_Satisfiable(LT,bT));

        System.out.println("Cal says with Entailment "+ Entailment.tt_entails(LT,cT));
        System.out.println("Is Cal truthful with DPLL " + check.DPLL_Satisfiable(LT,cT));

        System.out.println("Dee says with Entailment "+ Entailment.tt_entails(LT,dT));
        System.out.println("Is Dee truthful with DPLL " + check.DPLL_Satisfiable(LT,dT));

        System.out.println("Eli says with Entailment "+ Entailment.tt_entails(LT,eT));
        System.out.println("Is Eli truthful with DPLL " + check.DPLL_Satisfiable(LT,eT));

        System.out.println("Fay says with Entailment "+ Entailment.tt_entails(LT,fT));
        System.out.println("Is fay truthful with DPLL " + check.DPLL_Satisfiable(LT,fT));

        System.out.println("Gil says with Entailment "+ Entailment.tt_entails(LT,gT));
        System.out.println("Is Gil truthful with DPLL " + check.DPLL_Satisfiable(LT,gT));

        System.out.println("Hal says with Entailment "+ Entailment.tt_entails(LT,hT));
        System.out.println("Is Hal truthful with DPLL " + check.DPLL_Satisfiable(LT,hT));

        System.out.println("Ida says with Entailment "+ Entailment.tt_entails(LT,iT));
        System.out.println("Is Ida truthful with DPLL " + check.DPLL_Satisfiable(LT,iT));

        System.out.println("Jay says with Entailment "+ Entailment.tt_entails(LT,jT));
        System.out.println("Is jay truthful with DPLL " + check.DPLL_Satisfiable(LT,jT));

        System.out.println("Kay says with Entailment "+ Entailment.tt_entails(LT,kT));
        System.out.println("Is Kay truthful with DPLL " + check.DPLL_Satisfiable(LT,kT));

        System.out.println("lee says with Entailment "+ Entailment.tt_entails(LT,lT));
        System.out.println("Is lee truthful with DPLL " + check.DPLL_Satisfiable(LT,lT));



    }
}
