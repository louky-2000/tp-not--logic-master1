package operateur_unaires;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe abstraite représentant une opération unaire dans la logique modale.
 * Une opération unaire applique un opérateur logique à une seule formule pour évaluer sa vérité dans un contexte donné.
 * Elle définit la structure de base pour des opérations telles que la négation (NON).
 */
public abstract class UnaryOperation extends Formule {
    /** Formule sur laquelle l'opération est appliquée. */
    protected Formule q;

    /** Symbole Unicode représentant l'opérateur logique utilisé. */
    protected String operateur;

    /**
     * Constructeur pour une opération unaire.
     * 
     * @param q La formule sur laquelle l'opération est appliquée.
     */
    public UnaryOperation(Formule q) {
        this.q = q;
    }

    /**
     * Retourne le symbole de l'opérateur logique utilisé par cette opération.
     * @return Le symbole Unicode pour l'opérateur.
     */
    public String getOperator() {
        return operateur;
    }

    /**
     * Méthode abstraite pour évaluer la vérité de l'opération unaire dans un modèle et un monde spécifiques.
     *
     * @param m Le modèle dans lequel l'opération doit être évaluée.
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return true si l'opération est vraie dans le monde spécifié par rapport au modèle, false autrement.
     */
    @Override
    public abstract boolean isTrue(Model m, World a);
}
