package fr.cnam.tp9.editor.specification;

import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.history.specification.History;

public interface HisEditor extends Editor{
    void undo( );
    void redo( );

    History<Cancelable> getRedoHistory( );
    History<Cancelable> getUndoHistory( );



	void updateContext( ClonableLine a_previousLine );
	
	
}
