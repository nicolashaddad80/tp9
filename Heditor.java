package fr.cnam.tp9;

import fr.cnam.tp9_tris.MenuCommand;

public class Heditor extends Editor implements HisEditor {
    CommandHistory  history;
    UndoCommand undoCommand=new UndoCommand(this);
    public Heditor(Line a_Line){
        super(a_Line);
        this.history=new LineCommandHistory();
        this.currentMenu.add(new Entry("Undo",undoCommand,"-"));

    }
    @Override
    public void undo() {
        restoreLine(this.history.pull());
        undoCommand.setExecutable(!this.history.isEmpty());

    }


    @Override
    protected void execute(Command a_Command) {
        if(a_Command.isCancellable()){
                this.history.push (this.line.clone());
                undoCommand.setExecutable(true);
        }
        super.execute(a_Command);
    }

    protected void restoreLine(Line a_Line){
        this.line=a_Line;

        for(int i=0;i<this.nbLineCommands;i++) this.lineCommandsTable[i].setLine(a_Line);
    }
}
