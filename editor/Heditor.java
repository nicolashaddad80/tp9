package fr.cnam.tp9.editor;

import fr.cnam.tp9.command.Command;
import fr.cnam.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.tp9.history.CommandHistory;
import fr.cnam.tp9.history.LineCommandHistory;
import fr.cnam.tp9.line.Line;
import fr.cnam.tp9.menu.Entry;

import java.io.PrintStream;

public class Heditor extends Editor implements HisEditor {

    private CommandHistory <Line> undoHistory;
    private CommandHistory <Line> redoHistory;

    public Heditor(Line a_Line, PrintStream a_heditorOutStream) {
        super(a_Line,a_heditorOutStream);
        this.undoHistory = new LineCommandHistory<Line>();
        this.redoHistory = new LineCommandHistory<Line>();
        this.currentMenu.add(new Entry(-1,"Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new Entry(-2,"Redo", new RedoCommand(this), "+"));
    }

    @Override
    public CommandHistory<Line> getUndoHistory() {
        return this.undoHistory;
    }

    @Override
    public CommandHistory<Line> getRedoHistory() {
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
        for (int i = 0; i < this.nbLineCommands; i++) this.lineCommandsTable[i].setLine(a_Line);
    }
}
