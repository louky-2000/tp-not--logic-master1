package operateur_binaires;

import main.*;


/**
 * Classe représentant l'opération binaire "ET" dans la logique modale.
 * Cette classe évalue la conjonction logique de deux formules. L'opération "ET" est vraie si
 * et seulement si les deux formules sont vraies dans le modèle et le monde spécifiés.
 */
public class AND extends BinaryOperation {
    /**
     * Constructeur pour l'opération "ET".
     * 
     * @param q1 Première formule de la conjonction.
     * @param q2 Deuxième formule de la conjonction.
     */
    public AND(Formule q1, Formule q2) {
        super(q1, q2);
        /** Symbole Unicode pour l'opérateur logique ET (AND) */
        this.operateur = "\u2227";
    }

    /**
     * Évalue si la conjonction des deux formules est vraie dans un modèle et un monde spécifiques.
     *
     * @param m Le modèle dans lequel l'opération doit être évaluée. 
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return boolean Renvoie true si les deux formules sont vraies dans le monde spécifié, false autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        return q1.isTrue(m, a) && q2.isTrue(m, a);
    }

}
