package fr.cnam.tp9.line.linecommands.cancelinecomm;

import fr.cnam.tp9.line.specification.ClonableLine;


public class CanceAddBeforeCommand extends CanceAddCommand {


    public CanceAddBeforeCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        super.executer();
        CancelableLinComm.clonableLine.addBefore(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return CancelableLinComm.clonableLine.getCursorPos()>0;
    }
}
