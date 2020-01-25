package fr.cnam.tp9.command.specification;

public interface Command {
    /**
     * Attributes
     */

    /**
	 * Methods
	 */
	void executer( );
    boolean isExecutable( );
    boolean isCancellable( );
}
