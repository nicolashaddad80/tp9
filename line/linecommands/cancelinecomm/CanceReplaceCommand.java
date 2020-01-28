package fr.cnam.tp9.line.linecommands.cancelinecomm;

import fr.cnam.tp9.line.specification.ClonableLine;

public class CanceReplaceCommand extends CanceAddCommand {

    public CanceReplaceCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        super.executer();
        CancelableLinComm.clonableLine.replace(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return CancelableLinComm.clonableLine.getCursorPos() > 0;
    }
}