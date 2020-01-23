package fr.cnam.tp9.history;

public interface CommandHistory<T> {
    public void push(T a_Element);
    public T pull();
    public boolean isEmpty();

}
