import org.tahrioussama.Rtableau;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OtherTest {
    @Test
    public void testVider() {
        // Objectif du test : Vérifier que la méthode vider vide correctement le tableau
        // Résultat attendu : La méthode doit vider le tableau, et la taille doit être égale à zéro
        Rtableau rtableau = new Rtableau(3);
        rtableau.ajouterElement("A");
        rtableau.ajouterElement("B");
        rtableau.vider();
        assertEquals(0, rtableau.taille());
    }

    @Test
    public void testOccNb() {
        // Objectif du test : Vérifier que la méthode occNb renvoie le nombre correct d'occurrences d'un élément
        // Résultat attendu : La méthode doit renvoyer le nombre d'occurrences correct
        Rtableau rtableau = new Rtableau(3);
        rtableau.ajouterElement("A");
        rtableau.ajouterElement("A");
        rtableau.ajouterElement("B");
        assertEquals(2, rtableau.occNb("A"));
    }
}
