package operateur_binaires;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération binaire "OU" dans la logique modale.
 * Cette classe évalue la disjonction logique de deux formules. L'opération "OU" est vraie si
 * au moins une des deux formules est vraie dans le modèle et le monde spécifiés.
 */
public class OR extends BinaryOperation {

    /**
     * Constructeur pour l'opération "OU".
     * 
     * @param q1 Première formule de la disjonction.
     * @param q2 Deuxième formule de la disjonction.
     */
    public OR(Formule q1, Formule q2) {
        super(q1, q2); 
        /** Symbole Unicode pour l'opérateur logique OU (OR) */
        this.operateur = "\u2228"; 
    }

    /**
     * Évalue si la disjonction des deux formules est vraie dans un modèle et un monde spécifiques.
     *
     * @param m Le modèle dans lequel l'opération doit être évaluée.
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return boolean Renvoie true si au moins une des deux formules est vraie dans le monde spécifié, false autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        return q1.isTrue(m, a) || q2.isTrue(m, a);
    }
}
