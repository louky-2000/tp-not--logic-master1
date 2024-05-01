package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import operateur_binaires.IMPLIES;
import operateur_unaires.BOX;
import operateur_unaires.DIAMOND;
import operateur_unaires.NEG;

/**
 * Main class
 */
public class Main {

    static String unicode_formule = "\u22A8";

    /**
     * C'est une application du graphe du diapo 18 du cours
     */
    public static void application1(){
        Atom q = new Atom("q");
        Atom not_q = new Atom("¬q");
        // Utilisation de l'opérateur unaire pour la négation
        NEG not = new NEG(q);

        World w1 = new World("W1", new HashSet<>(Arrays.asList(not_q)));
        World w2 = new World("W2", new HashSet<>(Arrays.asList(not_q)));
        World w3 = new World("W3", new HashSet<>(Arrays.asList(q)));
        World w4 = new World("W4", new HashSet<>(Arrays.asList(q)));
        World w5 = new World("W5", new HashSet<>(Arrays.asList(not_q)));

        Set<World> world = new HashSet<>(Arrays.asList(w1, w2, w3, w4, w5));

        // graphe du diapo 18
        Map<World, Set<World>> graphe = new HashMap<>();
        graphe.put(w1, new HashSet<>(Arrays.asList(w2)));
        graphe.put(w2, new HashSet<>(Arrays.asList(w3, w4)));
        graphe.put(w3, new HashSet<>(Arrays.asList(w3, w5)));
        graphe.put(w4, new HashSet<>(Arrays.asList(w5)));
        graphe.put(w5, new HashSet<>());

        Model model = new Model(world, graphe);

        System.out.println("Le résultat de M,w1 " + unicode_formule + " " + not.getOperator() + " φ est : " + not.isTrue(model, w1));

        BOX box = new BOX(q);
        BOX box_box = new BOX(box);
        System.out.println("Le résultat de M,w1 " + unicode_formule + " " + box.getOperator() + " " +  box.getOperator() + " φ est : " + box_box.isTrue(model, w1));

        System.out.println("Le résultat de M,w2 " + unicode_formule + " " + box.getOperator() + " φ est : " + box.isTrue(model, w2));

        DIAMOND diamond = new DIAMOND(q);
        System.out.println("Le résultat de M,w3 " + unicode_formule + " " + diamond.getOperator() + " φ est : " + diamond.isTrue(model, w3));

        System.out.println("Le résultat de M,w5 " + unicode_formule + " " + box.getOperator() + " φ est : " + box.isTrue(model, w5));

        box = new BOX(not);
        System.out.println("Le résultat de M,w5 " + unicode_formule + " " + box.getOperator() + " φ est : " + box.isTrue(model, w5));
    }

    /**
     * Application 2 du graphe du tp1
     */
    public static void application2(){
        Atom q = new Atom("q");
        Atom not_q = new Atom("¬q");
        Atom p = new Atom("p");
        Atom not_p = new Atom("¬p");

        World w0 = new World("W0", new HashSet<>(Arrays.asList(p, q)));
        World w1 = new World("W1", new HashSet<>(Arrays.asList(p, not_q)));
        World w2 = new World("W2", new HashSet<>(Arrays.asList(p, not_q)));
        World w3 = new World("W3", new HashSet<>(Arrays.asList(not_p, not_q)));

        Set<World> world = new HashSet<>(Arrays.asList(w0, w1, w2, w3));

        // Graphe du tp1
        Map<World, Set<World>> graphe = new HashMap<>();
        graphe.put(w0, new HashSet<>(Arrays.asList(w0,w1, w2)));
        graphe.put(w1, new HashSet<>());
        graphe.put(w2, new HashSet<>(Arrays.asList(w0,w2)));
        graphe.put(w3, new HashSet<>(Arrays.asList(w1, w2)));

        Model model = new Model(world, graphe);

        NEG notQ = new NEG(q);

        BOX box = new BOX(p);
        System.out.println("Le résultat de M,w0 " + unicode_formule + " " + box.getOperator() + " p est : " + box.isTrue(model, w0));
        
        System.out.println("Le résultat de M,w3 " + unicode_formule + " " + box.getOperator() + " p est : " + box.isTrue(model, w3));
        
        BOX box_box = new BOX(box);
        System.out.println("Le résultat de M,w3 " + unicode_formule + " " + box.getOperator() + " " +  box.getOperator() + " p est : " + box_box.isTrue(model, w3));

        BOX box_neg_q = new BOX(not_q);
        System.out.println("Le résultat de M,w0 " + unicode_formule + " " + box.getOperator() + " " +  notQ.getOperator() + " q est : " + box_neg_q.isTrue(model, w0));

        IMPLIES implies = new IMPLIES(box, p);
        System.out.println("Le résultat de M,w3 " + unicode_formule + " " + box.getOperator() + " p " + implies.getOperator() + " p est : " + implies.isTrue(model, w3));

        DIAMOND diamond_p = new DIAMOND(p);
        BOX box_diamond_p = new BOX(diamond_p);
        System.out.println("Le résultat de M,w0 " + unicode_formule + " " + box.getOperator() + " " +  diamond_p.getOperator() + " p est : " + box_diamond_p.isTrue(model, w0));

        DIAMOND diamond_not_q = new DIAMOND(notQ);
        System.out.println("Le résultat de M,w0 " + unicode_formule + " " + diamond_not_q.getOperator() + " " +  notQ.getOperator() + " q est : " + diamond_not_q.isTrue(model, w0));

        // Utilisation de l'opérateur de tautologie
        Atom top = new Atom("⊤"); // Utilisation d'un symbole correct si disponible
        BOX box_top = new BOX(top);
        System.out.println("Le résultat de M,w1 " + unicode_formule + " " + box.getOperator() + " ⊤ est : " + box_top.isTrue(model, w1));

        BOX box_diamond_neg_q = new BOX(diamond_not_q);
        System.out.println("Le résultat de M,w2 " + unicode_formule + " " + box.getOperator() + " " + diamond_not_q.getOperator() + " " +  notQ.getOperator() + "q est : " + box_diamond_neg_q.isTrue(model, w2));
    }

    public static void main(String[] args) {
        System.out.println("\n------- Application 1 du graphe du diapo 18 du cours -------\n");
        application1();
        System.out.println("\n------- Application 2 du graphe du tp1 -------\n");
        application2();
    }
}
