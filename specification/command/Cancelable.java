package fr.cnam.tp9.specification.command;

public interface Cancelable <Context>{
    void restoreContext(Context previousContext);

}
