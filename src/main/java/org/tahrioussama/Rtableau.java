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
