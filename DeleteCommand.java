package fr.cnam.tp9;


public class DeleteCommand extends LineComm {

    public DeleteCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        line.delete();
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()>0;
    }
}
