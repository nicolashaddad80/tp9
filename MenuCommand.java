package fr.cnam.tp9;


public class MenuCommand implements Command {
    protected Menu menu;

    public MenuCommand(Menu a_Menu) {

        this.menu=a_Menu;

    }

    @Override
    public void executer() {
        this.menu.afficher();
        this.menu.proposer();
    }


   @Override
    public boolean isExecutable() {
       int i=1;
        boolean atLeastOneExecutable=false;
        while(i<this.menu.getNbElements() && ! atLeastOneExecutable) {
            atLeastOneExecutable = this.menu.getCompAt(i).getCommand().isExecutable();
            i++;
        }
    return atLeastOneExecutable;
    }
}
