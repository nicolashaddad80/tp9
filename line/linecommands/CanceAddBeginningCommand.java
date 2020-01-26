package fr.cnam.tp9.line.linecommands;



import fr.cnam.tp9.line.specification.ClonableLine;


public class CanceAddBeginningCommand extends CanceAddCommand {


    public CanceAddBeginningCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        line.addBeginning(this.getCarToInsert());
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return true;
    }
}
