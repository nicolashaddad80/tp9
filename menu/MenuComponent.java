package fr.cnam.tp9.menu;

import fr.cnam.tp9.command.Command;

public interface MenuComponent {

    public String toString();
    public Command getCommand();
    public boolean isMenu();
    public String getShortcut();
    Integer getNumber();
}
