package fr.cnam.tp9;


public class Editor {
    /**
     * Attibuts
     */
    private Menu menu;
    private Line line;

    public Editor() {

        this.line=new LineTab();

        this.menu = new Menu("Main Menu");
        this.menu.setCommand(new MenuCommandDecorator(this.menu,this.line));

        this.fillMenu();
    }

    private void fillMenu(){
        //filling the Menu
        int i=0,j=0;
        CommonMenuComponent[] mainMenuList=new  CommonMenuComponent[8];
        CommonMenuComponent[] subMenuList=new  CommonMenuComponent[3];

        //Creating and filling CursorSubMenu

        Menu cursorSubMenu = new Menu("Cursor Operations Sub Menu");
        cursorSubMenu.setCommand(new MenuCommandDecorator(cursorSubMenu ,this.line));

        subMenuList[i]=new Entry("Placer le curseur au debut de la ligne");
        subMenuList[i++].setCommand(new MoveBeginningCommand(this.line));

        subMenuList[i]=new Entry("Avancer le curseur d une position a droite");
        subMenuList[i++].setCommand(new MoveRightCommand(this.line));

        subMenuList[i]=new Entry("Reculer le curseur d une position a gauche");
        subMenuList[i++].setCommand(new MoveLeftCommand(this.line));

        for(int k=0;k<subMenuList.length;k++){
            cursorSubMenu.add(subMenuList[k]);
        }

        //filling main menu

        mainMenuList[j]=new Entry("Ajouter un caractere au debut de la ligne");
        mainMenuList[j++].setCommand(new AddBeginningCommand(this.line));

        mainMenuList[j]=new Entry("Ajouter un caractere a la fin de la ligne");
        mainMenuList[j++].setCommand(new AddEndCommand(this.line));

        mainMenuList[j++]=cursorSubMenu;

        mainMenuList[j]=new Entry("Remplacer le caractere sous le curseur");
        mainMenuList[j++].setCommand(new ReplaceCommand(this.line));

        mainMenuList[j]=new Entry("Supprimer le caractere sous le curseur");
        mainMenuList[j++].setCommand(new DeleteCommand(this.line));

        mainMenuList[j]=new Entry("Ajouter un caractere avant le curseur");
        mainMenuList[j++].setCommand(new AddBeforeCommand(this.line));

        mainMenuList[j]=new Entry("Ajouter un caractere apres le curseur");
        mainMenuList[j++].setCommand(new AddAfterCommand(this.line));

        mainMenuList[j]=new Entry("Supprimer tous les caracteres de la ligne");
        mainMenuList[j++].setCommand(new DeleteAllCommand(this.line));

        for(int k=0;k<mainMenuList.length;k++){
            this.menu.add(mainMenuList[k]);
        }

    }

    /**
     * Methodes
     */


    public void editer() {

        //Launching Editor
         this.menu.getCommand().executer();

    }
}

