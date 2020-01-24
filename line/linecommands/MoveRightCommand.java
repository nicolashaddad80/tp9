package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.specification.Line;

public class MoveRightCommand extends LineComm {

    public MoveRightCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        line.moveRight();
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()<this.line.getLength();
    }
}