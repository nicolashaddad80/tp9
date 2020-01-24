package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.specification.Line;

public class AddBeginningCommand extends AddCommand {


    public AddBeginningCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer(){
        line.addBeginning(this.getCarToInsert());
    }

    @Override
    public final boolean isExecutable(){
        return true;
    }
}
