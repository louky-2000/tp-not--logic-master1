package main;

import operateur_binaires.AND;
import operateur_binaires.OR;
import operateur_unaires.BOX;
import operateur_unaires.DIAMOND;

/**
 * Main class tp2
 */
public class MainTp2 {
    public static void main(String[] args) {
        // Appliquez l’algorituhme sur la formule : ◇¬A ∧ □◇A ∧ □□¬A
        Atom a = new Atom("A");
        Atom not_a = new Atom("¬A");
        Formule q1 = new DIAMOND(not_a);
        Formule q2 = new BOX(new DIAMOND(a));
        Formule left = new AND(q1,q2);
        Formule rigt = new BOX(new BOX(not_a));
        Formule f1 = new AND(left, rigt);

        // Appliquez l’algorituhme sur la formule : □A ∧ (◇¬A ∨ ◇A)
        left = new BOX(a);
        rigt = new OR(new DIAMOND(not_a),new DIAMOND(a));
        Formule f2 = new AND(left, rigt);
        System.out.println("Appliquez l’algorithme sur la formule : " + f1);

        System.out.println("Appliquez l’algorithme sur la formule : " + f2);

    }
}
