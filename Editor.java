package fr.cnam.tp9;


public class Editor {
    /**
     * Attibuts
     */
    private Menu currentMenu;
    private Line line;

    public Editor() {

        this.line = new LineTab();

        this.currentMenu = new Menu("Main Menu");


        this.fillMenu();
    }

    private void fillMenu() {
        //filling the Menu
        int i = 0, j = 0;
        CommonMenuComponent[] mainMenuList = new CommonMenuComponent[8];
        CommonMenuComponent[] subMenuList = new CommonMenuComponent[3];

        //Creating and filling CursorSubMenu



        subMenuList[i++]=new Entry("Placer le curseur au debut de la ligne", new MoveBeginningCommand(this.line));
        subMenuList[i++]=new Entry("Avancer le curseur d une position a droite", new MoveRightCommand(this.line));
        subMenuList[i++]=new Entry("Reculer le curseur d une position a gauche", new MoveLeftCommand(this.line));

        Menu cursorSubMenu = new Menu("Cursor Operations Sub Menu");
        for (int k = 0; k < subMenuList.length; k++) {
            cursorSubMenu.add(subMenuList[k]);
        }

        //filling main menu

        mainMenuList[j++]=new Entry("Ajouter un caractere au debut de la ligne", new AddBeginningCommand(this.line));
        mainMenuList[j++]=new Entry("Ajouter un caractere a la fin de la ligne", new AddEndCommand(this.line));
        mainMenuList[j++]=cursorSubMenu;
        mainMenuList[j++]=new Entry("Remplacer le caractere sous le curseur", new ReplaceCommand(this.line));
        mainMenuList[j++]=new Entry("Supprimer le caractere sous le curseur", new DeleteCommand(this.line));
        mainMenuList[j++]=new Entry("Ajouter un caractere avant le curseur", new AddBeforeCommand(this.line));
        mainMenuList[j++]=new Entry("Ajouter un caractere apres le curseur", new AddAfterCommand(this.line));
        mainMenuList[j++]=new Entry("Supprimer tous les caracteres de la ligne", new DeleteAllCommand(this.line));


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
            this.currentMenu.afficher();

            MenuComponent choice = this.currentMenu.proposer();
            if (choice.isMenu()) {
                this.currentMenu= (Menu) choice;
            }
            else { //delegate to a proxy in further version
                    Command commndCondidate=choice.getCommand();
                    if(commndCondidate.isExecutable()){
                        commndCondidate.executer();

                }

                    else{
                        //Tghrout Exception
                    }
            }
        } while (!this.currentMenu.choiceIsQuit());
    }
}

