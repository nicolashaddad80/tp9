package fr.cnam.tp9.line.linecommands.canceLincomm;



import fr.cnam.tp9.line.specification.ClonableLine;


public class CanceAddBeginningCommand extends CanceAddCommand {


    public CanceAddBeginningCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){

        super.executer();
        CancelableLinComm.clonableLine.addBeginning(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return true;
    }
}
