package fr.cnam.tp9.line.linecommands.cancelinecomm;

import fr.cnam.tp9.line.specification.ClonableLine;


public class CanceMoveBeginningCommand extends CancelableLinComm {

    public CanceMoveBeginningCommand(ClonableLine a_Line) {
        super(a_Line);
    }


    public void executer() {
        this.saveExecContext();
        CancelableLinComm.clonableLine.moveBeginning();
        CancelableLinComm.clonableLine.getPrinter().print();
    }


    @Override
    public final boolean isExecutable() {
        return CancelableLinComm.clonableLine.getCursorPos() > 1;
    }
}
