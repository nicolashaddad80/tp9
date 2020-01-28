package fr.cnam.tp9.line.linecommands.simplelinComm;

import fr.cnam.tp9.line.specification.Line;

public class MoveBeginningCommand extends LineComm {

    public MoveBeginningCommand( Line a_Line ) {
        super(a_Line);
    }


    public void executer( ) {
        line.moveBeginning();
        line.getPrinter().print();
    }


    @Override
	public final boolean isExecutable( ){
        return this.line.getCursorPos()>1;
    }
}
