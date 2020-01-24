package fr.cnam.tp9.command;

public interface Cancelable <Context>{
    void restoreContext(Context previousContext);

}
