package fr.cnam.tp9.line;

public class MoveLeftCommand extends LineComm {

    public MoveLeftCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        line.moveLeft();
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()>1;
    }
}