package rules;

import main.Formule;
import main.Tableau;
import operateur_unaires.BOX;
import operateur_unaires.DIAMOND;
import operateur_unaires.NOT;

/**
 * Classe représentant la règle V dans un tableau de formules logiques.
 * Cette règle est utilisée pour traiter les modalités boîte (BOX) et la négation des modalités diamant (DIAMOND).
 */
public class V extends Rule{

    /**
     * Constructeur de la classe V.
     * Initialise la règle avec un tableau de formules, sans spécifier de règle suivante.
     * 
     * @param tableau Tableau contenant les formules à traiter.
     */
    public V(Tableau tableau){
        super(tableau);
        this.nextRule = null;
    }

    /**
     * Vérifie si la règle V peut être appliquée à une formule spécifique.
     * La règle peut être appliquée aux formules contenant l'opérateur BOX ou la négation d'une formule DIAMOND.
     * 
     * @param f Formule à vérifier.
     * @return true si la règle peut être appliquée, false sinon.
     */
    @Override
    public Boolean check(Formule f){
        if (f instanceof BOX){
            return true;
        }
        if (f instanceof NOT) {
            NOT tmp = (NOT) f;
            return tmp.getQ() instanceof DIAMOND;
        }
        return false;
    }
    
    /**
     * Applique la règle V à une formule donnée, modifiant le tableau de formules en conséquence.
     * Décompose la formule en sous-parties plus simples pour un traitement ultérieur.
     * 
     * @param f Formule à laquelle la règle doit être appliquée.
     */
    @Override
    public void apply(Formule f) {
        if (f instanceof BOX) {
            BOX b = (BOX) f;
            tableau.addFormule(b.getQ(), f.getLabel() + f.getLabel());
        } 
        else if (f instanceof NOT) {
            NOT not = (NOT) f;
            if (not.getQ() instanceof DIAMOND) {
                DIAMOND d = (DIAMOND) not.getQ();
                NOT n = new NOT(d.getQ());
                n.setLabel(d.getLabel() + d.getLabel());
                tableau.addFormule(n, n.getLabel());
            }
        }
        // Marque la formule pour indiquer qu'elle a été traitée.
        f.setMarque(true);
    }
}
