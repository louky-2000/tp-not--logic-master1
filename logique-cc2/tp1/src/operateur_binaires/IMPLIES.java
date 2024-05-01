package operateur_binaires;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération binaire "IMPLIQUE" dans la logique modale.
 * Cette classe évalue l'implication logique entre deux formules. L'opération "IMPLIQUE" est vraie
 * si la première formule est fausse ou si la seconde formule est vraie.
 * Elle ne retourne faux que si l'antécédent est vrai et le conséquent est faux.
 */
public class IMPLIES extends BinaryOperation {

    /**
     * Constructeur pour l'opération "IMPLIQUE".
     * 
     * @param q1 La première formule de l'implication.
     * @param q2 La deuxième formule de l'implication.
     */
    public IMPLIES(Formule q1, Formule q2) {
        super(q1, q2);
        /** Symbole Unicode pour l'opérateur logique IMPLIQUE (IMPLIES)*/
        this.operateur =  "\u21D2"; 
    }

    /**
     * Évalue si l'implication entre deux formules est vraie dans un modèle et un monde spécifiques.
     * 
     * @param m Le modèle dans lequel l'opération doit être évaluée. 
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return boolean Renvoie true si La première formule est faux ou la deuxième est vrai, false sinon
     */
    @Override
    public boolean isTrue(Model m, World a) {
        return !q1.isTrue(m, a) || q2.isTrue(m, a);
    }
}
