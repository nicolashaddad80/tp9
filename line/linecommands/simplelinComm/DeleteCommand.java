package fr.cnam.tp9.line.linecommands.simplelinComm;

import fr.cnam.tp9.line.specification.Line;

public class DeleteCommand extends LineComm {

    public DeleteCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ) {
        line.delete();
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.line.getCursorPos()>0;
    }
}
