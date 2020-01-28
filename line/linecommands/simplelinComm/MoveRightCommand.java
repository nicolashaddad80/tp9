package fr.cnam.tp9.line.linecommands.simplelinComm;

import fr.cnam.tp9.line.specification.Line;

public class MoveRightCommand extends LineComm {

    public MoveRightCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ) {
        LineComm.line.moveRight();
        LineComm.line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return LineComm.line.getCursorPos()<this.line.getLength();
    }
}