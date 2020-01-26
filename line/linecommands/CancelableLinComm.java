/**
 * @(#) CancelableLinComm.java
 */

package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.command.specification.Cancelable;

public abstract class CancelableLinComm extends LineComm implements Cancelable
{

	
	public CancelableLinComm( ClonableLine a_ClonableLine )
	{
		super( a_ClonableLine);

	}


    public void undo( )
	{
		
	}



	/**
	 * to check if a command is cancellable inorder to save its context and to allow the invoker to save it in its commands history
	 */
	public boolean isCancellable( )
	{
		return false;
	}
	
	
}
