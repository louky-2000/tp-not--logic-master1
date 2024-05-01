package operateur_binaires;


import main.Formule;
import main.Model;
import main.World;

/**
 * Classe abstraite représentant une opération binaire dans la logique modale.
 * Une opération binaire combine deux formules pour évaluer leur vérité dans un contexte donné.
 * Elle définit la structure de base pour des opérations telles que ET, OU, IMPLIQUE, etc.
 */
public abstract class BinaryOperation extends Formule {
    /** Première sous-formule de l'opération binaire */
    protected Formule q1; 
    /** Deuxième sous-formule de l'opération binaire. */
    protected Formule q2; 

    protected String operateur;

    /**
     * Constructeur pour une opération binaire.
     * 
     * @param q1 Première formule participant à l'opération.
     * @param q2 Deuxième formule participant à l'opération.
     */
    public BinaryOperation(Formule q1, Formule q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    /**
     * Retourne le symbole de l'opérateur logique utilisé par cette opération.
     * @return Le symbole Unicode pour l'opérateur .
     */
    public String getOperator() {
        return operateur;
    }

    /**
     * Méthode abstraite pour évaluer la vérité de l'opération binaire dans un modèle et un monde spécifiques.
     *
     * @param m Le modèle dans lequel l'opération doit être évaluée.
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return true si l'opération est vraie dans le monde spécifié par rapport au modèle, false autrement.
     */
    @Override
    public abstract boolean isTrue(Model m, World a);

}
