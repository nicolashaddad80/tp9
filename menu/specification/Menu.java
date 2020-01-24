package fr.cnam.tp9.menu.specification;

import fr.cnam.tp9.Printer.specification.Printable;

public interface Menu extends Printable {
    void add(Entry a_Entry);

    Entry proposer();

    boolean choiceIsQuit();

}
