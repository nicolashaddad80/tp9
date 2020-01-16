package fr.cnam.tp9;

public class MenuCommandDecorator extends MenuCommand {

    private Line line;
    public MenuCommandDecorator(Menu a_Menu, Line a_Line) {
        super(a_Menu);
        this.line=a_Line;
    }

    @Override
    public void executer() {
        this.line.print();
        this.menu.afficher();
        this.menu.proposer();

        while (!this.menu.choiceIsQuit()) {
            this.line.print();
            this.menu.afficher();
            this.menu.proposer();
        }

    }
}
