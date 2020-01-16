package fr.cnam.tp9;


public class MoveBeginningCommand extends LineComm {

    public MoveBeginningCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        line.moveBeginning();
    }


    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()>1;
    }
}
