package fr.cnam.tp9.editor;

import fr.cnam.tp9.editor.editorhistory.CommandHistory;

public interface HisEditor {
    void undo();
    void redo();
    CommandHistory getRedoHistory();
    CommandHistory getUndoHistory();
}
