package fr.cnam.tp9.specification.menu;

import fr.cnam.tp9.specification.command.Command;

public interface Entry {

    String toString();

    Command getCommand();

    boolean isMenu();

    String getShortcut();

    Integer getNumber();
}
