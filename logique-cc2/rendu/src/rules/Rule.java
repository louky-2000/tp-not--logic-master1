package rules;

import main.Formule;
import main.Tableau;

/**
 * Classe abstraite représentant une règle générale dans un tableau de formules logiques.
 * Sert de base pour définir des règles spécifiques qui manipulent des formules selon certaines conditions.
 */
public abstract class Rule {
    /** Référence au tableau contenant les formules. */
    protected Tableau tableau; 
    /** Prochaine règle à appliquer après celle-ci. */
    protected Rule nextRule;   

    /**
     * Constructeur de la classe Rule.
     * Initialise la règle avec un tableau de formules.
     * 
     * @param tableau Tableau contenant les formules à traiter.
     */
    public Rule(Tableau tableau) {
        this.tableau = tableau;
    }

    /**
     * Récupère le tableau associé à cette règle.
     * 
     * @return Le tableau de formules.
     */
    public Tableau getTableau() {
        return tableau;
    }

    /**
     * Définit le tableau associé à cette règle.
     * 
     * @param tableau Tableau de formules à associer.
     */
    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }
    
    /**
     * Récupère la règle suivante à appliquer après celle-ci.
     * 
     * @return La règle suivante.
     */
    public Rule getNextRule() {
        return nextRule;
    }

    /**
     * Définit la règle suivante à appliquer.
     * 
     * @param nextRule La prochaine règle à associer.
     */
    public void setNextRule(Rule nextRule) {
        this.nextRule = nextRule;
    }

    /**
     * Détermine si une règle peut être appliquée à une formule dans le tableau.
     * Retourne la première formule non marquée à laquelle la règle peut être appliquée.
     * 
     * @return La formule à laquelle la règle peut être appliquée, ou null si aucune formule n'est applicable.
     */
    public Formule canBeApplied() {
        for (Formule f : tableau.getFormulaSet()) {
            if (!f.isMarque() && this.check(f)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Méthode abstraite pour vérifier si une règle peut être appliquée à une formule spécifique.
     * 
     * @param f Formule à vérifier.
     * @return true si la règle peut être appliquée, false sinon.
     */
    public abstract Boolean check(Formule f);

    /**
     * Méthode abstraite pour appliquer la règle à une formule donnée.
     * 
     * @param f Formule à laquelle la règle doit être appliquée.
     */
    public abstract void apply(Formule f);
}
