package fr.cnam.tp9;

import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.editor.HistoryEditor;
import fr.cnam.tp9.editor.specification.HisEditor;
import fr.cnam.tp9.line.ClonableLineTab;
import fr.cnam.tp9.line.linecommands.*;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.menu.EntryImp;
import fr.cnam.tp9.menu.MenuImp;
import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.menu.specification.Menu;

import java.io.PrintStream;

public class HistLineEditorLauncher {

    PrintStream linePrinterOutputPort = System.out;
    PrintStream editorPrinterOutputPort = System.out;
    PrintStream menuPrinterOutputPort = System.out;

    Menu myMenu;
    ClonableLine myClonableLineTab;
    HisEditor myHisEditor;

    public HistLineEditorLauncher() {
        /* creating needed object to instance an editor
         */

        this.myMenu = new MenuImp(0, "Menu Principal", "", menuPrinterOutputPort);
        this.myClonableLineTab = new ClonableLineTab(linePrinterOutputPort);
        this.myHisEditor = new HistoryEditor(myMenu, myClonableLineTab);

        /* Filing menu and put there desired Commands
         */
        this.fillMenu();

    }

    private void fillMenu() {

        Command[] lineCommandsTable = new CancelableLinComm[20];

        //filling the Menu
        int i = 0, j = 0, c = 0, nbLineCommands = 0;
        Entry[] mainMenuList = new Entry[8];
        Entry[] subMenuList = new Entry[3];

        //Creating Commands:
/*
            lineCommandsTable[nbLineCommands++] = new MoveBeginningCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new MoveRightCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new MoveLeftCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new AddBeginningCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new AddEndCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new ReplaceCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new DeleteCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new AddBeforeCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new AddAfterCommand(this.myClonableLineTab);
            lineCommandsTable[nbLineCommands++] = new DeleteAllCommand(this.myClonableLineTab);

            //Creating and filling CursorSubMenu


            subMenuList[i++] = new EntryImp(i, "Placer le curseur au debut de la ligne    ", lineCommandsTable[c++], "o");
            subMenuList[i++] = new EntryImp(i, "Avancer le curseur d une position a droite", lineCommandsTable[c++], "l");
            subMenuList[i++] = new EntryImp(i, "Reculer le curseur d une position a gauche", lineCommandsTable[c++], "h");

            //filling main menu

            mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere au debut de la ligne", lineCommandsTable[c++], "I");
            mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere a la fin de la ligne", lineCommandsTable[c++], "A");
            Menu cursorSubMenu = new MenuImp(j + 1, "Menu Curseur                              ", "C", menuPrinterOutputPort);
            for (int k = 0; k < subMenuList.length; k++) {
                cursorSubMenu.add(subMenuList[k]);
            }
            mainMenuList[j++] = (Entry) cursorSubMenu;
            mainMenuList[j++] = new EntryImp(j, "Remplacer le caractere sous le curseur   ", lineCommandsTable[c++], "r");
            mainMenuList[j++] = new EntryImp(j, "Supprimer le caractere sous le curseur   ", lineCommandsTable[c++], "x");
            mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere avant le curseur    ", lineCommandsTable[c++], "i");
            mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere apres le curseur    ", lineCommandsTable[c++], "a");
            mainMenuList[j++] = new EntryImp(j, "Supprimer tous les caracteres de la ligne", lineCommandsTable[c++], "dd");


            for (int k = 0; k < mainMenuList.length; k++) {
                this.myMenu.add(mainMenuList[k]);
            }
*/
    }


    public void start() {
        this.myHisEditor.editer();
    }

}

