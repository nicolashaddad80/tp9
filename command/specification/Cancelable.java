package fr.cnam.tp9.command.specification;

public interface Cancelable<Context> {
    void restoreContext( Context previousContext );

}
