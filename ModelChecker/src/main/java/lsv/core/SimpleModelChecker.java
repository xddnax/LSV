package main.java.lsv.core;

import main.java.lsv.model.Model;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.lsv.grammar.Formula;

class FormulaTreeNode {
	Formula currFormula;
	ArrayList<Formula> children = new ArrayList<Formula>();
	Formula parent;

	FormulaTreeNode(Formula curr, Formula par, ArrayList<Formula> children) {
		this.currFormula = curr;
		this.parent = par;
		this.children = children;

	}

}

class FormulaTree {
	FormulaTreeNode initNode;
	ArrayList<FormulaTreeNode> children = new ArrayList<FormulaTreeNode>();

	FormulaTree(FormulaTreeNode head) {
		this.initNode = head;
	}

	void addFormulaTreeNode(FormulaTreeNode node) {
		children.add(node);
	}

}

public class SimpleModelChecker implements ModelChecker {
	ArrayList<Formula> allFormulas = new ArrayList<Formula>();
	int depth = 0;
	Formula parentNode;
	Formula currNode;
	FormulaTree tree;

	public boolean check(Model model, Formula constraint, Formula formula) {
		// TO IMPLEMENT

		makeAllFormulasNew(formula);

		return false;
	}
	// make a tree of formulas with main one as a head
	private void makeAllFormulasNew(Formula f) {
		if (currNode == null) {
			ArrayList<Formula> temp = new ArrayList<Formula>();
			temp.addAll(Arrays.asList(f.getNestedCTL()));
			FormulaTreeNode newHead = new FormulaTreeNode(f, null, temp);
			tree = new FormulaTree(newHead);
			currNode = f;
			parentNode = f;
		}

		if (f.getNestedCTL().length != 0) {
			for (int i = 0; i < f.getNestedCTL().length; i++) {
				currNode = f.getNestedCTL()[i];
				parentNode = f;
				FormulaTreeNode temp = new FormulaTreeNode(currNode, parentNode,
						(ArrayList<Formula>) Arrays.asList(currNode.getNestedCTL()));
				tree.addFormulaTreeNode(temp);
				makeAllFormulasNew(currNode);
			}
		} else {
			currNode = f;
			FormulaTreeNode temp = new FormulaTreeNode(currNode, parentNode, new ArrayList<Formula>());
			tree.addFormulaTreeNode(temp);
		}

	}

	// private void makeAllFormulas(Formula f) {
	// ArrayList<Formula> childFormulas=new ArrayList<Formula>();
	// FormulaTreeNode currTreeNode=null;
	// if (currNode != null) {
	// parentNode = currNode;
	// }
	// if (f.getNestedCTL().length != 0) {
	//
	// for (int i = 0; i < f.getNestedCTL().length; i++) {
	// currNode = f.getNestedCTL()[i];
	// if(currNode.getNestedCTL().length!=0){
	// for(int j=0;j<currNode.getNestedCTL().length;j++){
	// childFormulas.add(currNode.getNestedCTL()[j]);
	// }
	// currTreeNode =new FormulaTreeNode(currNode, parentNode, childFormulas);
	// childFormulas.clear();
	// }
	//
	// if(currNode.equals(parentNode)){
	// tree=new FormulaTree(currTreeNode);
	// }
	// tree.addFormulaTreeNode(currTreeNode);
	// makeAllFormulas(f.getNestedCTL()[i]);
	//
	// }
	// }
	//
	//
	// else {
	// currTreeNode = new FormulaTreeNode(f, parentNode, new
	// ArrayList<Formula>());
	// tree.addFormulaTreeNode(currTreeNode);
	// return;
	//
	// }
	//
	// }

	public String[] getTrace() {
		// TO IMPLEMENT
		return null;
	}
}

// procedure label-graph(f)
// begin
// . . .
// (main operator is AU)
// begin
// ST := empty-stack;
// for all s E S do marked(s) := false;
// L: forallsESdo
// if lmarked(s) then au( f, s, b)
// end
// . . .
// end

// procedure au( f, s, b)
// begin
// if marked(s) then
// begin
// if labeled@, f) then
// begin b := true; return end;
// b := false; return
// end;
// (Mark state s as visited. Let f = A[f, Uf2]. If f 2 is t rue at s, f is true
// at s; so label s with f
// and return true. If f, is not true at s, then f is not true at s; so return
// false.)
// marked(s) := true;
// if labeled(s, arg2( f)) then
// begin adhlabel(s, f); b := true; return end
// else if llabeled(s, argl(f)) then
// begin b := false; return end;
// push(s, ST);
// for all sl E successors(s) do
// begin
// df, sl, bl);
// if 311 then
// begin pop(ST); b := false; return end
// end;
// pop(ST); add-label(s, f); b := true; return
// end of procedure au.