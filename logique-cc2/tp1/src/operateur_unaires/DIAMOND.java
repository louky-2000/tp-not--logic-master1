package operateur_unaires;

import java.util.Set;

import main.Formule;
import main.Model;
import main.World;

/**
 * Classe représentant l'opération unaire "DIAMOND" (◇) dans la logique modale.
 * Cette opération vérifie la possibilité d'une formule dans au moins un des mondes accessibles.
 * Le symbole ◇ est utilisé pour représenter cette opération, indiquant qu'il est possible que la formule soit vraie
 * dans au moins un monde accessible depuis le monde actuel.
 */
public class DIAMOND extends UnaryOperation {
    public DIAMOND(Formule q){
        super(q);
        /** Symbole Unicode pour l'opérateur DIAMOND (◇) */
        this.operateur = "\u25C7"; 
    }

    /**
     * Évalue la vérité de l'opération DIAMOND dans un monde et un modèle spécifiques.
     * La formule est considérée comme vraie si elle est vraie dans au moins un des mondes accessibles
     * depuis le monde courant.
     *
     * @param m Le modèle dans lequel la formule est évaluée.
     * @param a Le monde spécifique au sein du modèle où la formule doit être évaluée.
     * @return vrai si la formule est vraie dans au moins un des mondes accessibles, faux autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        // Récupère les mondes accessibles depuis le monde 'a'
        Set<World> voisins = m.getGraphe().get(a); 
        for (World world : voisins) {
            if (this.q.isTrue(m, world)) {
                return true; 
            }
        }
        return false; 
    }
}
