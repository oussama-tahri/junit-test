# JUNIT Test

<br>

To use Junit we need to add this dependency :

```markdown
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

<br>

This is the class we are going to use in our test

****'Rtableau'**** class can add elements, delete one or many elements, delete all, can also clear the elements, check if the elements contain the element given and also if it occurs and finally can check the size



```java
package org.tahrioussama;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rtableau<T> {

    private List<T> elements;
    private int capaciteInitiale;

    public Rtableau(int capaciteInitiale) {
        if (capaciteInitiale <= 0) {
            throw new IllegalArgumentException("La capacité initiale doit être strictement positive.");
        }
        this.capaciteInitiale = capaciteInitiale;
        this.elements = new ArrayList<>(capaciteInitiale);
    }

    public void ajouterElement(T element) {
        this.elements.add(element);
    }

    public boolean supprimer(T element) {
        return this.elements.remove(element);
    }

    public boolean supprimerTt(T element) {
        Iterator<T> iterator = this.elements.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public void vider() {
        this.elements.clear();
    }

    public boolean contenir(T element) {
        return this.elements.contains(element);
    }

    public int occNb(T element) {
        int count = 0;
        for (T e : this.elements) {
            if (e.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public int taille() {
        return this.elements.size();
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}
```

<br>

So lets wrap all this in our test :

<br>

testAjouterElement.java

```java
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
```

<br>

TestSupp.java

```java
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

```

<br>

OtherTest.java

```java
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

```