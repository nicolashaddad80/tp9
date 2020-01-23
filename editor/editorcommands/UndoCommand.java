package fr.cnam.tp9.editor.editorcommands;

import fr.cnam.tp9.specification.editor.HisEditor;

public class UndoCommand extends EditorCommand {

    public UndoCommand(HisEditor a_Hiseditor) {
        super(a_Hiseditor);
    }
    @Override
    public void executer() {
        this.editor.undo();
    }

    @Override
    public boolean isExecutable() {
        return (!this.editor.getUndoHistory().isEmpty());
    }
}
