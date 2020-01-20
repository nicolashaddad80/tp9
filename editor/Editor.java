package fr.cnam.tp9.editor;


import fr.cnam.tp9.command.Command;
import fr.cnam.tp9.line.*;
import fr.cnam.tp9.line.linecommands.*;
import fr.cnam.tp9.menu.Entry;
import fr.cnam.tp9.menu.Menu;
import fr.cnam.tp9.menu.MenuComponent;

public class Editor {
    /**
     * Attibuts
     */
    protected Menu currentMenu = new Menu(0,"Main Menu","");
    protected Line line;

    protected LineComm[] lineCommandsTable = new LineComm[20];
    protected int nbLineCommands =0;

    public Editor(Line a_Line) {

        this.line = new LineTab();
        this.fillMenu();
    }

    private void fillMenu() {
        //filling the Menu
        int i = 0, j = 0, c=0;
        MenuComponent[] mainMenuList = new MenuComponent[8];
        MenuComponent[] subMenuList = new MenuComponent[3];

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



        subMenuList[i++]=new Entry(i,"Placer le curseur au debut de la ligne    ", this.lineCommandsTable[c++],"o");
        subMenuList[i++]=new Entry(i,"Avancer le curseur d une position a droite",this.lineCommandsTable[c++] ,"l");
        subMenuList[i++]=new Entry(i,"Reculer le curseur d une position a gauche",this.lineCommandsTable[c++] ,"h");

        //filling main menu

        mainMenuList[j++]=new Entry(j,"Ajouter un caractere au debut de la ligne",this.lineCommandsTable[c++] ,"I");
        mainMenuList[j++]=new Entry(j,"Ajouter un caractere a la fin de la ligne",this.lineCommandsTable[c++] ,"A");
        Menu cursorSubMenu = new Menu(j+1,"Cursor Operations Sub Menu                 ","C");
        for (int k = 0; k < subMenuList.length; k++) {
            cursorSubMenu.add(subMenuList[k]);
        }
        mainMenuList[j++]=cursorSubMenu;
        mainMenuList[j++]=new Entry(j,"Remplacer le caractere sous le curseur   ", this.lineCommandsTable[c++],"r");
        mainMenuList[j++]=new Entry(j,"Supprimer le caractere sous le curseur   ",this.lineCommandsTable[c++] ,"x");
        mainMenuList[j++]=new Entry(j,"Ajouter un caractere avant le curseur    ",this.lineCommandsTable[c++] ,"i");
        mainMenuList[j++]=new Entry(j,"Ajouter un caractere apres le curseur    ",this.lineCommandsTable[c++] ,"a");
        mainMenuList[j++]=new Entry(j,"Supprimer tous les caracteres de la ligne",this.lineCommandsTable[c++] ,"dd");


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
            this.line.print();
            System.out.print(this.currentMenu.afficher());

            MenuComponent choice = this.currentMenu.proposer();

            //si le choix de l'utilisation est un sous menu
            if (choice.isMenu()) {
                this.currentMenu= (Menu) choice;
            }
            else { //sinon le choix de l'utilisateur est forcement une entry
                    this.execute(choice.getCommand());
                   //delegate to a proxy in further version

            }
            // L'utilisateur n'a pas choisi de quitter l'editeur
        } while (!this.currentMenu.choiceIsQuit());
    }

    protected void execute(Command a_Command){

        if(a_Command.isExecutable()){

            a_Command.executer();
        }
    }
}

