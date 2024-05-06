package rules;

import main.Formule;
import main.Tableau;
import operateur_unaires.BOX;
import operateur_unaires.DIAMOND;
import operateur_unaires.NOT;

/**
 * Classe représentant la règle PI dans un tableau de formules logiques.
 * Cette règle est utilisée pour traiter les modalités diamant (DIAMOND) et la négation des modalités boîte (BOX).
 */
public class PI extends Rule {

    /**
     * Constructeur de la classe PI.
     * Initialise la règle avec un tableau de formules et définit la règle suivante à appliquer.
     * 
     * @param tableau Tableau contenant les formules à traiter.
     */
    public PI(Tableau tableau){
        super(tableau);
        this.nextRule = new V(tableau);
    }

    /**
     * Vérifie si la règle PI peut être appliquée à une formule spécifique.
     * La règle peut être appliquée aux formules contenant l'opérateur DIAMOND ou la négation d'une formule BOX.
     * 
     * @param f Formule à vérifier.
     * @return true si la règle peut être appliquée, false sinon.
     */
    @Override
    public Boolean check(Formule f){
        if (f instanceof DIAMOND){
            return true;
        }
        if (f instanceof NOT) {
            NOT tmp = (NOT) f;
            return tmp.getQ() instanceof BOX;
        }
        return false;
    }
    
    /**
     * Applique la règle PI à une formule donnée, modifiant le tableau de formules en conséquence.
     * Décompose la formule en sous-parties plus simples pour un traitement ultérieur.
     * 
     * @param f Formule à laquelle la règle doit être appliquée.
     */
    @Override
    public void apply(Formule f) {
        if (f instanceof DIAMOND) {
            DIAMOND d = (DIAMOND) f;
            tableau.addFormule(d.getQ(), f.getLabel() + f.getLabel());
        } 
        else if (f instanceof NOT) {
            NOT not = (NOT) f;
            if (not.getQ() instanceof BOX) {
                BOX b = (BOX) not.getQ();
                NOT n = new NOT(b.getQ());
                n.setLabel(b.getLabel() + b.getLabel());
                tableau.addFormule(n, n.getLabel());
            }
        }
        if (check(f)) {
            f.setMarque(true);
        }
    }
}
