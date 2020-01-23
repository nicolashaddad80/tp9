package fr.cnam.tp9.specification.editor;

import fr.cnam.tp9.specification.history.History;

public interface HisEditor extends Editor{
    void undo();
    void redo();
    History getRedoHistory();
    History getUndoHistory();
}
