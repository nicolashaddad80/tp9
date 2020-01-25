package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.specification.Line;

public class AddEndCommand extends AddCommand {


    public AddEndCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer(){
        line.addEnd(this.getCarToInsert());
    }

    @Override
    public final boolean isExecutable(){
        return true;
    }
}