package fr.cnam.tp9.editor;

import java.io.PrintStream;
import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.editor.specification.Editor;
import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.menu.specification.Menu;


public class SimpleEditor implements Editor {
    /**
	 * Attibuts
	 */
	protected Menu currentMenu;


    
	protected int nbLineCommands = 0;
	
	
	protected PrintStream a_editorOutStream;
	
	/**
	 * Constructor
	 * 
	 * @param a_currentMenu

	 */
	public SimpleEditor( Menu a_currentMenu) {

        this.currentMenu = a_currentMenu;

    }
	
	/**
	 * Methodes
	 */
	public void editer( ) {
        do {

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
    protected void execute( Command a_Command ) {

        if (a_Command.isExecutable()) {

            a_Command.executer();
        }
    }
}

