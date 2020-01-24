package fr.cnam.tp9.command.specification;

public  interface Command {
    /**
     * Attributes
     */

    /**
     * Methods
     */

    public void executer();
    public boolean isExecutable();
    public boolean  isCancellable();
}
