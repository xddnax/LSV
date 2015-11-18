package main.java.lsv.core;

import main.java.lsv.model.Model;
import main.java.lsv.grammar.Formula;

/**
 * Defines the interface to model checker. 
 *
 * */
public interface ModelChecker {
    // Returns true is the model satisfies the query under the constraint
    public boolean check(Model model, Formula constraint, Formula query);

    // Returns a trace of the previous check attempt if it failed.
    public String[] getTrace();
}



