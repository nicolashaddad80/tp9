package fr.cnam.tp9.line.linecommands.canceLincomm;

import fr.cnam.tp9.line.linecommands.simplelinComm.AddCommand;
import fr.cnam.tp9.line.linecommands.simplelinComm.LineComm;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.line.specification.Line;

public class CanceAddAfterCommand extends CanceAddCommand {


    public CanceAddAfterCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        super.executer();
        CancelableLinComm.clonableLine.addAfter(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.clonableLine.getCursorPos()>0;
    }
}
