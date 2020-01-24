package fr.cnam.tp9.editor;

import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.history.HistoryImp;
import fr.cnam.tp9.editor.specification.HisEditor;
import fr.cnam.tp9.line.specification.Line;
import fr.cnam.tp9.line.linecommands.LineComm;
import fr.cnam.tp9.menu.EntryImp;

import java.io.PrintStream;

public class HistoryEditor extends SimpleEditor implements HisEditor {

    private History<Line> undoHistory;
    private History<Line> redoHistory;

    public HistoryEditor(Line a_Line, PrintStream a_heditorOutStream) {
        super(a_Line,a_heditorOutStream);
        this.undoHistory = new HistoryImp<Line>();
        this.redoHistory = new HistoryImp<Line>();
        this.currentMenu.add(new EntryImp(-1,"Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new EntryImp(-2,"Redo", new RedoCommand(this), "+"));
    }

    @Override
    public History<Line> getUndoHistory() {
        return this.undoHistory;
    }

    @Override
    public History<Line> getRedoHistory() {
        return this.redoHistory;
    }

    @Override
    public void redo() {

        Line previousLine = this.redoHistory.pull();
        this.undoHistory.push(this.line.clone());
        this.restoreLine(previousLine);
    }

    @Override
    public void undo() {
        Line previousLine = this.undoHistory.pull();
        this.redoHistory.push(this.line.clone());
        this.restoreLine(previousLine);
    }


    @Override
    protected void execute(Command a_Command) {
        if (a_Command.isCancellable()) {
            this.undoHistory.push(this.line.clone());

        }
        super.execute(a_Command);
    }

    private void restoreLine(Line a_Line) {
        this.line = a_Line;
        for (int i = 0; i < this.nbLineCommands; i++) ((LineComm)this.lineCommandsTable[i]).restoreContext(a_Line);
    }
}
