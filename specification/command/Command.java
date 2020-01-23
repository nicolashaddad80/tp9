package fr.cnam.tp9.specification.command;

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
