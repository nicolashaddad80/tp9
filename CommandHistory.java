package fr.cnam.tp9;

public interface CommandHistory {
    public void push(Line a_Element);
    public Line pull();
    public boolean isEmpty();

}
