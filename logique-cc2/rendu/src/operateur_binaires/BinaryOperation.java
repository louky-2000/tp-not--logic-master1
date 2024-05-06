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
     * Retourne une représentation sous forme de chaîne de caractères de l'opération binaire.
     * Cette méthode construit une chaîne qui représente l'expression binaire, en plaçant des
     * parenthèses autour des sous-formules si elles sont également des opérations binaires,
     * pour clarifier la précédence des opérations dans l'expression.
     * 
     * @return Une chaîne de caractères formatée qui représente l'expression binaire.
     */
    @Override
    public String toString() {
        String op = this.q1.toString();
        if (this.q1 instanceof BinaryOperation) {
            op = "("+ op +")";
        }
        op += " " + this.operateur + " ";
        if (this.q2 instanceof BinaryOperation) {
            op += "("+ this.q2.toString() +")";
        }else{
            op += this.q2.toString() ;
        }
        return op;
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

    /**
     * Retourne la première sous-formule (q1) de l'opérateur binaire.
     * Cette sous-formule représente la première partie de l'expression binaire.
     * 
     * @return La première sous-formule de type Formule.
     */
    public Formule getQ1() {
        return q1;
    }

    /**
     * Retourne la deuxième sous-formule (q2) de l'opérateur binaire.
     * Cette sous-formule représente la deuxième partie de l'expression binaire.
     * 
     * @return La deuxième sous-formule de type Formule.
     */
    public Formule getQ2() {
        return q2;
    }

    /**
     * Retourne l'opérateur utilisé dans l'expression binaire sous forme de chaîne de caractères.
     * Cela peut être, par exemple, 'AND', 'OR', 'IMPLIES', etc., selon l'opérateur spécifique utilisé.
     * 
     * @return Une chaîne de caractères représentant l'opérateur.
     */
    public String getOperateur() {
        return operateur;
    }

}
