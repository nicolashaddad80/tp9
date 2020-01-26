package fr.cnam.tp9.editor;

import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.editor.specification.HisEditor;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.line.specification.Line;
import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.menu.specification.Menu;
import fr.cnam.tp9.menu.EntryImp;
import fr.cnam.tp9.history.HistoryImp;

public class HistoryEditor extends SimpleEditor implements HisEditor {

    private History<Cancelable> undoHistory;
    private History<Cancelable> redoHistory;

    public int toto = 0;

    public HistoryEditor( Menu a_Menu, ClonableLine a_ClonableLine ) {
        super(a_Menu,a_ClonableLine);
        this.undoHistory = new HistoryImp<Cancelable>();
        this.redoHistory = new HistoryImp<Cancelable>();
        this.currentMenu.add(new EntryImp(-1,"Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new EntryImp(-2,"Redo", new RedoCommand(this), "+"));
    }


	@Override
	public History<Cancelable> getUndoHistory( ) {
        return this.undoHistory;
    }

    @Override
	public History<Cancelable> getRedoHistory( ) {
        return this.redoHistory;
    }

    @Override
	public void redo( ) {
/*
        Line previousLine = this.redoHistory.pull();
        this.undoHistory.push(this.line.clone());
        this.restoreLine(previousLine);

 */
    }

    @Override
	public void undo( ) {
        /*
        Line previousLine = this.undoHistory.pull();
        this.redoHistory.push(this.line.clone());
        this.restoreLine(previousLine);

         */
    }


    @Override
	protected void execute( Command a_Command ) {
        /*
        if (a_Command.isCancellable()) {
            this.undoHistory.push(this.line.clone());

        }
        super.execute(a_Command);

         */
    }
/*
    private void restoreLine( Line a_Line ) {
        this.line = a_Line;
        for (int i = 0; i < this.nbLineCommands; i++) ((LineComm)this.lineCommandsTable[i]).restoreContext(a_Line);
    }

 */



	private void restoreLine( Line a_Line )
	{
		
	}
	
	

	public void updateContext( ClonableLine a_previousLine )
	{
		
	}
	
	
}
