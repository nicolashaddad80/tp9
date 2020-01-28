package fr.cnam.tp9.line.linecommands.cancelinecomm;

import fr.cnam.tp9.line.specification.ClonableLine;

public class CanceMoveRightCommand extends CancelableLinComm {

    public CanceMoveRightCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        super.executer();
        CancelableLinComm.clonableLine.moveRight();
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return CancelableLinComm.clonableLine.getCursorPos() < CancelableLinComm.clonableLine.getLength();
    }
}