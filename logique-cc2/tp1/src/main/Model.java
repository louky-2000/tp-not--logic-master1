package main;

import java.util.Map;
import java.util.Set;

/**
 * La classe Model est conçue pour représenter un modèle logique.
 * Un modèle est composé d'un ensemble de mondes (Worlds) et d'une relation d'accessibilité.
 * La relation d'accessibilité est représentée par une HashMap où chaque monde est associé à un ensemble de mondes accessibles.
 * Chaque monde (World) est caractérisé par un ensemble d'atomes qui sont vrais dans ce monde.
 */
public class Model {
    /** Ensemble des mondes dans le modèle */
    private Set<World> monde;
    /** Graphe représentant la relation d'accessibilité entre les mondes. */
    private Map< World , Set<World> > graphe;

    /**
     * Constructeur de la classe Model.
     * @param monde Ensemble des mondes du modèle.
     * @param graphe Relation d'accessibilité entre les mondes.
     */
    public Model(Set<World> monde , Map< World , Set<World> > graphe ){
        this.graphe = graphe;
        this.monde = monde;
    }

    /** Accesseur pour obtenir l'ensemble des mondes du modèle. 
     * @return monde l'ensemble des mondes possibles
    */
    public Set<World> getMonde() {
        return monde;
    }

    /** Mutateur pour définir l'ensemble des mondes du modèle.
     * @param monde
     */
    public void setMonde(Set<World> monde) {
        this.monde = monde;
    }

    /** 
     * Accesseur pour obtenir la relation d'accessibilité (graphe) entre les mondes. 
     * @return graphe le graphe de tous les mondes possible
    */
    public Map<World, Set<World>> getGraphe() {
        return graphe;
    }

    /**
     * Mutateur pour définir la relation d'accessibilité (graphe) entre les mondes. 
     * @param graphe le graphe de tous les mondes possible
     */
    public void setGraphe(Map<World, Set<World>> graphe) {
        this.graphe = graphe;
    }
    
}
