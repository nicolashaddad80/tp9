package fr.cnam.tp9;

public interface HisEditor {
    void undo();
    void redo();
    CommandHistory  getRedoHistory();
    CommandHistory getUndoHistory();
}
