package fr.cnam.tp9.history.specification;

public interface History<T> {
    void push(T a_Element);

    T pull();

    boolean isEmpty();

}
