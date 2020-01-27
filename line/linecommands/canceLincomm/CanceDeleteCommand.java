package fr.cnam.tp9.line.linecommands.canceLincomm;

import fr.cnam.tp9.line.linecommands.simplelinComm.LineComm;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.line.specification.Line;

public class CanceDeleteCommand extends CancelableLinComm {

    public CanceDeleteCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        super.executer();
        CancelableLinComm.clonableLine.delete();
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return CancelableLinComm.clonableLine.getCursorPos()>0;
    }
}
