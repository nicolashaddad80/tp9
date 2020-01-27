package fr.cnam.tp9.line.linecommands;



import fr.cnam.tp9.line.specification.ClonableLine;


public class CanceAddBeginningCommand extends CanceAddCommand {


    public CanceAddBeginningCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){

        //CancelableLinComm.undoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
        super.executer();
        CancelableLinComm.clonableLine.addBeginning(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return true;
    }
}
