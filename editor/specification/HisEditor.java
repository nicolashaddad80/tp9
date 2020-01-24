package fr.cnam.tp9.editor.specification;

import fr.cnam.tp9.history.specification.History;

public interface HisEditor extends Editor{
    void undo();
    void redo();
    History getRedoHistory();
    History getUndoHistory();
}
