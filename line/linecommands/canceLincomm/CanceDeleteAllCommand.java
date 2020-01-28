package fr.cnam.tp9.line.linecommands.canceLincomm;

import fr.cnam.tp9.line.linecommands.simplelinComm.LineComm;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.line.specification.Line;

public class CanceDeleteAllCommand extends CancelableLinComm {

    public CanceDeleteAllCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        super.executer();
        while (CancelableLinComm.clonableLine.getLength()>0) {
            CancelableLinComm.clonableLine.delete();
        }
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return CancelableLinComm.clonableLine.getLength()>0;
    }
}
