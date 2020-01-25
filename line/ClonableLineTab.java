/**
 * @(#) ClonableLineTab.java
 */

package fr.cnam.tp9.line;

import java.io.PrintStream;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.line.specification.Line;

public class ClonableLineTab extends LineTab implements ClonableLine
{
	/**
	 * Constructeur de notre ligne  "ligne vide a la créationé
	 * 
	 * @param a_lineOutStream
	 */
	public ClonableLineTab( PrintStream a_lineOutStream ) {
		super(a_lineOutStream);
	}
	@Override
	public ClonableLine lineClone( )
	{
		return null;
	}
	

	@Override
	public Line clone( )
	{
		return null;
	}
	
	
}
