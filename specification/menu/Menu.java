package fr.cnam.tp9.specification.menu;

import fr.cnam.tp9.specification.printer.Printable;

public interface Menu extends Printable {
    void add(Entry a_Entry);

    Entry proposer();

    boolean choiceIsQuit();

}
