package operateur_unaires;

import java.util.Set;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération unaire "BOX" (□) dans la logique modale.
 * Cette opération vérifie la nécessité d'une formule dans tous les mondes accessibles.
 * Le symbole □ est utilisé pour représenter cette opération, indiquant que la formule doit être vraie
 * dans tous les mondes accessibles depuis le monde actuel pour que l'opération retourne vrai.
 */
public class BOX extends UnaryOperation {
    /**
     * Constructeur pour l'opération de nécessité.
     * 
     * @param q La formule dont la nécessité est à vérifier dans tous les mondes accessibles.
     */
    public BOX(Formule q) {
        super(q);
        /** Symbole Unicode pour l'opérateur BOX (□) */
        this.operateur = "\u25A1"; 
    }

    /**
     * Évalue la nécessité de la formule dans un modèle et un monde spécifiques.
     * La formule est considérée comme nécessairement vraie si elle est vraie dans tous les mondes accessibles
     * depuis le monde courant.
     *
     * @param m Le modèle dans lequel l'opération doit être évaluée.
     * @param a Le monde spécifique au sein du modèle où l'opération doit être évaluée.
     * @return vrai si la formule est vraie dans tous les mondes accessibles, faux autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        Set<World> voisins = m.getGraphe().get(a); 
        for (World world : voisins) {
            if (!this.q.isTrue(m, world)) {
                return false; 
            }
        }
        return true;
    }
}
