package fr.cnam.tp9.editor;


import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.line.specification.Line;
import fr.cnam.tp9.editor.specification.Editor;
import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.menu.specification.Menu;


public class SimpleEditor implements Editor {
    /**
     * Attibuts
     */
    protected Menu currentMenu;
    protected Line line;

    /**
     * Constructor
     *
     * @param a_currentMenu
     * @param a_Line
     */
    public SimpleEditor(Menu a_currentMenu, Line a_Line) {

        this.currentMenu = a_currentMenu;
        this.line = a_Line;

    }

    /**
     * Methodes
     */
    public void editer() {
        do {

            this.line.getPrinter().print();
            this.currentMenu.getPrinter().print();

            Entry choice = this.currentMenu.proposer();

            if (choice.isMenu()) {
                this.currentMenu = (Menu) choice;
            } else {
                //TODO Arch++:delegate to a proxy in further version
                this.execute(choice.getCommand());
            }
        }while (!this.currentMenu.choiceIsQuit());
    }

    //TODO Arch++:delegate to a proxy in further version
    protected void execute(Command a_Command) {

        if (a_Command.isExecutable()) {

            a_Command.executer();
        }
    }
}

