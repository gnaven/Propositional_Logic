package pl.core;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by naven on 3/5/2017.
 */
public class DPLL {

    public DPLL (){

    }
    int ch1=0;

    public boolean checktrue (Set<Clause> clauses, Model model){
        for ( Clause c : clauses ){
            if(!c.isSatisfiedBy(model)) {
                return false;
            }
        }

        return true;
    }

    //Makes symbols from a set of clause
    public List<Symbol> makeSymbollist (Set<Clause>c){
        ArrayList<Symbol> symlist = new ArrayList<>();

        for (Clause clause : c ){
            for (Literal x : clause){
                if (!symlist.contains(x.getContent())) {
                    symlist.add(x.getContent());
                }

            }
        }
         return symlist;

    }


    public HashMap<Symbol,Boolean> check_Pure_Sym (List<Symbol> symbols, Set<Clause> clauses, Model model){
        List<Literal> Megaliteral= new ArrayList<Literal>();
        //adds all the literals  to the megaliteral list from each clauses
        int index =1;

        for (Clause cls: clauses){

            Megaliteral.addAll(cls);
        //    System.out.println("This is megaliteral "+ clauses.size());
            index++;
//             if (index>=clauses.size()){
//                break;
//             }
        }
        Literal.Polarity sign=null;
        int x=3;
        HashMap<Symbol,Boolean> store= new HashMap<Symbol,Boolean>();

        for (Literal lt: Megaliteral){
            if (lt.getContent().equals(symbols.get(0))){

                if (sign != lt.getPolarity()&&x>3){
                    //store.put(null,null);
                    return store;
                }
                x++;
                sign = lt.getPolarity();

            }

        }
        store.put(symbols.get(0),sign== Literal.Polarity.POSITIVE);

        return store;
    }


    public HashMap<Symbol,Boolean> Unit_Clause( Set<Clause> clauses, Model model){
        HashMap<Symbol,Boolean> SymValue= new HashMap<>();


        for (Clause cl : clauses){
            Symbol s=  cl.get(0).getContent();




            if (cl.size()==1){
                if (model.contains(cl.get(0).getContent())){
                    break;
                }
                if (cl.get(0).getPolarity()== Literal.Polarity.POSITIVE) {
                    SymValue.put(cl.get(0).getContent(),true );
                    return SymValue;

                } else{
                    SymValue.put(s,false );

                    break;
                    //return SymValue;
                }

            }else{

                Literal store= null;
                int index =0;
                for (Literal l: cl){

                    if (model.contains(l.getContent())){
                        if (l.getValue(model.get(l.getContent()))){
                            continue;
                        }


                    }else {
                        store= l;
                        index++;
                        if (index>1){
                            store=null;
                            continue;
                        }

                    }

                }
                if (store!=null) {
                    SymValue.put(store.getContent(), store.getPolarity()== Literal.Polarity.POSITIVE);
                    return SymValue;
                }
            }


//            if (ind>= 1){
//                System.out.println("This "+s );
//
//                break;
//            }
        }
        return SymValue;
    }
    public List<Symbol> Clone(List<Symbol>symb){
        List<Symbol> newList= new ArrayList<Symbol>() ;
        for (Symbol sy: symb){
            newList.add(sy);
        }
        return newList;
    }
    /** Tests the satisfiability with the negation of the query, and so if it is unsatisfiable it should return false
     however it would print true as the return statement is negation of what it returns from the DPLL_Test
     method as to finally show that the query is actually satisfiable with the KB
     **/
    public boolean DPLL_Satisfiable(KB kb, Sentence query){
        Set<Clause> cls = CNFConverter.convert(kb);
        List<Symbol> symlist= makeSymbollist(cls);
        cls.addAll(CNFConverter.convert(new Negation(query)));
        return !DPLL_Test(cls,symlist,new Modelclass());
    }

    public boolean DPLL_Test(Set<Clause>cls, List<Symbol>symoriginal, Model model ){
       // Model model= modeloriginal.clone();
        List<Symbol> sym= Clone(symoriginal);
        if (sym.size()==0){
            return checktrue(cls,model);
        }
        HashMap<Symbol,Boolean> pure= check_Pure_Sym(sym,cls,model);
        if (!pure.isEmpty()){

            Set<Symbol> symbols;
            symbols= pure.keySet();
            Iterator x = symbols.iterator();
            Symbol storesym;
            storesym = (Symbol) x.next();
            sym.remove(storesym);
            model.add(storesym,pure.get(storesym));
            boolean l= (DPLL_Test(cls,sym,model));
            model.remove(storesym);
            return l;

        }
        HashMap<Symbol,Boolean> unit = Unit_Clause(cls,model);
        if (!unit.isEmpty()){


            Set<Symbol> symbols;

            symbols= unit.keySet();
            Iterator x = symbols.iterator();
            Symbol storesym;
            storesym = (Symbol) x.next();
            sym.remove(storesym);

            model.add(storesym,unit.get(storesym));

           // model.printModel();
            unit.clear();
            boolean z = (DPLL_Test(cls,sym,model));
            model.remove(storesym);
            return z;
            //sym.add(storesym);
            //model.remove(storesym,unit.get(storesym));
       }


        Symbol P = sym.get(0);
        sym.remove(0);
        model.add(P,true);
        boolean PTrue= DPLL_Test(cls,sym,model);
        model.remove(P,true);

        model.add(P,false);
        boolean PFalse= DPLL_Test(cls,sym,model);

        return PTrue||PFalse;

    }
}
