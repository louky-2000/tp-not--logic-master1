package main;

import java.util.Set;

/**
 * Classe représentant un atome en logique modale, c'est-à-dire une proposition 
 * basique qui peut être vraie ou fausse. Cette classe supporte également des propositions
 * spéciales telles que TOP (toujours vrai) et BOTTOM (toujours faux).
 */
public class Atom extends Formule {
    private String proposition;

    /** Proposition toujours vraie. */
    public static final String TOP = "T";   
    
    /** Proposition toujours fausse. */
    public static final String BOTTOM = "F";  

    /**
     * Constructeur qui initialise un atome avec une proposition spécifique.
     *
     * @param proposition La chaîne représentant la proposition.
     */
    public Atom(String proposition) {
        this.proposition = proposition;
    }

    /**
     * Récupère la proposition associée à cet atome.
     *
     * @return La chaîne représentant la proposition de cet atome.
     */
    public String getProposition() {
        return proposition;
    }

    /**
     * Définit ou modifie la proposition associée à cet atome.
     *
     * @param proposition La nouvelle chaîne représentant la proposition de cet atome.
     */
    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    /**
     * Évalue la vérité de cet atome dans un monde et un modèle spécifiques.
     * Si l'atome représente TOP, il retourne toujours vrai.
     * Si l'atome représente BOTTOM, il retourne toujours faux.
     * Sinon, il vérifie si cet atome est présent dans le monde donné.
     *
     * @param m Le modèle dans lequel la formule est évaluée.
     * @param a Le monde spécifique au sein du modèle où la formule doit être évaluée.
     * @return vrai si l'atome est vrai dans le monde spécifié, faux autrement.
     */
    @Override
    public boolean isTrue(Model m, World a) {
        if (proposition.equals(Atom.TOP)) {
            return true;
        } else if (proposition.equals(Atom.BOTTOM)) {
            return false;
        }
        Set<Atom> w = a.getAtoms();
        for (Atom atom : w) {
            if (atom.getProposition().equals(this.getProposition())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Retourne la représentation sous forme de chaîne de caractères de cette proposition.
     * Cette méthode est utilisée pour obtenir une représentation textuelle directe de l'objet,
     * typiquement la chaîne stockée dans la variable 'proposition'.
     * 
     * @return La chaîne de caractères représentant la proposition.
     */
    @Override
    public String toString() {
        return proposition;
    }
}
