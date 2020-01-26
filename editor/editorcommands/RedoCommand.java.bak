package fr.cnam.tp9.editor.editorcommands;

import fr.cnam.tp9.editor.specification.HisEditor;

public class RedoCommand extends EditorCommand {

    public RedoCommand( HisEditor a_Hiseditor ) {
        super(a_Hiseditor);
    }
    @Override
	public void executer( ) {
        this.editor.redo();
    }

    @Override
	public boolean isExecutable( ) {
        return (!this.editor.getRedoHistory().isEmpty());
    }
}
