package pl.core;

import java.util.*;

/**
 * Created by naven on 3/3/2017.
 */
public class Entailment {

    public static boolean tt_entails(KB kbase, Sentence alpha){
        ArrayList<Symbol> symblist= new ArrayList<>(kbase.symbols());

        return tt_check_all(kbase,alpha,symblist,new Modelclass(),0);


    }

    public static boolean tt_check_all(KB kbase, Sentence alpha, ArrayList<Symbol> symblist, Modelclass model1, int index){
           // System.out.println("List "+ symblist);
        if (model1.modelmap.size()==symblist.size()){
            if ( model1.satisfies(kbase)){
                return model1.satisfies(alpha);
            }else {
                return true;
            }
        }else {
            // should remove the first symbol in the list and be the variable p
            Modelclass model= (Modelclass)model1.clone() ;

            Symbol p = symblist.get(index);
            model.add(p,Boolean.TRUE);


            boolean pTrue= tt_check_all(kbase, alpha, symblist,(Modelclass)model,index+1);
            model.remove(p,Boolean.TRUE);
            model.add(p,Boolean.FALSE);


            boolean pFalse= tt_check_all(kbase,alpha, symblist, (Modelclass)model,index+1);
            model.remove(p,Boolean.FALSE);

            return pTrue && pFalse;

        }

    }


}
