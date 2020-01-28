package fr.cnam.tp9.line.linecommands.cancelinecomm;

import fr.cnam.tp9.line.specification.ClonableLine;

public class CanceAddEndCommand extends CanceAddCommand {


    public CanceAddEndCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        super.executer();
        CancelableLinComm.clonableLine.addEnd(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return true;
    }
}