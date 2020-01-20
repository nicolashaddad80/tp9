package fr.cnam.tp9.editor.editorcommands;

import fr.cnam.tp9.command.Command;
import fr.cnam.tp9.editor.HisEditor;

abstract public class EditorCommand implements Command {
    public HisEditor editor;
    public boolean executable = false;

    public EditorCommand(HisEditor a_Editor){
        this.editor=a_Editor;
    }

    @Override
    public final boolean isCancellable() {
        return false;
    }

}
