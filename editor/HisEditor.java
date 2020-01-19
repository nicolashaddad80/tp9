package fr.cnam.tp9.editor;

public interface HisEditor {
    void undo();
    void redo();
    CommandHistory  getRedoHistory();
    CommandHistory getUndoHistory();
}
