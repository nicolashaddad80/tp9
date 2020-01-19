package fr.cnam.tp9;

public class Heditor extends Editor implements HisEditor {
    CommandHistory  history;
    public Heditor(Line a_Line){
        super(a_Line);
        this.history=new LineCommandHistory();
        this.currentMenu.add(new Entry("Undo",new UndoCommand(this),"-"));
    }
    @Override
    public void undo() {
        this.line=this.history.pull();
    }


    @Override
    protected void execute(Command a_Command) {
        if(a_Command.isCancellable()){
                this.history.push (this.line.clone());
        }
        super.execute(a_Command);
    }
}
