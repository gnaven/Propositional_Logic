package pl.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by naven on 3/3/2017.
 */
public class Modelclass implements Model {
    static HashMap<Symbol, Boolean> modelmap;

    public Modelclass (){
        modelmap = new HashMap<Symbol, Boolean>();
    }
    public Modelclass(HashMap<Symbol,Boolean> hash){
        this.modelmap=hash;
    }

    public  void printModel(){
        Set Keys = modelmap.keySet();
        Iterator it = Keys.iterator();
        while (it.hasNext()) {
            Symbol k = (Symbol) it.next();
            System.out.println(k + " = " + modelmap.get(k));
            //it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println();

    }
    @Override
    public void set(Symbol sym, boolean value) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean get(Symbol sym) {
        // TODO Auto-generated method stub
        return modelmap.get(sym);
    }

    @Override
    public boolean satisfies(KB kb) {

        for (Sentence sent: kb.sentences()){
            if (!satisfies(sent)){
               // printModel();

                return false;
            }
        }
//        System.out.println("When Satisfied start");
//    printModel();
//        System.out.println("When Satisfied start");

        return true;

    }


    //New class add *** //

    public  void add(Symbol sym, boolean bol){
        modelmap.put(sym,bol);
    }
    public void remove (Symbol sym, boolean bol){

        modelmap.remove(sym);
    }
    public void remove (Symbol sym){

        modelmap.remove(sym);
    }

    public Model clone (){

        HashMap<Symbol,Boolean> cloneHash = new HashMap<>();

        Iterator it = modelmap.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            cloneHash.put((Symbol)pair.getKey(),(Boolean)pair.getValue());
          //  it.remove(); // avoids a ConcurrentModificationException
        }
        return new Modelclass(cloneHash);
    }

    @Override
    public boolean contains(Symbol sym) {
        return modelmap.containsKey(sym);

    }


    @Override
    public boolean satisfies(Sentence sentence) {
        //System.out.println(sentence.isSatisfiedBy(this));
        //printModel();
        return sentence.isSatisfiedBy(this);
    }

    @Override
    public void dump() {
        // TODO Auto-generated method stub

    }

}


