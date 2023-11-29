import org.tahrioussama.Rtableau;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class testAjouterElement {

    @Test
    public void testAjouterElement() {
        // Objectif du test : Vérifier que l'ajout d'un élément fonctionne correctement
        // Résultat attendu : La taille du tableau doit augmenter, et l'élément doit être présent
        Rtableau rtableau = new Rtableau(2);
        rtableau.ajouterElement("A");

        assertTrue(rtableau.contenir("A"));
        assertEquals(1, rtableau.taille());

        // Utilisation de assertArrayEquals pour vérifier la taille
        assertArrayEquals(new Object[]{"A"}, rtableau.getElements().toArray());

        // Utilisation de assertNotSame et assertSame
        assertNotSame("Les instances doivent être différentes", "B", rtableau.getElements().get(0));
        assertSame("Les instances doivent être identiques", "A", rtableau.getElements().get(0));

        // Utilisation de assertThat
        assertThat(rtableau.taille(), is(1));
    }

}