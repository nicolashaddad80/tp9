/**
 * @(#) CancelableLinComm.java
 */

package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.history.HistoryImp;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.line.specification.Line;

public abstract class CancelableLinComm extends LineComm implements Cancelable
{



	private History<ClonableLine> undoLineHistory;
	protected static ClonableLine clonableLine;

	/**
	 * Attributes
	 * @param
	 */

	public CancelableLinComm( ClonableLine a_clonableLine )
	{
		super(a_clonableLine);

		undoLineHistory=new HistoryImp<ClonableLine>();
	}


    public void undo( )
	{
		
	}

	@Override
	public void executer() {
		//Current Coding Cursor
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
