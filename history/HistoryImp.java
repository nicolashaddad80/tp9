package fr.cnam.tp9.history;

import fr.cnam.tp9.history.specification.History;

import java.util.Stack;

public class HistoryImp<T> implements History<T> {

    private Stack<T> linesStack;
    public HistoryImp(){
        this.linesStack= new Stack<T>();
   }

    @Override
    public void push(T a_Line) {
        this.linesStack.push(a_Line);
    }

    @Override
    public T pull() {
        return (T)this.linesStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.linesStack.isEmpty();
    }
}
