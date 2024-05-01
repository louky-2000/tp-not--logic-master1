package operateur_unaires;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération unaire "NEG" (¬) dans la logique modale.
 * Cette opération applique la négation à une formule, vérifiant la non-vérité de cette formule
 * dans un monde donné. Le symbole ¬ est utilisé pour représenter cette opération.
 */
public class NEG extends UnaryOperation {
    /**
     * Constructeur pour l'opération de négation.
     * 
     * @param q La formule à nier.
     */
    public NEG(Formule q) {
        super(q);
        /** Symbole Unicode pour l'opérateur de négation (¬) */
        this.operateur = "\u00AC"; 
    }

    /**
     * Évalue la négation de la formule dans un modèle et un monde spécifiques.
     * La formule est considérée comme fausse si elle est vraie, et vraie si elle est fausse.
     *
     * @param m Le modèle dans lequel la formule est évaluée. 
     * @param a Le monde spécifique au sein du modèle où la négation doit être évaluée.
     * @return vrai si la formule est fausse dans le monde spécifié, faux si elle est vraie.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        return !this.q.isTrue(m, a);
    }
}
