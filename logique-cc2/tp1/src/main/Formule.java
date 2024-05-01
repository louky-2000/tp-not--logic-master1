package main;
/**
 * Classe abstraite représentant une formule logique dans le cadre de la logique modale.
 * Cette classe sert de base pour définir des types spécifiques de formules
 * qui peuvent être évaluées au sein d'un modèle et d'un monde donnés.
 */
public abstract class Formule {

    /**
     * Détermine la valeur de vérité de cette formule dans un monde et un modèle spécifiques.
     *
     * @param m Le modèle dans lequel la formule est évaluée. 
     * @param a Le monde spécifique au sein du modèle où la formule est évaluée.
     * @return vrai si la formule est vraie dans le monde et le modèle spécifiés, faux autrement.
     */
    public abstract boolean isTrue(Model m, World a);
}
