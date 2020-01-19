package fr.cnam.tp9.editor;

import fr.cnam.tp9.line.Line;

public interface CommandHistory {
    public void push(Line a_Element);
    public Line pull();
    public boolean isEmpty();

}
