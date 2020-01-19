package fr.cnam.tp9;

abstract public class EditorCommand implements Command {
    HisEditor editor;
    protected  boolean executable = false;

    public EditorCommand(HisEditor a_Editor){
        this.editor=a_Editor;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }

    public void setExecutable(boolean a_Exec_Status){
        this.executable=a_Exec_Status;
    }
    @Override
    public boolean isExecutable() {
        return this.executable;
    }
}
