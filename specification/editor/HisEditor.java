package fr.cnam.tp9.specification.editor;

import fr.cnam.tp9.history.CommandHistory;

public interface HisEditor extends Editor{
    void undo();
    void redo();
    CommandHistory getRedoHistory();
    CommandHistory getUndoHistory();
}
