package fr.cnam.tp9.line.linecommands.simplelinComm;

import fr.cnam.tp9.line.specification.Line;

public class MoveLeftCommand extends LineComm {

    public MoveLeftCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ) {
        line.moveLeft();
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.line.getCursorPos()>1;
    }
}