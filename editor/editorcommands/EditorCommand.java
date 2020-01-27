package fr.cnam.tp9.editor.editorcommands;

import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.editor.specification.HisEditor;
import fr.cnam.tp9.command.specification.Command;

public abstract class EditorCommand implements Cancelable {
    public HisEditor editor;
    public boolean executable = false;

    public EditorCommand( HisEditor a_Editor ){
        this.editor=a_Editor;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }
}
