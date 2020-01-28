package fr.cnam.tp9.line.linecommands.cancelinecomm;


import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.history.HistoryImp;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.line.specification.ClonableLine;


public abstract class CancelableLinComm implements Cancelable {
    /**
     * Attributes
     */
    protected static ClonableLine clonableLine;
    protected static History<ClonableLine> undoLineHistory = new HistoryImp<>();
    protected static History<ClonableLine> redoLineHistory = new HistoryImp<>();


    public CancelableLinComm(ClonableLine a_clonableLine) {

        CancelableLinComm.clonableLine = a_clonableLine;
    }


    public void undo() {
		ClonableLine lastExecutedLine = CancelableLinComm.undoLineHistory.pull();
        CancelableLinComm.redoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
		CancelableLinComm.clonableLine =lastExecutedLine;
		CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public void redo() {
        //Current Coding Cursor
		ClonableLine lastUndoneLine = CancelableLinComm.redoLineHistory.pull();
        CancelableLinComm.undoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
		CancelableLinComm.clonableLine = lastUndoneLine;
		CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public void executer() {

		/*
		saving line context
		 */

        CancelableLinComm.undoLineHistory.push(clonableLine.lineClone());
    }

    /**
     * to check if a command is cancellable inorder to save its context and to allow the invoker to save it in its commands history
     */
    public boolean isCancellable() {
        return true;
    }
}
