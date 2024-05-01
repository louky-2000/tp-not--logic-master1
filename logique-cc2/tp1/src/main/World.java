package main;

import java.util.Set;

/**
 * Représente un monde dans la logique modale. Un monde est défini par un ensemble d'atomes
 * et peut avoir un nom qui le distingue des autres mondes.
 */
public class World {
    /** Ensemble d'atomes présents dans ce monde. */
    private Set<Atom> atoms; 
    /** Nom du monde. */
    private String name;     

    /**
     * Constructeur pour créer un nouveau monde.
     * 
     * @param name Le nom du monde, permettant de l'identifier de manière unique.
     * @param atoms L'ensemble des atomes qui définissent les propriétés de ce monde.
     */
    public World(String name, Set<Atom> atoms) {
        this.atoms = atoms;
        this.name = name;
    }

    /**
     * Renvoie l'ensemble des atomes de ce monde.
     * 
     * @return Un ensemble contenant les atomes du monde.
     */
    public Set<Atom> getAtoms() {
        return atoms;
    }

    /**
     * Modifie l'ensemble des atomes de ce monde.
     * 
     * @param atoms Le nouvel ensemble d'atomes à affecter à ce monde.
     */
    public void setAtoms(Set<Atom> atoms) {
        this.atoms = atoms;
    }

    /**
     * Récupère le nom de ce monde.
     * 
     * @return Le nom du monde.
     */
    public String getName() {
        return name;
    }
}
