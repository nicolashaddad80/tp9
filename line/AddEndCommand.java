package fr.cnam.tp9.line;


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