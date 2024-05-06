package rules;

import main.Formule;
import main.Tableau;
import operateur_binaires.AND;
import operateur_binaires.IMPLIES;
import operateur_binaires.OR;
import operateur_unaires.NOT;

/**
 * Classe représentant la règle BETA dans un tableau de formules logiques.
 * Cette règle est utilisée pour traiter les opérateurs OR, IMPLIES et les négations d'opérateurs AND.
 */
public class BETA extends Rule {

    /**
     * Constructeur de la classe BETA.
     * Initialise la règle avec un tableau de formules et définit la règle suivante à appliquer.
     * 
     * @param tableau Tableau contenant les formules à traiter.
     */
    public BETA(Tableau tableau){
        super(tableau);
        this.nextRule = new PI(tableau);
    }

   /**
    * Vérifie si la règle BETA peut être appliquée à une formule spécifique.
    * La règle peut être appliquée aux formules contenant les opérateurs OR, IMPLIES, 
    * ou une négation d'une formule AND.
    * 
    * @param f Formule à vérifier.
    * @return true si la règle peut être appliquée, false sinon.
    */
   @Override
    public Boolean check(Formule f){
        if ((f instanceof OR) || (f instanceof IMPLIES)) {
            return true;
        }
        if (f instanceof NOT) {
            NOT tmp = (NOT) f;
            return (tmp.getQ() instanceof AND);
        }
        return false;
    }
    
    /**
     * Applique la règle BETA à une formule donnée, décomposant la formule en sous-parties
     * et les ajoutant au tableau pour un traitement ultérieur.
     * 
     * @param f Formule à laquelle la règle doit être appliquée.
     */
    @Override
    public void apply(Formule f) {
        if (f instanceof OR) {
            OR or = (OR) f;
            tableau.addFormule(or.getQ1(), f.getLabel());
            tableau.addFormule(or.getQ2(), f.getLabel());
        } 
        else if (f instanceof IMPLIES) {
            IMPLIES implies = (IMPLIES) f;
            NOT n = new NOT(implies.getQ1());
            n.setLabel(implies.getLabel());
            tableau.addFormule(n, implies.getLabel());
            tableau.addFormule(implies.getQ2(), implies.getLabel());
        }
        else if (f instanceof NOT) {
            NOT not = (NOT) f;
            if (not.getQ() instanceof AND) {
                AND and = (AND) not.getQ();
                tableau.addFormule(and.getQ1(), and.getLabel());
                tableau.addFormule(and.getQ2(), and.getLabel());
            }
        }
        if (check(f)) {
            f.setMarque(true);
        }
    }
}
