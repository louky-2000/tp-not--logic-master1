package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import rules.ALPHA;
import rules.Rule;

/**
 * La classe Tableau représente un tableau pour le traitement de formules logiques.
 * Elle gère un ensemble de formules et leurs étiquettes associées, permettant l'application de règles pour manipuler ces formules.
 */
public class Tableau {

    /** Ensemble des formules gérées par le tableau. */
    protected ArrayList<Formule> formulaSet; 
    /** Ensemble des étiquettes utilisées dans les formules. */
    protected Set<String> labelSet;          

    /**
     * Constructeur de la classe Tableau.
     * Initialise le tableau avec un ensemble de formules et extrait leurs étiquettes pour les stocker séparément.
     * 
     * @param formulaSet Liste initiale de formules à gérer dans le tableau.
     */
    public Tableau(ArrayList<Formule> formulaSet) {
        this.formulaSet = formulaSet;
        this.labelSet = new HashSet<>();
        formulaSet.forEach((f) -> {
            this.labelSet.add(f.getLabel());
        });
    }

    /**
     * Calcule et développe l'arbre de dérivation en appliquant les règles logiques jusqu'à ce qu'aucune autre règle ne puisse être appliquée.
     */
    public void computeTree(){
        Rule alpha = new ALPHA(this);
        Rule currentRule = alpha;
        Formule f = null;
        boolean end = false;
        while (!end) {
            while (currentRule != null) {
                f = currentRule.canBeApplied();
                if (f != null) {
                    currentRule.apply(f);
                    break;
                }
                currentRule = currentRule.getNextRule();
            }
            currentRule = alpha;
            end = checkEND();
        }
    }

    /**
     * Vérifie si toutes les formules ont été marquées comme traitées.
     * 
     * @return true si toutes les formules sont marquées, false sinon.
     */
    public boolean checkEND(){
        for (Formule f : formulaSet) {
            if (!f.isMarque()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vérifie la validité du tableau, implémentation non spécifiée.
     * 
     * @return false par défaut.
     */
    public boolean checkValidity(){
        return false;
    }

    /**
     * Vérifie la satisfaisabilité du tableau, implémentation non spécifiée.
     * 
     * @return false par défaut.
     */
    public boolean checkSatisfiability(){
        return false;
    }

    /**
     * Ajoute une formule au tableau avec une étiquette spécifique.
     * 
     * @param f La formule à ajouter.
     * @param label L'étiquette associée à la formule.
     */
    public void addFormule(Formule f, String label) {
        this.formulaSet.add(f);
        this.labelSet.add(label);
    }

    /**
     * Récupère l'ensemble des formules gérées par le tableau.
     * 
     * @return Liste des formules.
     */
    public ArrayList<Formule> getFormulaSet() {
        return formulaSet;
    }

    /**
     * Récupère l'ensemble des étiquettes utilisées dans le tableau.
     * 
     * @return Ensemble des étiquettes.
     */
    public Set<String> getLabelSet() {
        return labelSet;
    }

    /**
     * Définit l'ensemble des formules gérées par le tableau.
     * 
     * @param formulaSet Liste des formules à définir.
     */
    public void setFormulaSet(ArrayList<Formule> formulaSet) {
        this.formulaSet = formulaSet;
    }
}
