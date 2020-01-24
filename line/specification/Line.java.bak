package fr.cnam.tp9.line.specification;

import fr.cnam.tp9.Printer.specification.Printable;

/**
 * Spécification d’une ligne de texte.
 *
 * @author Anaël Megna
 * @version 1.0
 */
public interface Line extends Cloneable, Printable {
    /**
     * Obtient le nombre de caractères dans une ligne.
     *
     * @return L'entier représentant le nombre de caractères dans une ligne.
     */
    int getLength();

    /**
     * Obtient la position du curseur sur la ligne.
     *
     * @return L'entier représentant la position du curseur sur la ligne.
     */
    int getCursorPos();

    /**
     * Obtient le caractère à la ième position sur la ligne.
     * Ne fonctionne que si i est inférieur à la longueur de la ligne.
     *
     * @param i La position du caractère souhaité.
     * @return Le caractère à la ième position sur la ligne.
     */
    char getCharAt(int i);

    /**
     * Obtient le caractère actuellement sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     *
     * @return Le caractère actuellement sous le curseur.
     */
    char getCurrentChar();

    /**
     * Fait avancer le curseur d'une position à droite.
     * Ne fonctionne que si le curseur n'est pas déjà au bout de la ligne.
     */
    void moveRight();

    /**
     * Fait avancer le curseur d'une position à gauche.
     * Ne fonctionne que si le curseur n'est pas déjà au début de la ligne.
     */
    void moveLeft();

    /**
     * Place le curseur sur le premier caractère.
     * Ne fonctionne que si la ligne est non vide.
     */
    void moveBeginning();

    /**
     * Remplace le caractère sous le curseur par le caractère c.
     * Ne fonctionne qui si la ligne est non vide.
     *
     * @param c Le nouveau caractère.
     */
    void replace(char c);

    /**
     * Supprime le caractère sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     * La position du curseur reste inchangée sauf si le dernier caractère vient d'être supprimé.
     */
    void delete();

    /**
     * Supprime le premier caractère de la ligne.
     * Ne fonctionne que si la ligne est non vide.
     * Le curseur reste sur le même caractère, sauf s'il était sur le dernier caractère.
     */
    void deleteFirst();

    /**
     * Supprime le dernier caractère de la ligne.
     * Ne fonctionne que si la ligne est non vide.
     * Le curseur reste sur le même caractère, sauf s'il était sur le dernier caractère.
     */
    void deleteLast();

    /**
     * Ajoute le caractère c avant le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addBefore(char c);

    /**
     * Ajoute le caractère c après le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addAfter(char c);

    /**
     * Ajoute le caractère c au début de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addBeginning(char c);

    /**
     * Ajoute le caractère c à la fin de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addEnd(char c);

    /**
     * Affiche la ligne en mettant entre crochets [] le caractère courant.
     * Si la ligne est vide, un seul caractère tilde(~) est affiché.
     */
    void print();

    Line clone();
}
