package fr.cnam.tp9;


public class ReplaceCommand extends AddCommand {


    public ReplaceCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        line.replace(this.getCarToInsert());
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()>0;
    }
}