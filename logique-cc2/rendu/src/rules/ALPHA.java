package rules;

import main.Formule;
import main.Tableau;
import operateur_binaires.AND;
import operateur_binaires.IMPLIES;
import operateur_binaires.OR;
import operateur_unaires.NOT;

/**
 * Classe représentant la règle ALPHA dans un tableau de formules logiques.
 * Cette règle est utilisée pour décomposer des formules complexes en formules plus simples.
 */
public class ALPHA extends Rule{

    /**
     * Constructeur de la classe ALPHA.
     * Initialise la règle et définit la règle suivante à appliquer.
     * 
     * @param tableau Tableau contenant les formules à traiter.
     */
    public ALPHA(Tableau tableau){
        super(tableau);
        this.nextRule = new BETA(tableau);
    }

    /**
     * Méthode pour vérifier si la règle ALPHA peut être appliquée à une formule donnée.
     * 
     * @param f Formule à vérifier.
     * @return true si la règle peut être appliquée, false sinon.
     */
    @Override
    public Boolean check(Formule f){
        if (f instanceof AND) {
            return true;
        }
        if (f instanceof NOT) {
            NOT tmp = (NOT) f;
            return (tmp.getQ() instanceof OR) || (tmp.getQ() instanceof IMPLIES) || 
                   (tmp.getQ() instanceof NOT);
        }
        return false;
    }
    
    /**
     * Applique la règle ALPHA à une formule donnée.
     * Décompose les formules complexes en sous-parties plus simples et les ajoute au tableau.
     * 
     * @param f Formule à laquelle la règle doit être appliquée.
     */
    @Override
    public void apply(Formule f) {

        if (f instanceof AND) {
            AND and = (AND) f;
            tableau.addFormule(and.getQ1(), f.getLabel());
            tableau.addFormule(and.getQ2(), f.getLabel());
        } 
        else if (f instanceof NOT) {
            NOT not = (NOT) f;
            if (not.getQ() instanceof OR) {
                OR or = (OR) not.getQ();
                tableau.addFormule(or.getQ1(), or.getLabel());
                tableau.addFormule(or.getQ2(), or.getLabel());
            } else if (not.getQ() instanceof IMPLIES) {
                IMPLIES implies = (IMPLIES) not.getQ();
                NOT n = new NOT(implies.getQ2());
                n.setLabel(implies.getLabel());
                tableau.addFormule(implies.getQ1(), implies.getLabel());
                tableau.addFormule(n, implies.getLabel());
            } else if (not.getQ() instanceof NOT) {
                NOT innerNOT = (NOT) not.getQ();
                tableau.addFormule(innerNOT.getQ(), innerNOT.getLabel());
            }
        }
        if (check(f)) {
            f.setMarque(true);
        }
    }
}
