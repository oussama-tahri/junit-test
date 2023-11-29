import org.tahrioussama.Rtableau;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSupp {

    @Test
    public void testSupprimerElement() {
        // Objectif du test : Vérifier que la suppression d'un élément unique fonctionne correctement
        // Résultat attendu : La méthode doit renvoyer vrai, et l'élément ne doit plus être présent dans le tableau
        Rtableau rtableau = new Rtableau(2);
        rtableau.ajouterElement("A");
        assertTrue(rtableau.supprimer("A"));
        assertFalse(rtableau.contenir("A"));
        assertEquals(0, rtableau.taille());
    }

    @Test
    public void testSupprimerTt() {
        // Objectif du test : Vérifier que la suppression de toutes les occurrences d'un élément fonctionne correctement
        // Résultat attendu : La méthode doit renvoyer vrai, et toutes les occurrences de l'élément doivent être supprimées
        Rtableau rtableau = new Rtableau(3);
        rtableau.ajouterElement("A");
        rtableau.ajouterElement("A");
        rtableau.ajouterElement("B");
        assertTrue(rtableau.supprimerTt("A"));
        assertFalse(rtableau.contenir("A"));
        assertTrue(rtableau.contenir("B"));
        assertEquals(1, rtableau.taille());
    }
}
