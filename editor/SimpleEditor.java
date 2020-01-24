package fr.cnam.tp9.editor;


import fr.cnam.tp9.specification.command.Command;
import fr.cnam.tp9.specification.editor.Editor;
import fr.cnam.tp9.specification.menu.Menu;
import fr.cnam.tp9.specification.menu.Entry;
import fr.cnam.tp9.specification.line.Line;


import fr.cnam.tp9.line.linecommands.*;
import fr.cnam.tp9.menu.EntryImp;
import fr.cnam.tp9.menu.MenuImp;



import java.io.PrintStream;

public class SimpleEditor implements Editor {
    /**
     * Attibuts
     */
    protected Menu currentMenu;
    protected Line line;
    protected Command[] lineCommandsTable = new LineComm[20];
    protected int nbLineCommands = 0;

    protected PrintStream a_editorOutStream;

    public SimpleEditor(Line a_Line, PrintStream a_editorOutStream) {
        this.a_editorOutStream = a_editorOutStream;
        this.currentMenu = new MenuImp(0, "Menu Principal", "", a_editorOutStream);
        this.line = a_Line;
        this.fillMenu();
    }

    private void fillMenu() {
        //filling the Menu
        int i = 0, j = 0, c = 0;
        Entry[] mainMenuList = new Entry[8];
        Entry[] subMenuList = new Entry[3];

        //Creating Commands:
        this.lineCommandsTable[nbLineCommands++]=new MoveBeginningCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new MoveRightCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new MoveLeftCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new AddBeginningCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new AddEndCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new ReplaceCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new DeleteCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new AddBeforeCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new AddAfterCommand(this.line);
        this.lineCommandsTable[nbLineCommands++]=new DeleteAllCommand(this.line);

        //Creating and filling CursorSubMenu


        subMenuList[i++]=new EntryImp(i, "Placer le curseur au debut de la ligne    ", this.lineCommandsTable[c++], "o");
        subMenuList[i++]=new EntryImp(i, "Avancer le curseur d une position a droite", this.lineCommandsTable[c++], "l");
        subMenuList[i++]=new EntryImp(i, "Reculer le curseur d une position a gauche", this.lineCommandsTable[c++], "h");

        //filling main menu

        mainMenuList[j++]=new EntryImp(j, "Ajouter un caractere au debut de la ligne", this.lineCommandsTable[c++], "I");
        mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere a la fin de la ligne", this.lineCommandsTable[c++], "A");
        Menu cursorSubMenu = new MenuImp(j + 1, "Menu Curseur                              ", "C", a_editorOutStream);
        for (int k = 0; k < subMenuList.length; k++) {
            cursorSubMenu.add(subMenuList[k]);
        }
        mainMenuList[j++]= (Entry)cursorSubMenu;
        mainMenuList[j++]=new EntryImp(j, "Remplacer le caractere sous le curseur   ", this.lineCommandsTable[c++], "r");
        mainMenuList[j++]=new EntryImp(j, "Supprimer le caractere sous le curseur   ", this.lineCommandsTable[c++], "x");
        mainMenuList[j++]=new EntryImp(j, "Ajouter un caractere avant le curseur    ", this.lineCommandsTable[c++], "i");
        mainMenuList[j++]=new EntryImp(j, "Ajouter un caractere apres le curseur    ", this.lineCommandsTable[c++], "a");
        mainMenuList[j++]=new EntryImp(j, "Supprimer tous les caracteres de la ligne", this.lineCommandsTable[c++], "dd");


        for (int k = 0; k < mainMenuList.length; k++) {
            currentMenu.add(mainMenuList[k]);
        }

    }

    /**
     * Methodes
     */


    public void editer() {

        //Launching Editor


        do {
            //this.line.print();

            this.line.getPrinter().print();

            this.currentMenu.getPrinter().print();

            Entry choice = this.currentMenu.proposer();

            //si le choix de l'utilisation est un sous menu
            if (choice.isMenu()) {
                this.currentMenu = (MenuImp) choice;
            } else { //sinon le choix de l'utilisateur est forcement une entry
                this.execute(choice.getCommand());
                //delegate to a proxy in further version

            }
            // L'utilisateur n'a pas choisi de quitter l'editeur
        } while (!this.currentMenu.choiceIsQuit());
    }

    protected void execute(Command a_Command) {

        if (a_Command.isExecutable()) {

            a_Command.executer();
        }
    }
}

