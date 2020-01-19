package fr.cnam.tp9;

abstract public class EditorCommand implements Command {
    HisEditor editor;

    public EditorCommand(HisEditor a_Editor){
        this.editor=a_Editor;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }
}
