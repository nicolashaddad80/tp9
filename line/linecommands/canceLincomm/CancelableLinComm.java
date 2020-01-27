/**
 * @(#) CanceLinComm.java
 */

package fr.cnam.tp9.line.linecommands.canceLincomm;


import fr.cnam.tp9.history.HistoryImp;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.command.specification.Cancelable;


public abstract class CancelableLinComm  implements Cancelable
{



	protected static  History<ClonableLine> undoLineHistory;
	protected static ClonableLine clonableLine;

	/**
	 * Attributes
	 * @param
	 */

	public CancelableLinComm( ClonableLine a_clonableLine )
	{
		clonableLine=a_clonableLine;

		undoLineHistory=new HistoryImp<ClonableLine>();
	}


    public void undo( )
	{

		this.clonableLine=this.undoLineHistory.pull();
		this.clonableLine.getPrinter().print();
	}

	@Override
	public void executer() {

		/*
		saving line context
		 */

		this.undoLineHistory.push(clonableLine.lineClone());
	}

	/**
	 * to check if a command is cancellable inorder to save its context and to allow the invoker to save it in its commands history
	 */
	public boolean isCancellable( )
	{
		return true;
	}
	
	
}