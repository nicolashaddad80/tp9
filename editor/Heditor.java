package fr.cnam.tp9.editor;

import fr.cnam.tp9.command.Command;
import fr.cnam.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.tp9.editor.editorhistory.CommandHistory;
import fr.cnam.tp9.editor.editorhistory.LineCommandHistory;
import fr.cnam.tp9.line.Line;
import fr.cnam.tp9.menu.Entry;
import fr.cnam.tp9.printer.Printer;

import java.io.PrintStream;

public class Heditor extends Editor implements HisEditor {

    private CommandHistory undoHistory;
    private CommandHistory redoHistory;

    public Heditor(Line a_Line, Printer a_OutputArea) {
        super(a_Line,a_OutputArea);
        this.undoHistory = new LineCommandHistory();
        this.redoHistory = new LineCommandHistory();
        this.currentMenu.add(new Entry(-1,"Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new Entry(-2,"Redo", new RedoCommand(this), "+"));
    }

    @Override
    public CommandHistory getUndoHistory() {
        return this.undoHistory;
    }

    @Override
    public CommandHistory getRedoHistory() {
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
