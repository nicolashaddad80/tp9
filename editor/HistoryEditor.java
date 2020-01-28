package fr.cnam.tp9.editor;

import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.editor.specification.HisEditor;
import fr.cnam.tp9.line.specification.ClonableLine;
import fr.cnam.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.tp9.history.specification.History;
import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.menu.specification.Menu;
import fr.cnam.tp9.menu.EntryImp;
import fr.cnam.tp9.history.HistoryImp;

public class HistoryEditor extends SimpleEditor implements HisEditor {

    private History<Cancelable> undoHistory;
    private History<Cancelable> redoHistory;


    public HistoryEditor(Menu a_Menu) {
        super(a_Menu);

        this.undoHistory = new HistoryImp<Cancelable>();
        this.redoHistory = new HistoryImp<Cancelable>();

        this.currentMenu.add(new EntryImp(-1, "Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new EntryImp(-2, "Redo", new RedoCommand(this), "+"));
    }


    @Override
    public History<Cancelable> getUndoHistory() {
        return this.undoHistory;
    }

    @Override
    public History<Cancelable> getRedoHistory() {
        return this.redoHistory;
    }

    @Override
    public void undo() {


        Cancelable previousCommand = this.undoHistory.pull();
        previousCommand.undo();

    }

    @Override
    public void redo() {
/*
        Line previousLine = this.redoHistory.pull();
        this.undoHistory.push(this.line.clone());
        this.restoreLine(previousLine);

 */
    }


    //TODO Arch++:delegate to a proxy in further version7@


    protected void execute(Cancelable a_Command) {

        if (a_Command.isExecutable()) {
            if (a_Command.isExecutable()) {

                a_Command.executer();
                /* if the command is Cancellable save command here for undo it later if the user chooses Undo from Menu
                 */
                if (a_Command.isCancellable()) {
                    this.undoHistory.push(a_Command);
                }
            }
        }
    }


    @Override
    public void editer() {
        do {

            this.currentMenu.getPrinter().print();

            Entry choice = this.currentMenu.proposer();

            if (choice.isMenu()) {
                this.currentMenu = (Menu) choice;
            } else {
                //TODO Arch++:delegate to a proxy in further version
                //TODO casting without check but we already know that we aonly instered Cancellable commands, =>TryCatch or Reachitecture to have less Exception to through
                this.execute((Cancelable)choice.getCommand());
            }
        } while (!this.currentMenu.choiceIsQuit());
    }




/*
	private void restoreLine( Line a_Line )
	{

	}

*/

    public void updateContext(ClonableLine a_previousLine) {

    }


}
