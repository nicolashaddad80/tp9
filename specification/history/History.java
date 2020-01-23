package fr.cnam.tp9.specification.history;

public interface History<T> {
    public void push(T a_Element);
    public T pull();
    public boolean isEmpty();

}
