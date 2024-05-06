package main;

/**
 * Classe abstraite représentant une formule logique dans le cadre de la logique modale.
 * Cette classe sert de base pour définir des types spécifiques de formules qui peuvent être
 * évaluées au sein d'un modèle et d'un monde donnés. Elle encapsule des propriétés communes
 * telles que l'étiquette et le marqueur d'état de traitement de la formule.
 */
public abstract class Formule {
    /** Marqueur pour indiquer si la formule a été traitée. */
    protected boolean marque; 
    /** Étiquette associée à la formule pour l'identification. */
    protected String label;   

    /**
     * Constructeur par défaut qui initialise une formule sans étiquette.
     */
    public Formule(){
        this(null);
    }

    /**
     * Constructeur qui initialise une formule avec une étiquette spécifique.
     * La formule est initialement non marquée.
     * 
     * @param label L'étiquette à associer à cette formule.
     */
    public Formule(String label){
        this.label = label;
        this.marque = false;
    }

    /**
     * Récupère l'étiquette de la formule.
     * 
     * @return L'étiquette de la formule.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit l'étiquette de la formule.
     * 
     * @param label La nouvelle étiquette à associer à la formule.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Indique si la formule a été marquée comme traitée.
     * 
     * @return true si la formule est marquée, false autrement.
     */
    public boolean isMarque() {
        return marque;
    }

    /**
     * Marque ou démarque la formule comme traitée.
     * 
     * @param marque Nouvel état de marquage pour la formule.
     */
    public void setMarque(boolean marque) {
        this.marque = marque;
    }

    /**
     * Détermine la valeur de vérité de cette formule dans un monde et un modèle spécifiques.
     * Cette méthode doit être implémentée par les sous-classes pour fournir la logique spécifique
     * d'évaluation de la formule.
     *
     * @param m Le modèle dans lequel la formule est évaluée.
     * @param a Le monde spécifique au sein du modèle où la formule est évaluée.
     * @return vrai si la formule est vraie dans le monde et le modèle spécifiés, faux autrement.
     */
    public abstract boolean isTrue(Model m, World a);
    
}
