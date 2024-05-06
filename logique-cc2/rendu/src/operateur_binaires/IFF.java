package operateur_binaires;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération binaire "IFF" (si et seulement si) dans la logique modale.
 * Cette classe évalue l'équivalence logique entre deux formules. L'opération "IFF" est vraie
 * si les deux formules ont la même valeur de vérité dans le modèle et le monde spécifiés,
 * soit les deux vraies ou les deux fausses.
 */
public class IFF extends BinaryOperation {

    /**
     * Constructeur pour l'opération "IFF".
     * 
     * @param q1 Première formule de l'équivalence.
     * @param q2 Deuxième formule de l'équivalence.
     */
    public IFF(Formule q1, Formule q2) {
        super(q1, q2);
        /** Symbole Unicode pour l'opérateur logique SI ET SEULEMENT SI (IFF) */
        this.operateur = "\u21D4";
    }

    /**
     * Évalue si l'équivalence des deux formules est vraie dans un modèle et un monde spécifiques.
     * 
     * @param m Le modèle dans lequel l'opération doit être évaluée. 
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return boolean Renvoie true si les deux formules ont la même valeur de vérité, false autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        return q1.isTrue(m, a) == q2.isTrue(m, a);
    }
}
